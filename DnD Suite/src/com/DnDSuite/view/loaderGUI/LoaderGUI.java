package com.DnDSuite.view.loaderGUI;

import com.DnDSuite.controller.loaderController;
import com.DnDSuite.controller.parser.ImageParser;
import com.DnDSuite.model.Campaign;
import com.DnDSuite.model.CampaignData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoaderGUI extends JPanel {

    private JPanel rootPanel;
    private JTextField loadCampaignLocation;
    private JTextField loadPicturesLocation;
    private JButton loadCampaignButton;
    private JButton loadPicturesButton;
    private JButton saveCampaignButton;
    private JTextField savePicturesLocation;
    private JButton savePicturesButton;
    private JTextArea notificationArea;
    private JTextField saveCampaignLocation;

    public LoaderGUI(CampaignData data, JFrame parentGUI){

        add(rootPanel);

        loaderController loaderController = new loaderController();

        loadCampaignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Campaign campaign = new Campaign(loaderController.selectFile());
                parentGUI.dispose();
            }
        });

        loadPicturesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageParser imageParser = new ImageParser(data, loaderController.selectFolder());
                imageParser.parsePlayersImages();
                imageParser.parseNpcImages();
                imageParser.parseItemImages();
                imageParser.parseLocationImages();
            }
        });


    }

    public JPanel getRootPanel(){return this.rootPanel;}

}
