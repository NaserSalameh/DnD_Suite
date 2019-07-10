package com.DnDSuite.view.npcGUI;

import com.DnDSuite.controller.NpcController;
import com.DnDSuite.model.CampaignData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class NpcGUI extends JPanel{
    private JPanel rootPanel;
    private JList npcsList;
    private JPanel npcsPanel;
    private JPanel npcPortrait;
    private JButton newButton;
    private JButton editButton;
    private JPanel npcInfo;
    private JTextPane npcRole;
    private JPanel npcInfo2;
    private JPanel npcRoleLabel;
    private JTextField nameTextField;
    private JTextField sessionTextField;
    private JTextField descriptionTextField;
    private JTextField ageTextfield;
    private JComboBox raceComboBox;
    private JComboBox locationComboBox;

    private CampaignData data;

    public NpcGUI(CampaignData data){

        this.data = data;

        add(rootPanel);

        HashMap<String,JTextField> textFields = new HashMap<String, JTextField>();

        textFields.put("name",nameTextField);
        textFields.put("age", ageTextfield);
        textFields.put("description", descriptionTextField);
        textFields.put("session", sessionTextField);

        NpcController npcController = new NpcController(data,npcsList,textFields,raceComboBox,locationComboBox,npcRole);

        DefaultListModel model = (DefaultListModel) npcsList.getModel();

        npcsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                npcController.setFields((String) npcsList.getSelectedValue());
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                npcController.newNpc();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                npcController.editNpc(nameTextField.getText(),npcsList.getSelectedIndex());
            }
        });

    }

    public JPanel getRootPanel(){ return rootPanel;}

}
