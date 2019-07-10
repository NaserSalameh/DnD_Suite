package com.DnDSuite.controller.parser;

import com.DnDSuite.model.CampaignData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class Parser {

    public static final String SAMPLE_XLSX_FILE_PATH = "sample.xlsx";

    CampaignData data;

    protected PlayerParser playerParser;
    protected RaceParser raceParser;
    protected ClassParser classParser;

    public Parser(CampaignData data) throws IOException {

        this.data = data;

        classParser = new ClassParser();
        playerParser = new PlayerParser();
        raceParser = new RaceParser();
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));


        for(Sheet sheet: workbook) {
            if(sheet.getSheetName().equals("Players"))
                data.setPlayers(playerParser.parse(sheet));
            else if(sheet.getSheetName().equals("Races"))
                data.setRaces(raceParser.parse(sheet));
            else if(sheet.getSheetName().equals("Classes")) {
                data.setClasses(classParser.parseClasses(sheet));
                data.setSubClasses(classParser.parseSubClasses(sheet));
            }

        }



    }
}