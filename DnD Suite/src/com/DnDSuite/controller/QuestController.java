package com.DnDSuite.controller;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Npc;
import com.DnDSuite.model.Location;
import com.DnDSuite.model.Quest;
import com.DnDSuite.view.questsGUI.QuestsGUI;

import javax.swing.*;

public class QuestController {

    private JList questsList;
    private JList locationsList;
    private JList npcsList;
    private DefaultListModel questsModel;
    private DefaultListModel locationsModel;
    private DefaultListModel npcsModel;

    private JTextField questsName;
    private JTextPane descriptionPane;

    private CampaignData data;

    public QuestController(QuestsGUI questsGUI, CampaignData data){

        this.data = data;

        this.questsList = questsGUI.getQuestsList();
        this.locationsList = questsGUI.getLocationList();
        this.npcsList = questsGUI.getNpcList();

        questsModel = new DefaultListModel();
        questsList.setModel(questsModel);
        locationsModel = new DefaultListModel();
        locationsList.setModel(locationsModel);
        npcsModel = new DefaultListModel();
        npcsList.setModel(npcsModel);

        this.questsName = questsGUI.getNameTextField();
        this.descriptionPane = questsGUI.getDescriptionPane();

        for(Quest q: data.getQuests())
            questsModel.add(questsModel.getSize(), q.getName());

        setFields(data.getQuests().get(0).getName());
    }

    public void setFields(String questName) {

        Quest selectedQuest = null;

        for(Quest q: data.getQuests())
            if(q.getName().equals(questName))
                selectedQuest = q;

         questsName.setText(selectedQuest.getName());

         for(Npc n: selectedQuest.getNpcs())
             npcsModel.add(npcsModel.getSize(),n.getName());

         for(Location l: selectedQuest.getLocations())
            locationsModel.add(locationsModel.getSize(),l.getName());

         descriptionPane.setText(selectedQuest.getDescription());
    }

    //work on add and edit through new interface
//    public Quest createQuest(){
//
//        return null;
//    }
//
//
}
