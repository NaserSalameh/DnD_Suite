package com.DnDSuite.controller;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Npc;
import com.DnDSuite.model.Location;
import com.DnDSuite.view.npcsGUI.NpcsGUI;

import javax.swing.*;
import java.util.HashMap;

public class NpcController {

    private JList npcsList;
    private DefaultListModel model;
    private HashMap<String, JTextField> textFields;
    private JComboBox raceComboBox;
    private JComboBox locationComboBox;
    private JTextPane role;
    private JLabel npcPortrait;

    private CampaignData data;

    public NpcController(NpcsGUI npcGUI, CampaignData data){

        this.data = data;

        this.npcsList = npcGUI.getNpcsList();
        this.textFields = npcGUI.getTextfields();
        this.raceComboBox = npcGUI.getRaceComboBox();
        this.locationComboBox = npcGUI.getLocationComboBox();
        this.role = npcGUI.getNpcRole();
        this.npcPortrait = npcGUI.getNpcPortrait();

        model = new DefaultListModel();
        this.npcsList.setModel(model);

        for(Npc n: data.getNpcs())
            model.add(model.getSize(),n.getName());

        initialiseComboBoxes();
        //setFields(data.getNpcs().get(0).getName());
    }

    private void initialiseComboBoxes(){

        for (int i = 0; i < data.getRaces().size(); i++)
            raceComboBox.addItem(data.getRaces().get(i));

        for (int i = 0; i < data.getLocations().size(); i++)
            locationComboBox.addItem(data.getLocations().get(i).getName());
    }

    public void setFields(String npcName){
        Npc selectedNpc = null;

        for(Npc n: data.getNpcs())
            if(n.getName().equals(npcName))
                selectedNpc = n;

         textFields.get("name").setText(selectedNpc.getName());

        for(int i = 0; i< raceComboBox.getItemCount(); i++){
            if(raceComboBox.getItemAt(i).equals(selectedNpc.getRace()))
                raceComboBox.setSelectedIndex(i);
        }

        for(int i = 0; i< locationComboBox.getItemCount(); i++){
            if(locationComboBox.getItemAt(i).equals(selectedNpc.getLocation().getName()))
                locationComboBox.setSelectedIndex(i);
        }

        textFields.get("age").setText(String.valueOf(selectedNpc.getAge()));
        textFields.get("description").setText(String.valueOf(selectedNpc.getDescription()));
        textFields.get("session").setText(String.valueOf(selectedNpc.getSession()));
        role.setText(selectedNpc.getRole());

        if(selectedNpc.getPortrait()!=null) {
            npcPortrait.setIcon(new ImageIcon(selectedNpc.getPortrait()));
        }
        else
            npcPortrait.setIcon(null);

    }

    private Npc createNpc(){
        String name = textFields.get("name").getText(),
                race = (String) raceComboBox.getSelectedItem(),
                description = textFields.get("description").getText(),
                session = textFields.get("description").getText(),
                role = textFields.get("description").getText(),
                location = (String) locationComboBox.getSelectedItem();

        int age = Integer.parseInt(textFields.get("age").getText());

        Npc newNpc = new Npc(name,race,age,description,session,role);

        Location temp=null;
        for (Location l : data.getLocations())
            if (l.getName().equals(location))
                temp = l;
            newNpc.setLocation(temp);

        return newNpc;
    }

    public void newNpc(){
        Npc newNpc = createNpc();

        data.getNpcs().add(newNpc);
        model.add(model.getSize(),newNpc.getName());
    }

    public void editNpc(String npcName, int index) {

        newNpc();

        Npc temp=null;

        for (Npc n : data.getNpcs())
            if (n.getName().equals(npcName)) {
                temp=n;

            }

        data.getNpcs().remove(temp);
        model.remove(index);
    }
}
