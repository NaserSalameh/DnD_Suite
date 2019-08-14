package com.DnDSuite.view.npcsGUI;

import com.DnDSuite.controller.NpcController;
import com.DnDSuite.model.CampaignData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class NpcsGUI extends JPanel{
    private JPanel rootPanel;
    private JList npcsList;
    private JPanel npcsPanel;
    private JLabel npcPortrait;
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
    private HashMap<String,JTextField> textFields;

    private CampaignData data;

    public NpcsGUI(CampaignData data){

        this.data = data;

        add(rootPanel);

        textFields = new HashMap<String, JTextField>();

        textFields.put("name",nameTextField);
        textFields.put("age", ageTextfield);
        textFields.put("description", descriptionTextField);
        textFields.put("session", sessionTextField);

        NpcController npcController = new NpcController(this, data);

        DefaultListModel model = (DefaultListModel) npcsList.getModel();

        npcsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(npcsList.getSelectedIndex()!=-1)
                    npcController.setFields(String.valueOf(npcsList.getSelectedValue()));
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
                npcController.editNpc(String.valueOf(npcsList.getSelectedValue()),npcsList.getSelectedIndex());
            }
        });

    }

    public JPanel getRootPanel(){ return rootPanel;}

    public JList getNpcsList(){return this.npcsList;}

    public JComboBox getRaceComboBox(){return this.raceComboBox;}

    public JComboBox getLocationComboBox() {return this.locationComboBox;}

    public HashMap<String, JTextField> getTextfields(){ return this.textFields;}

    public JLabel getNpcPortrait() { return this.npcPortrait;}

    public JTextPane getNpcRole() { return this.npcRole;}

}
