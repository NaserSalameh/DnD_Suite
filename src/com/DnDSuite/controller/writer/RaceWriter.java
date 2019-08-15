package com.DnDSuite.controller.writer;

import com.DnDSuite.model.CampaignData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class RaceWriter {

    public RaceWriter(){

    }

    public String write(Sheet sheet, CampaignData data, CellStyle headerCellStyle){

        String[] raceColumn = {"Race"};
        Row raceHeader = sheet.createRow(0);

        for(int i = 0; i < raceColumn.length; i++) {
            Cell cell = raceHeader.createCell(i);
            cell.setCellValue(raceColumn[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowCount=1;

        for(String r: data.getRaces()) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(r);
        }

        for(int i = 0; i < raceColumn.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return("Saved Races...");
    }
}
