package com.DnDSuite.view.frontGUI;

import com.DnDSuite.controller.LoaderController;
import com.DnDSuite.model.Campaign;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrontGUIPanel extends JPanel{
    private JPanel rootPanel;
    private JTextArea welcomeTextArea;
    private JTextField newNameTextField;
    private JButton newButton;
    private JButton loadButton;

    public FrontGUIPanel(JFrame parent){

        add(rootPanel);

        LoaderController loaderController = new LoaderController();

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Campaign campaign = new Campaign(newNameTextField.getText());
                parent.dispose();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File campaignFile = loaderController.selectFile();
                Campaign campaign = new Campaign(campaignFile.getName(),campaignFile);
                parent.dispose();
            }
        });
    }

    public JPanel getRootPanel(){return this.rootPanel;}

}
