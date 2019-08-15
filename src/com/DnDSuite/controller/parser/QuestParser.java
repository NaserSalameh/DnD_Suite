package com.DnDSuite.controller.parser;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Npc;
import com.DnDSuite.model.Quest;
import com.DnDSuite.model.Location;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class QuestParser {

    private DataFormatter dataFormatter;
    private CampaignData data;

    public QuestParser(){
        dataFormatter = new DataFormatter();
        this.data = data;
    }

    public ArrayList<Quest> parse(Sheet sheet, CampaignData data){

        ArrayList<Quest> quests = new ArrayList<>();

        for(int i =1; i< sheet.getPhysicalNumberOfRows();i++) {
            Row row = sheet.getRow(i);
            String line = "";
            for (Cell cell : row) {
                line += dataFormatter.formatCellValue(cell) + "===";
            }

            String[] rowCells = line.split("===");

            Quest quest = new Quest(rowCells[0], rowCells[3]);



            quests.add(quest);
        }
        //System.out.println("Parsed Quests...");
        return quests;
    }

    public void parseConnections(Sheet sheet, CampaignData data){

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            Quest tempQuest = null;
            for(Quest q: data.getQuests())
                if(q.getName().equals(String.valueOf(row.getCell(0))))
                    tempQuest = q;

            String[] locations = String.valueOf(row.getCell(1)).split("\\) ");
            for (int j = 1; j < locations.length; j++) {
                locations[j]=locations[j].trim();
                for (Location l : data.getLocations())
                    if(l.getName().equals(locations[j]))
                        tempQuest.getLocations().add(l);
            }

            if(!row.getCell(2).equals("None")) {
                String[] npcs = String.valueOf(row.getCell(2)).split("\\) ");
                for (int j = 1; j < npcs.length; j++) {
                    npcs[j] = npcs[j].trim();
                    for (Npc n : data.getNpcs())
                        if (n.getName().equals(npcs[j]))
                            tempQuest.getNpcs().add(n);
                }
            }

        }
        //System.out.println("Parsed Quest-Locations...");
        //System.out.println("Parsed Quest-NPCs...");
    }


}
