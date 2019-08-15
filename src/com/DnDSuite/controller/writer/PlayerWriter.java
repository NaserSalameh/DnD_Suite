package com.DnDSuite.controller.writer;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Player;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class PlayerWriter {

    public PlayerWriter(){

    }

    public String write(Sheet sheet, CampaignData data, CellStyle headerCellStyle){

        String[] playersColumn = {"Name","Race","Class","Subclass", "Player", "Level", "Exp", "Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma", "Health", "Speed", "Initiative"};
        Row playersHeader = sheet.createRow(0);

        for(int i = 0; i < playersColumn.length; i++) {
            Cell cell = playersHeader.createCell(i);
            cell.setCellValue(playersColumn[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowCount=1;

        for(Player p: data.getPlayers()){
            Row row = sheet.createRow(rowCount++);

            row.createCell(0).setCellValue(p.getName());
            row.createCell(1).setCellValue(p.getRace());
            row.createCell(2).setCellValue(p.getCreatureClass());
            row.createCell(3).setCellValue(p.getCreatureSubClass());
            row.createCell(4).setCellValue(p.getPlayer());
            row.createCell(5).setCellValue(p.getStat().getLevel());
            row.createCell(6).setCellValue(p.getStat().getExp());
            row.createCell(7).setCellValue(p.getStat().getStrength());
            row.createCell(8).setCellValue(p.getStat().getDexterity());
            row.createCell(9).setCellValue(p.getStat().getConstitution());
            row.createCell(10).setCellValue(p.getStat().getIntelligence());
            row.createCell(11).setCellValue(p.getStat().getWisdom());
            row.createCell(12).setCellValue(p.getStat().getCharisma());
            row.createCell(13).setCellValue(p.getStat().getHealth());
            row.createCell(14).setCellValue(p.getStat().getSpeed());
            row.createCell(15).setCellValue(p.getStat().getInitiative());

        }

        for(int i = 0; i < playersColumn.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return("Saved Players...");
    }
}
