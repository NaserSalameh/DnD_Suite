package com.DnDSuite.controller.writer;

import com.DnDSuite.model.CampaignData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class ClassWriter {

    public ClassWriter(){

    }

    public String write(Sheet sheet, CampaignData data, CellStyle headerCellStyle){

        String[] classColumn = {"Class","Subclass1","Subclass1","Subclass2", "Subclass3", "Subclass4", "Subclass5", "Subclass6", "Subclass7", "Subclass8", "Subclass9", "Subclass10", "Subclass11", "Subclass12", "Subclass13", "Subclass14"};
        Row classHeader = sheet.createRow(0);

        for(int i = 0; i < classColumn.length; i++) {
            Cell cell = classHeader.createCell(i);
            cell.setCellValue(classColumn[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowCount=1;

        for(int i=1;i<data.getClasses().size();i++){
            Row row = sheet.createRow(rowCount++);

            row.createCell(0).setCellValue(data.getClasses().get(i));

            ArrayList<String> subclasses = data.getSubClasses().get(data.getClasses().get(i));

            int cellCount = 1;
            for(String s: subclasses){
                row.createCell(cellCount++).setCellValue(s);
            }
        }

        for(int i = 0; i < classColumn.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return("Saved Classes...");
    }
}
