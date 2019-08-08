package com.DnDSuite.view.frontGUI;

import com.DnDSuite.controller.loaderController;
import com.DnDSuite.model.Campaign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrontGUI extends JFrame{

    private JPanel rootPanel;
    private JButton selectFile;
    private JTextArea textArea;

    public FrontGUI(){

        setTitle("DnD Suite");
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rootPanel = new JPanel(new GridLayout(2,1));
        add(rootPanel);

        textArea = new JTextArea("Welcome!");
        rootPanel.add(textArea);

        selectFile = new JButton("Select File");
        rootPanel.add(selectFile);

        loaderController loaderController = new loaderController();
        setVisible(true);

        selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File campaignFile = loaderController.selectFile();
                Campaign campaign = new Campaign(campaignFile.getName(),campaignFile);
                dispose();
            }
        });

    }

}
