package com.DnDSuite.controller.writer;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Location;
import com.DnDSuite.model.Npc;
import com.DnDSuite.model.Quest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class QuestWriter {

    public QuestWriter(){

    }

    public String write(Sheet sheet, CampaignData data, CellStyle headerCellStyle){

        String[] questsColumns = {"Quest","Location","NPCs","Description"};
        Row questsHeader = sheet.createRow(0);

        for(int i = 0; i < questsColumns.length; i++) {
            Cell cell = questsHeader.createCell(i);
            cell.setCellValue(questsColumns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowCount=1;

        for(Quest q: data.getQuests()){
            Row row = sheet.createRow(rowCount++);

            row.createCell(0).setCellValue(q.getName());

            String locations="";
            for(Location l: q.getLocations())
                locations+=l.getName()+"\n";

            row.createCell(1).setCellValue(locations);

            String npcs="";
            for(Npc n: q.getNpcs())
                npcs+=n.getName()+"\n";

            row.createCell(2).setCellValue(npcs);
            row.createCell(3).setCellValue(q.getDescription());
        }

        for(int i = 0; i < questsColumns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return("Saved Quests...");
    }
}
