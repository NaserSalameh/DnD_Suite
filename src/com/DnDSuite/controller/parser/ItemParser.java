package com.DnDSuite.controller.parser;

import com.DnDSuite.model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class ItemParser {

    private DataFormatter dataFormatter;

    public ItemParser(){
        dataFormatter = new DataFormatter();
    }

    public ArrayList<Item> parse(Sheet sheet, CampaignData data) {

        ArrayList<Item> items = new ArrayList<>();

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            String line = "";
            for (Cell cell : row) {
                line += dataFormatter.formatCellValue(cell) + "===";
            }
            String[] rowCells = line.split("===");
            Item newItem = new Item(rowCells[0], rowCells[1],rowCells[2], rowCells[3]);

            items.add(newItem);
        }

        //System.out.println("Parsed Items...");
        return items;
    }

    public void parseConnections(Sheet sheet, CampaignData data){

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);

            Item tempItem = null;
            for(Item it : data.getItems())
                if(it.getName().equals(String.valueOf(row.getCell(0))))
                    tempItem = it;

            if(!row.getCell(4).equals("None")) {
                Player tempPlayer= null;
                for (Player p : data.getPlayers())
                    if(p.getName().equals(String.valueOf(row.getCell(4))))
                        tempPlayer = p;

                tempItem.setOwner(tempPlayer);
            }
        }
        //System.out.println("Parsed Item-Owners...");
    }

}