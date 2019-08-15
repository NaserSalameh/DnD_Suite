package com.DnDSuite.controller.writer;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Location;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class LocationWriter {

    public LocationWriter(){

    }

    public String write(Sheet sheet, CampaignData data, CellStyle headerCellStyle){

        String[] questsColumn = {"Location","Within","Equivalent","Climate", "Features", "Quests"};
        Row questsHeader = sheet.createRow(0);

        for(int i = 0; i < questsColumn.length; i++) {
            Cell cell = questsHeader.createCell(i);
            cell.setCellValue(questsColumn[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowCount=1;

        for(Location l: data.getLocations()){
            Row row = sheet.createRow(rowCount++);

            row.createCell(0).setCellValue(l.getName());
            //Make parse Secondary
//            row.createCell(1).setCellValue(l.getWithin().getName());
            row.createCell(2).setCellValue(l.getEquivalent());
            row.createCell(3).setCellValue(l.getClimate());
            row.createCell(4).setCellValue(l.getFeatures());

            //make parse secondary
//            String quests = "";
//            for(Quest q: l.getQuests())
//                quests+=q.getName()+"\n";
//
//            row.createCell(5).setCellValue(quests);
        }

        for(int i = 0; i < questsColumn.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return("Saved Locations...");
    }
}
