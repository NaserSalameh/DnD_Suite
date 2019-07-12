package com.DnDSuite.view.playersGUI;

import com.DnDSuite.controller.PlayerController;
import com.DnDSuite.model.CampaignData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class PlayersGUI extends JPanel {

    private JList playersList;
    private JPanel playersPanel;
    private JLabel playerPortrait;
    private JPanel playerStats;
    private JPanel playerDetails;
    private JTextField nameTextField;
    private JTextField playerTextField;
    private JPanel playerDescription;
    private JButton newButton;
    private JButton editButton;
    private JTextField expTextField;
    private JTextField constitutionTextField;
    private JTextField speedTextField;
    private JTextField strengthTextField;
    private JProgressBar expProgressBar;
    private JTextField wisdomTextField;
    private JTextField charismaTextField;
    private JTextField descriptionTextField;
    private JTextField healthTextField;
    private JTextField initiativeTextField;
    private JTextField dexterityTextField;
    private JTextField intelligenceTextField;
    private JPanel rootPanel;
    private JTextField levelTextField;
    private JComboBox classComboBox;
    private JComboBox raceComboBox;
    private JComboBox subClassComboBox;
    private HashMap<String,JTextField> textFields;

    private CampaignData data;

    public PlayersGUI(CampaignData data){

        this.data = data;

        add(rootPanel);

        textFields = new HashMap<String, JTextField>();

        textFields.put("name",nameTextField);
        textFields.put("player",playerTextField);
        textFields.put("level",levelTextField);
        textFields.put("exp",expTextField);
        textFields.put("health",healthTextField);
        textFields.put("strength",strengthTextField);
        textFields.put("dexterity",dexterityTextField);
        textFields.put("constitution",constitutionTextField);
        textFields.put("intelligence",intelligenceTextField);
        textFields.put("wisdom",wisdomTextField);
        textFields.put("charisma",charismaTextField);
        textFields.put("speed",speedTextField);
        textFields.put("initiative",initiativeTextField);

        PlayerController playerController = new PlayerController(this,data);

        DefaultListModel model = (DefaultListModel) playersList.getModel();

        playersList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                playerController.setFields((String) playersList.getSelectedValue());
                playerController.setProgressBar(expProgressBar, (String) playersList.getSelectedValue());
            }
        });

        classComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerController.initialiseSubClasses(classComboBox.getSelectedItem().toString());
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerController.newPlayer();
                model.add(model.getSize(), nameTextField.getText());
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                playerController.editPlayer(nameTextField.getText(),playersList.getSelectedIndex());
            }
        });
    }

    public JPanel getRootPanel(){ return rootPanel;}

    public JList getPlayersList(){return this.playersList;}

    public JComboBox getRaceComboBox(){return this.raceComboBox;}

    public JComboBox getClassComboBox() {return this.classComboBox;}

    public JComboBox getSubClassComboBox() {return this.subClassComboBox;}

    public HashMap<String, JTextField> getTextfields(){ return this.textFields;}

    public JLabel getPlayerPortrait() { return  this.playerPortrait;}
}
