package com.DnDSuite.model;

import com.DnDSuite.controller.parser.Parser;
import com.DnDSuite.view.campaignGUI.CampaignGUI;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class Campaign {

    public CampaignData data;
    //public static final String SAMPLE_XLSX_FILE_PATH = "sample.xlsx";
    private Workbook workbook;

    public Campaign(File dataFile){

        data = new CampaignData();

        try {
            workbook = WorkbookFactory.create(dataFile);
            Parser parser = new Parser(workbook,data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CampaignGUI front= new CampaignGUI(this);
        front.setVisible(true);
    }

}
