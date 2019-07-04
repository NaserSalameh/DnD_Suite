package com.DnDSuite.view.playersGUI;

import com.DnDSuite.controller.PlayersController;
import com.DnDSuite.model.Player;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayersGUI extends JPanel {



    private JList playerList;
    private JPanel playerPanel;
    private JPanel playerPortrait;
    private JPanel playerStats;
    private JPanel playerDetails;
    private JTextField nameTextField;
    private JTextField raceTextField;
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


    public PlayersGUI(){

        add(rootPanel);


        HashMap<String,JTextField> textFields = new HashMap<String, JTextField>();

        textFields.put("name",nameTextField);
        textFields.put("race",raceTextField);
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

        PlayersController playersController = new PlayersController(playerList,textFields);

        playerList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                playersController.setTextFields((Player)playerList.getSelectedValue());
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public JPanel getRootPanel(){ return rootPanel;}

}
