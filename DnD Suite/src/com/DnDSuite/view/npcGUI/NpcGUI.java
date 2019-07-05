package com.DnDSuite.view.npcGUI;

import com.DnDSuite.controller.creatureController.NpcController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class NpcGUI extends JPanel {

    private JList npcList;
    private JPanel npcPanel;
    private JPanel npcPortrait;
    private JPanel npcStats;
    private JPanel npcDetails;
    private JTextField nameTextField;
    private JTextField raceTextField;
    private JTextField npcTextField;
    private JPanel npcDescription;
    private JButton newButton;
    private JButton editButton;
    private JTextField expTextField;
    private JTextField constitutionTextField;
    private JTextField speedTextField;
    private JTextField strengthTextField;
    private JTextField wisdomTextField;
    private JTextField charismaTextField;
    private JTextField descriptionTextField;
    private JTextField healthTextField;
    private JTextField initiativeTextField;
    private JTextField dexterityTextField;
    private JTextField intelligenceTextField;
    private JPanel rootPanel;
    private JTextField levelTextField;


    public NpcGUI(){

        add(rootPanel);

        HashMap<String,JTextField> textFields = new HashMap<String, JTextField>();

        textFields.put("name",nameTextField);
        textFields.put("race",raceTextField);
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

        NpcController npcController = new NpcController(npcList,textFields);

        DefaultListModel model = (DefaultListModel) npcList.getModel();

        npcList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                npcController.setTextFields((String) npcList.getSelectedValue());
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                npcController.newCreature();
                model.add(model.getSize(), nameTextField.getText());
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                npcController.editCreature();
            }
        });
    }

    public JPanel getRootPanel(){ return rootPanel;}
}
