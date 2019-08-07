package com.DnDSuite.model;

import com.DnDSuite.controller.parser.Parser;
import com.DnDSuite.view.campaignGUI.CampaignGUI;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class Campaign {

    public CampaignData data;
    private File dataFile;
    private Workbook workbook;

    public Campaign(File dataFile) {

        this.data = new CampaignData();
        this.dataFile = dataFile;

        try {
            workbook = WorkbookFactory.create(dataFile);
            Parser parser = new Parser(workbook,data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CampaignGUI campaignGUI= new CampaignGUI(this);
        campaignGUI.setVisible(true);
    }

}

