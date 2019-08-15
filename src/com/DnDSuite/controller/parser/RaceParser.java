package com.DnDSuite.controller.parser;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class RaceParser {

    private DataFormatter dataFormatter;

    public RaceParser(){
        dataFormatter = new DataFormatter();
    }

    public ArrayList<String> parse(Sheet sheet){

        ArrayList<String> races = new ArrayList<>();

        for (Row row: sheet) {
            races.add(dataFormatter.formatCellValue(row.getCell(0)));
        }
        //System.out.println("Parsed Races...");
        return races;
    }

}
