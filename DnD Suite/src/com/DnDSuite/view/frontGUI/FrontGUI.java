package com.DnDSuite.view.frontGUI;

import com.DnDSuite.view.diceRollerGUI.DiceRollerGUI;
import com.DnDSuite.view.initiativeGUI.InitiativeGUI;

import javax.swing.*;

public class FrontGUI extends JFrame {

    private JPanel rootPanel;
    private JTabbedPane tabbedPane;
    private DiceRollerGUI diceRollerGUI;
    private InitiativeGUI initiativeGUI;

    public FrontGUI(){

        //rootPanel = new JPanel();
        //add(rootPanel);
        setTitle("DnD Suite");
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
       // rootPanel.add(tabbedPane);
        add(tabbedPane);
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);

        diceRollerGUI = new DiceRollerGUI();
        tabbedPane.add("Dice Roller", diceRollerGUI.getRootPanel());

        initiativeGUI = new InitiativeGUI();
        tabbedPane.add("Initiative", initiativeGUI.getRootPanel());

    }

}
