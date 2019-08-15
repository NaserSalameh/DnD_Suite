package com.DnDSuite.view.questsGUI;

import com.DnDSuite.controller.QuestController;
import com.DnDSuite.model.CampaignData;
import com.DnDSuite.view.questsAddEditGUI.QuestsAddEditGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestsGUI extends JPanel{
    private JPanel rootPanel;
    private JList questsList;
    private JTextField nameTextField;
    private JList locationList;
    private JTextPane descriptionPane;
    private JList npcList;
    private JButton addQuestButton;
    private JButton editQuestButton;
    private QuestController questController;

    private CampaignData data;

    public QuestsGUI(CampaignData data){
        this.data = data;

        add(rootPanel);

        questController = new QuestController(this,data);

        questsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(questsList.getSelectedIndex()!=-1)
                    questController.setFields(String.valueOf(questsList.getSelectedValue()));
            }
        });

        addQuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuestsAddEditGUI questsAddEditGUI = new QuestsAddEditGUI(questController,"Add",String.valueOf(questsList.getSelectedValue()),questsList.getSelectedIndex());
            }
        });


        editQuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuestsAddEditGUI questsAddEditGUI = new QuestsAddEditGUI(questController,"Edit",String.valueOf(questsList.getSelectedValue()),questsList.getSelectedIndex());
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

    public QuestController getQuestController(){return this.questController;}
}
