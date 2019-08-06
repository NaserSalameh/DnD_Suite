package com.DnDSuite.view.frontGUI;

import com.DnDSuite.controller.FrontController;
import com.DnDSuite.model.Campaign;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontGUI extends JFrame{

    private JPanel rootPanel;
    private JButton selectFile;
    private JTextArea textArea;

    public FrontGUI(){

        setTitle("DnD Suite");
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea("Welcome!");

        selectFile = new JButton("Select File");
        add(selectFile);

        FrontController frontController = new FrontController();
        setVisible(true);

        selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Campaign campaign = new Campaign(frontController.selectFile());
                dispose();
            }
        });

    }

}
