package com.DnDSuite.view.frontGUI;

import com.DnDSuite.model.Campaign;
import com.DnDSuite.view.diceRollerGUI.DiceRollerGUI;
import com.DnDSuite.view.initiativeGUI.InitiativeGUI;
import com.DnDSuite.view.itemsGUI.ItemsGUI;
import com.DnDSuite.view.locationsGUI.LocationsGUI;
import com.DnDSuite.view.npcsGUI.NpcsGUI;
import com.DnDSuite.view.playersGUI.PlayersGUI;

import javax.swing.*;

public class FrontGUI extends JFrame {

    private Campaign campaign;

    private JPanel rootPanel;
    private JTabbedPane tabbedPane;
    private DiceRollerGUI diceRollerGUI;
    private InitiativeGUI initiativeGUI;
    private PlayersGUI playersGUI;
    private NpcsGUI npcGUI;
    private LocationsGUI locationsGUI;
    private ItemsGUI itemsGUI;

    public FrontGUI(Campaign campaign){

        this.campaign= campaign;

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

        initiativeGUI = new InitiativeGUI(campaign.data.getPlayers());
        tabbedPane.add("Initiative", initiativeGUI.getRootPanel());

        playersGUI = new PlayersGUI(campaign.data);
        tabbedPane.add("Players", playersGUI.getRootPanel());

        npcGUI = new NpcsGUI(campaign.data);
        tabbedPane.add("NPCs", npcGUI.getRootPanel());

        locationsGUI = new LocationsGUI(campaign.data);
        tabbedPane.add("Locations", locationsGUI.getRootPanel());

        itemsGUI = new ItemsGUI(campaign.data);
        tabbedPane.add("Items", itemsGUI.getRootPanel());

    }

}
