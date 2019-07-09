package com.DnDSuite.model;

import com.DnDSuite.controller.parser.Parser;
import com.DnDSuite.view.frontGUI.FrontGUI;

import java.io.IOException;

public class Campaign {

    public CampaignData data;

    public Campaign(){

        data = new CampaignData();

        try {
            Parser parser = new Parser(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FrontGUI front= new FrontGUI(this);
        front.setVisible(true);
    }

}
