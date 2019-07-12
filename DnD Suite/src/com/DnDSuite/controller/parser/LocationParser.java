package com.DnDSuite.controller.parser;

import com.DnDSuite.model.Location;
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
            Location location = null;
            if(rowCells[1].equals("None")) {
                location = new Location(rowCells[0], rowCells[2], rowCells[3], rowCells[4]);
                locations.add(location);
            }
            else{
                Location within = locations.get(0);
                location = new Location(rowCells[0], within,rowCells[2], rowCells[3], rowCells[4]);
                locations.add(location);
            }
        }
        System.out.println("Parsed NPCs...");
        return locations;
    }
}
