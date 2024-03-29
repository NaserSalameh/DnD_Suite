package com.DnDSuite.view.campaignGUI;

import com.DnDSuite.model.Campaign;
import com.DnDSuite.view.diceRollerGUI.DiceRollerGUI;
import com.DnDSuite.view.initiativeGUI.InitiativeGUI;
import com.DnDSuite.view.itemsGUI.ItemsGUI;
import com.DnDSuite.view.loaderGUI.LoaderGUI;
import com.DnDSuite.view.locationsGUI.LocationsGUI;
import com.DnDSuite.view.npcsGUI.NpcsGUI;
import com.DnDSuite.view.playersGUI.PlayersGUI;
import com.DnDSuite.view.questsGUI.QuestsGUI;

import javax.swing.*;

public class CampaignGUI extends JFrame {

    private Campaign campaign;

    private JPanel rootPanel;
    private JTabbedPane tabbedPane;
    private LoaderGUI loaderGUI;
    private DiceRollerGUI diceRollerGUI;
    private InitiativeGUI initiativeGUI;
    private PlayersGUI playersGUI;
    private NpcsGUI npcGUI;
    private LocationsGUI locationsGUI;
    private ItemsGUI itemsGUI;
    private QuestsGUI questsGUI;


    public CampaignGUI(Campaign campaign){

        this.campaign= campaign;

        //rootPanel = new JPanel();
        //add(rootPanel);
        setTitle("DnD Suite: " + campaign.getCampaignName());
        setSize(1000,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
       // rootPanel.add(tabbedPane);
        add(tabbedPane);
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);

        loaderGUI = new LoaderGUI(campaign.data,this);
        tabbedPane.add("Loader", loaderGUI.getRootPanel());

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

        questsGUI = new QuestsGUI(campaign.data);
        tabbedPane.add("Quests", questsGUI.getRootPanel());

    }

}
