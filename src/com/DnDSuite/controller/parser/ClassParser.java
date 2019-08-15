package com.DnDSuite.controller.parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.HashMap;

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

    public HashMap<String, ArrayList<String>> parseSubClasses(Sheet sheet) {

        HashMap<String,ArrayList<String>> classSubClasses = new HashMap<>();
        ArrayList<String> subClasses;
        for (Row row : sheet) {
            subClasses = new ArrayList<>();
            for (Cell cell : row) {
                subClasses.add(dataFormatter.formatCellValue(cell));
            }
            String cl = subClasses.get(0);
            subClasses.remove(0);
            classSubClasses.put(cl, subClasses);
        }
        //System.out.println("Parsed Classes...");
        return classSubClasses;
    }
}
