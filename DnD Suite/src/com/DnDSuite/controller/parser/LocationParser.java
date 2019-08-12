package com.DnDSuite.controller.parser;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Location;
import com.DnDSuite.model.Quest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class LocationParser {

    private DataFormatter dataFormatter;


    public LocationParser(){
        dataFormatter = new DataFormatter();
    }

    public ArrayList<Location> parse(Sheet sheet) {

        ArrayList<Location> locations = new ArrayList<>();

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            String line = "";
            for (Cell cell : row) {
                line += dataFormatter.formatCellValue(cell) + ",";
            }
            String[] rowCells = line.split(",");

            Location newLocation = new Location(rowCells[0], rowCells[2], rowCells[3], rowCells[4]);
            locations.add(newLocation);
        }

            System.out.println("Parsed Locations...");
        return locations;
    }

    public void parseConnections(Sheet sheet, CampaignData data){

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);

            Location tempLocation = null;
            for(Location l: data.getLocations()) {
                if (l.getName().equals(String.valueOf(row.getCell(0))))
                    tempLocation = l;
            }

            if(!row.getCell(1).equals("None")) {

                Location within = null;
                for(Location l:data.getLocations())
                    if(l.getName().equals(String.valueOf(row.getCell(1))))
                        within=l;


            tempLocation.setWithin(within);
            }

            if(!row.getCell(5).equals("None")) {

                String[] quests = String.valueOf(row.getCell(5)).split("\\) ");
                for (int j = 1; j < quests.length; j++) {
                    quests[j] = quests[j].trim();
                    for (Quest q : data.getQuests()) {
                        if (q.getName().equals(quests[j]))
                            tempLocation.getQuests().add(q);
                    }
                }
            }
        }

        System.out.println("Parsed Locations-Within...");
        System.out.println("Parsed Locations-Quests...");
    }
}
