package com.DnDSuite.controller.writer;

import com.DnDSuite.model.CampaignData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {

    CampaignData data;

    private PlayerWriter playerWriter;
    private ClassWriter classWriter;
    private RaceWriter raceWriter;
    private NpcWriter npcWriter;
    private LocationWriter locationWriter;
    private ItemWriter itemWriter;
    private QuestWriter questWriter;

    public Writer(CampaignData data) {
        this.data = data;

        playerWriter = new PlayerWriter();
        classWriter = new ClassWriter();
        raceWriter = new RaceWriter();
        npcWriter = new NpcWriter();
        locationWriter = new LocationWriter();
        itemWriter = new ItemWriter();
        questWriter = new QuestWriter();
    }

    public String writeToFile(String location){

        //File newFile = new File(location + data.getCamapignName() + ".xlsx");
        Workbook workbook = new XSSFWorkbook();

        Sheet playersSheet = workbook.createSheet("Players");
        Sheet racesSheet = workbook.createSheet("Races");
        Sheet classesSheet = workbook.createSheet("Classes");
        Sheet npcsSheet = workbook.createSheet("NPCs");
        Sheet locationsSheet = workbook.createSheet("Locations");
        Sheet itemsSheet = workbook.createSheet("Items");
        Sheet questsSheet = workbook.createSheet("Quests");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        String progress = "";

        for (Sheet sheet : workbook) {
            if (sheet.getSheetName().equals("Players"))
                progress+= playerWriter.write(playersSheet, data, headerCellStyle) +"\n";

            else if(sheet.getSheetName().equals("Races"))
                progress+= raceWriter.write(racesSheet, data, headerCellStyle) +"\n";

            else if(sheet.getSheetName().equals("Classes"))
                progress+= classWriter.write(classesSheet, data, headerCellStyle) +"\n";

            else if(sheet.getSheetName().equals("NPCs"))
                progress+= npcWriter.write(npcsSheet, data, headerCellStyle) +"\n";

            else if(sheet.getSheetName().equals("Locations"))
                progress+= locationWriter.write(locationsSheet, data, headerCellStyle) +"\n";

            else if(sheet.getSheetName().equals("Items"))
                progress+= itemWriter.write(itemsSheet, data, headerCellStyle) +"\n";

            else if(sheet.getSheetName().equals("Quests"))
                progress+= questWriter.write(questsSheet, data, headerCellStyle) +"\n";
        }

        try {

            FileOutputStream newCampaignFile = new FileOutputStream(location+"\\"+data.getCamapignName());
            workbook.write(newCampaignFile);
            newCampaignFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        progress +="Save Complete!\n";
        return progress;
    }

}
