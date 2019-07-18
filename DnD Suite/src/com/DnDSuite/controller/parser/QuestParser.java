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

            String[] locations = rowCells[1].split("\\) ");
            for (int j = 1; j < locations.length; j++) {
                locations[j]=locations[j].substring(0,locations[j].length()-1);
                for (Location l : data.getLocations())
                    if(l.getName().equals(locations[j]))
                        quest.getLocations().add(l);
            }


            if(!rowCells[2].equals("None")) {
                String[] npcs = rowCells[2].split("\\) ");
                for (int j = 1; j < npcs.length; j++) {
                    npcs[j] = npcs[j].substring(0, npcs[j].length() - 1);
                    for (Npc n : data.getNpcs())
                        if (n.getName().equals(npcs[j]))
                            quest.getNpcs().add(n);
                }
            }
            quests.add(quest);
        }
        System.out.println("Parsed Quests...");
        return quests;
    }
}
