package com.DnDSuite.controller.writer;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Item;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ItemWriter {

    public ItemWriter(){

    }

    public String write(Sheet sheet, CampaignData data, CellStyle headerCellStyle){

        String[] itemsColumn = {"Name","Description","Attributes","Rarity", "Owned By"};
        Row itemsHeader = sheet.createRow(0);

        for(int i = 0; i < itemsColumn.length; i++) {
            Cell cell = itemsHeader.createCell(i);
            cell.setCellValue(itemsColumn[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowCount=1;

        for(Item i: data.getItems()){
            Row row = sheet.createRow(rowCount++);

            row.createCell(0).setCellValue(i.getName());
            row.createCell(1).setCellValue(i.getDescription());
            row.createCell(2).setCellValue(i.getAttributes());
            row.createCell(3).setCellValue(i.getRarity());
            if(i.getOwner()!=null)
                row.createCell(4).setCellValue(i.getOwner().getName());
            else
                row.createCell(4).setCellValue("None");

        }

        for(int i = 0; i < itemsColumn.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return("Saved Items...");
    }
}
