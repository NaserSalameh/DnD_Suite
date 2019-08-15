package com.DnDSuite.view.frontGUI;

import javax.swing.*;

public class FrontGUI extends JFrame{

    private FrontGUIPanel frontGUIPanel;

    public FrontGUI(){

        setTitle("DnD Suite");
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        frontGUIPanel = new FrontGUIPanel(this);
        add(frontGUIPanel.getRootPanel());

        setVisible(true);

    }

}
