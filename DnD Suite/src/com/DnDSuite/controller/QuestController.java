package com.DnDSuite.controller;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Npc;
import com.DnDSuite.model.Location;
import com.DnDSuite.model.Quest;
import com.DnDSuite.view.questsAddEditGUI.QuestsAddEditGUI;
import com.DnDSuite.view.questsGUI.QuestsGUI;

import javax.swing.*;
import java.util.ArrayList;

public class QuestController {

    private JList questsList;
    private JList locationsList;
    private JList npcsList;
    private DefaultListModel questsModel;
    private DefaultListModel locationsModel;
    private DefaultListModel npcsModel;

    private JList npcsNotInQuestList;
    private JList npcsInQuestList;
    private JList locationsNotInQuestList;
    private JList locationsInQuestList;
    private DefaultListModel npcsNotInQuestModel;
    private DefaultListModel npcsInQuestModel;
    private DefaultListModel locationsNotInQuestModel;
    private DefaultListModel locationsInQuestModel;

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

         npcsModel.removeAllElements();
         for(Npc n: selectedQuest.getNpcs())
             npcsModel.add(npcsModel.getSize(),n.getName());

         locationsModel.removeAllElements();
         for(Location l: selectedQuest.getLocations())
            locationsModel.add(locationsModel.getSize(),l.getName());

         descriptionPane.setText(selectedQuest.getDescription());
    }

    public void attachQuestAddEditGUI(QuestsAddEditGUI questsAddEditGUI){
        this.npcsNotInQuestList = questsAddEditGUI.getNpcsNotInQuestList();
        this.npcsInQuestList = questsAddEditGUI.getNpcsInQuestList();
        this.locationsNotInQuestList = questsAddEditGUI.getLocationsNotInQuestList();
        this.locationsInQuestList = questsAddEditGUI.getLocationsInQuestList();

        npcsNotInQuestModel = new DefaultListModel();
        npcsNotInQuestList.setModel(npcsNotInQuestModel);
        npcsInQuestModel = new DefaultListModel();
        npcsInQuestList.setModel(npcsInQuestModel);
        locationsNotInQuestModel = new DefaultListModel();
        locationsNotInQuestList.setModel(locationsNotInQuestModel);
        locationsInQuestModel = new DefaultListModel();
        locationsInQuestList.setModel(locationsInQuestModel);

        setQuestsAddEditGUILists();
    }

    private void setQuestsAddEditGUILists(){
        for(Npc n: data.getNpcs())
            npcsNotInQuestModel.add(npcsNotInQuestModel.getSize(),n.getName());

        for(Location l: data.getLocations())
            locationsNotInQuestModel.add(locationsNotInQuestModel.getSize(),l.getName());

    }

    public void moveNpcs(JList fromList, JList toList, int index){

        DefaultListModel fromModel = (DefaultListModel) fromList.getModel();

        DefaultListModel toModel = (DefaultListModel) toList.getModel();

        toModel.add(toModel.getSize(),fromModel.getElementAt(index));
        fromModel.remove(index);
    }

    public Quest createQuest(){

        return new Quest(questsName.getText(),descriptionPane.getText());

    }

    public void newQuest(){

        Quest newQuest = createQuest();

        ArrayList npcs = new ArrayList();
        for(int i=0;i<npcsInQuestModel.getSize();i++){
            for(Npc n: data.getNpcs())
                if(n.getName().equals(String.valueOf(npcsInQuestModel.getElementAt(i))))
                    npcs.add(n);
        }
        newQuest.setNpcs(npcs);

        ArrayList locations = new ArrayList();
        for(int i=0;i<locationsInQuestModel.getSize();i++){
            for(Location l: data.getLocations())
                if(l.getName().equals(String.valueOf(locationsInQuestModel.getElementAt(i))))
                    locations.add(l);
        }
        newQuest.setLocations(locations);

        data.getQuests().add(newQuest);
        questsModel.add(questsModel.getSize(),newQuest.getName());
    }

    public void editQuest(String questName,int index){

        newQuest();

        Quest temp = null;

        for(Quest q: data.getQuests())
            if(q.getName().equals(questName)){
                temp=q;
            }

        data.getQuests().remove(temp);
        questsModel.remove(index);


    }


}
