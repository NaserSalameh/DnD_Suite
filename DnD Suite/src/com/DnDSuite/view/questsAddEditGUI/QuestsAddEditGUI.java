package com.DnDSuite.view.questsAddEditGUI;

import com.DnDSuite.controller.QuestController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuestsAddEditGUI extends JFrame{
    private JPanel rootPanel;
    private JList npcsNotInQuestList;
    private JButton doneButton;
    private JList npcsInQuestList;
    private JList locationsNotInQuestList;
    private JList locationsInQuestList;

    public QuestsAddEditGUI(QuestController questController,String operation, String questName, int questIndex){

        setTitle(operation + "Quest");
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(rootPanel);
        questController.attachQuestAddEditGUI(this);

        npcsNotInQuestList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    if (index >= 0)
                    questController.moveNpcs(npcsNotInQuestList,npcsInQuestList, index);
                }
            }
        });

        npcsInQuestList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    if (index >= 0)
                        questController.moveNpcs(npcsInQuestList,npcsNotInQuestList, index);
                }
            }
        });

        locationsNotInQuestList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    if (index >= 0)
                    questController.moveNpcs(locationsNotInQuestList,locationsInQuestList, index);
                }
            }
        });

        locationsInQuestList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    if (index >= 0)
                    questController.moveNpcs(locationsInQuestList,locationsNotInQuestList, index);
                }
            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(operation.equals("Add"))
                    questController.newQuest();
                else if(operation.equals("Edit"))
                    questController.editQuest(questName,questIndex);

                dispose();
            }
        });

        setVisible(true);
    }

    public JList getNpcsNotInQuestList(){return this.npcsNotInQuestList;}

    public JList getNpcsInQuestList(){return this.npcsInQuestList;}

    public JList getLocationsNotInQuestList(){return this.locationsNotInQuestList;}

    public JList getLocationsInQuestList(){return this.locationsInQuestList;}
}
