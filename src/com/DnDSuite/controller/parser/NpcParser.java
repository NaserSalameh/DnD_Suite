package com.DnDSuite.controller.parser;

import com.DnDSuite.model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class NpcParser {

    private DataFormatter dataFormatter;

        public NpcParser(){

            dataFormatter = new DataFormatter();
        }

        public ArrayList<Npc> parse(Sheet sheet, CampaignData data) {

            ArrayList<Npc> npcs = new ArrayList<>();

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                String line = "";
                for (Cell cell : row) {
                    line += dataFormatter.formatCellValue(cell) + "===";
                }
                String[] rowCells = line.split("===");

                Npc newNpc = new Npc(rowCells[0],rowCells[1],Integer.parseInt(rowCells[2]),rowCells[3],rowCells[4],rowCells[5]);

                npcs.add(newNpc);
            }

            //System.out.println("Parsed NPCs...");
            return npcs;
        }

        public void parseConnections(Sheet sheet, CampaignData data){

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                Npc tempNpc = null;
                for(Npc n: data.getNpcs())
                    if(n.getName().equals(String.valueOf(row.getCell(0))))
                        tempNpc = n;

                Location tempLocation= null;
                for (Location l : data.getLocations())
                    if (l.getName().equals(String.valueOf(row.getCell(6))))
                        tempLocation = l;

                tempNpc.setLocation(tempLocation);
            }
            //System.out.println("Parsed NPC-Locations...");
        }

}