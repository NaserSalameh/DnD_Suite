package com.DnDSuite.controller.parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class ClassParser {

    private DataFormatter dataFormatter;

    public ClassParser(){
        dataFormatter = new DataFormatter();
    }

    public ArrayList<String> parseClasses(Sheet sheet){

        ArrayList<String> classes = new ArrayList<>();

        for (Row row: sheet) {
            classes.add(dataFormatter.formatCellValue(row.getCell(0)));
        }
        return classes;
    }

    public ArrayList<String> parseSubClasses(Sheet sheet) {

        ArrayList<String> subClasses = new ArrayList<>();

        for (Row row : sheet) {
            for (Cell cell : row) {
                subClasses.add(dataFormatter.formatCellValue(row.getCell(0))+" - " + dataFormatter.formatCellValue(cell));
            }
        }
        return subClasses;
    }
}
