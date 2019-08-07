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
    private JButton loadCampaignButton;
    private JButton loadPicturesButton;
    private JButton saveCampaignButton;
    private JButton savePicturesButton;
    private JTextArea notificationArea;

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
                notificationArea.setText(notificationArea.getText() + imageParser.parsePlayersImages() + "\n");
                notificationArea.setText(notificationArea.getText() + imageParser.parseNpcImages() + "\n");
                notificationArea.setText(notificationArea.getText() + imageParser.parseLocationImages() + "\n");
                notificationArea.setText(notificationArea.getText() + imageParser.parseItemImages() + "\n");
            }
        });
    }

    public JPanel getRootPanel(){return this.rootPanel;}
}
