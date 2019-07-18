package com.DnDSuite.view.questsGUI;

import com.DnDSuite.controller.QuestController;
import com.DnDSuite.model.CampaignData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class QuestsGUI extends JPanel{
    private JPanel rootPanel;
    private JList questsList;
    private JTextField nameTextField;
    private JList locationList;
    private JTextPane descriptionPane;
    private JList npcList;
    private JButton addQuestButton;
    private JButton editQuestButton;

    private CampaignData data;

    public QuestsGUI(CampaignData data){
        this.data = data;

        add(rootPanel);

        QuestController questController = new QuestController(this,data);

        questsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                questController.setFields((String) questsList.getSelectedValue());
            }
        });
    }

    public JPanel getRootPanel(){ return this.rootPanel;}

    public JList getQuestsList() {
        return questsList;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JList getLocationList() {
        return locationList;
    }

    public JTextPane getDescriptionPane() {
        return descriptionPane;
    }

    public JList getNpcList() {
        return npcList;
    }
}
