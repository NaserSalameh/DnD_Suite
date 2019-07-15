package com.DnDSuite.controller.parser;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Item;
import com.DnDSuite.model.Player;
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
                line += dataFormatter.formatCellValue(cell) + ",";
            }
            String[] rowCells = line.split(",");
            Item item = null;

            if(!rowCells[4].equals("None")) {
                Player temp= null;
                for (Player p : data.getPlayers())
                temp=p;
                item = new Item(rowCells[0], rowCells[1],rowCells[2], rowCells[3], temp);
            }
            else
                item = new Item(rowCells[0], rowCells[1],rowCells[2], rowCells[3]);

            items.add(item);
        }

        System.out.println("Parsed Items...");
        return items;
    }
}