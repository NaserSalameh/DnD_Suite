package com.DnDSuite.controller.writer;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Npc;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class NpcWriter {

    public NpcWriter(){

    }

    public String write(Sheet sheet, CampaignData data, CellStyle headerCellStyle){

        String[] npcColumn = {"Name","Race","Age","Description", "Session", "Role", "Location"};
        Row npcHeader = sheet.createRow(0);

        for(int i = 0; i < npcColumn.length; i++) {
            Cell cell = npcHeader.createCell(i);
            cell.setCellValue(npcColumn[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowCount=1;

        for(Npc n: data.getNpcs()){
            Row row = sheet.createRow(rowCount++);

            row.createCell(0).setCellValue(n.getName());
            row.createCell(1).setCellValue(n.getRace());
            row.createCell(2).setCellValue(n.getAge());
            row.createCell(3).setCellValue(n.getDescription());
            row.createCell(4).setCellValue(n.getSession());
            row.createCell(5).setCellValue(n.getRole());
            //make parse secondary
            //row.createCell(6).setCellValue(n.getLocation().getName());
        }

        for(int i = 0; i < npcColumn.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return("Saved NPCs...");
    }
}
