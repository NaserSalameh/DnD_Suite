package com.DnDSuite.view.loaderGUI;

import com.DnDSuite.controller.loaderController;
import com.DnDSuite.controller.parser.ImageParser;
import com.DnDSuite.controller.writer.Writer;
import com.DnDSuite.model.Campaign;
import com.DnDSuite.model.CampaignData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoaderGUI extends JPanel {

    private JPanel rootPanel;
    private JButton loadCampaignButton;
    private JButton loadPicturesButton;
    private JButton saveCampaignButton;
    private JTextArea notificationArea;

    public LoaderGUI(CampaignData data, JFrame parentGUI){

        add(rootPanel);

        loaderController loaderController = new loaderController();

        loadCampaignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File campaignFile = loaderController.selectFile();
                Campaign campaign = new Campaign(campaignFile.getName(),campaignFile);
                parentGUI.dispose();
            }
        });

        loadPicturesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loadLocation = loaderController.selectFolder();
                ImageParser imageParser = new ImageParser(data, loadLocation);
                notificationArea.setText("Loading Pictures From" + loadLocation + "\n");
                notificationArea.setText(notificationArea.getText() + imageParser.parsePlayersImages() + "\n");
                notificationArea.setText(notificationArea.getText() + imageParser.parseNpcImages() + "\n");
                notificationArea.setText(notificationArea.getText() + imageParser.parseLocationImages() + "\n");
                notificationArea.setText(notificationArea.getText() + imageParser.parseItemImages() + "\n");
                notificationArea.setText(notificationArea.getText() + "Picture Load Complete!"+ "\n");
            }
        });

        saveCampaignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Writer writer = new Writer(data);
                String saveLocation= loaderController.selectFolder();
                notificationArea.setText("Saving Data to " + saveLocation +" \n");
                notificationArea.setText(notificationArea.getText()+ writer.writeToFile(saveLocation) + "\n");
            }
        });

    }

    public JPanel getRootPanel(){return this.rootPanel;}
}
