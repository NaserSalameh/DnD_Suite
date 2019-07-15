package com.DnDSuite.controller.parser;

import com.DnDSuite.model.CampaignData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class Parser {

    public static final String SAMPLE_XLSX_FILE_PATH = "sample.xlsx";

    CampaignData data;

    private ImageParser imageParser;

    protected RaceParser raceParser;
    protected ClassParser classParser;
    protected PlayerParser playerParser;
    protected NpcParser npcParser;
    protected LocationParser locationParser;
    protected ItemParser itemParser;

    public Parser(CampaignData data) throws IOException {

        this.data = data;

        imageParser = new ImageParser(data);

        classParser = new ClassParser();
        playerParser = new PlayerParser();
        raceParser = new RaceParser();
        npcParser = new NpcParser();
        locationParser = new LocationParser();
        itemParser = new ItemParser();

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));


        for(Sheet sheet: workbook) {
            if(sheet.getSheetName().equals("Players")){
                data.setPlayers(playerParser.parse(sheet));
                imageParser.parsePlayersImages();
            }
            else if(sheet.getSheetName().equals("Races"))
                data.setRaces(raceParser.parse(sheet));
            else if(sheet.getSheetName().equals("Classes")) {
                data.setClasses(classParser.parseClasses(sheet));
                data.setSubClasses(classParser.parseSubClasses(sheet));
            }
            //add a getLocation when ready
            else if(sheet.getSheetName().equals("NPCs")) {
                data.setNpcs(npcParser.parse(sheet));
                imageParser.parseNpcImages();
            }

            else if(sheet.getSheetName().equals("Locations")) {
                data.setLocations(locationParser.parse(sheet));
                imageParser.parseLocationImages();
            }

            else if(sheet.getSheetName().equals("Items")) {
                data.setItems(itemParser.parse(sheet,data));
                imageParser.parseItemImages();
            }

        }



    }
}