package com.DnDSuite.model;

import com.DnDSuite.controller.parser.Parser;
import com.DnDSuite.view.campaignGUI.CampaignGUI;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class Campaign {

    private String campaignName;

    public CampaignData data;
    private File dataFile;
    private Workbook workbook;

    public Campaign(String campaignName){
        this.campaignName = campaignName;
        this.data = new CampaignData(campaignName);

        setup();
    }

    public Campaign(String campaignName,File dataFile) {

        this.campaignName = campaignName;

        this.data = new CampaignData(campaignName);

        this.dataFile = dataFile;

        try {
            workbook = WorkbookFactory.create(dataFile);
            Parser parser = new Parser(workbook,data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setup();
    }

    private void setup(){
        CampaignGUI campaignGUI= new CampaignGUI(this);
        campaignGUI.setVisible(true);
    }

    public String getCampaignName() {
        return campaignName;
    }
}

