package com.DnDSuite.controller;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Item;
import com.DnDSuite.model.Player;
import com.DnDSuite.view.itemsGUI.ItemsGUI;

import javax.swing.*;
import java.util.HashMap;

public class ItemController {

    private JList itemsList;
    private DefaultListModel model;
    private HashMap<String, JTextField> textFields;
    private JComboBox rarityComboBox;
    private JComboBox ownerComboBox;
    private JTextPane descriptionPane;
    private JLabel itemPictue;

    private CampaignData data;

    public ItemController(ItemsGUI itemsGUI, CampaignData data){

        this.data = data;

        this.itemsList = itemsGUI.getItemsList();
        this.textFields = itemsGUI.getTextFields();
        this.rarityComboBox = itemsGUI.getRarityComboBox();
        this.ownerComboBox = itemsGUI.getOwnerComboBox();
        this.descriptionPane = itemsGUI.getDescriptionPane();
        this.itemPictue = itemsGUI.getItemPicture();

        model = new DefaultListModel();
        itemsList.setModel(model);

        for(Item i: data.getItems())
            model.add(model.getSize(),i.getName());

        initialiseComboBoxes();
        //setFields(data.getItems().get(0).getName());
    }

    private void initialiseComboBoxes(){

        String[] rarities = {"Common" , "Uncommon", "Rare", "Very Rare", "Legendary", "Artifact"};
        for (int i = 0; i < rarities.length; i++)
            rarityComboBox.addItem(rarities[i]);

        ownerComboBox.addItem("None");

        for (int i = 0; i < data.getPlayers().size(); i++)
            ownerComboBox.addItem(data.getPlayers().get(i).getName());

    }

    public void setFields(String itemName){
        Item selectedItem = null;

        for(Item i : data.getItems())
            if(i.getName().equals(itemName))
                selectedItem = i;

        textFields.get("name").setText(selectedItem.getName());
        descriptionPane.setText(selectedItem.getDescription());
        textFields.get("attributes").setText(String.valueOf(selectedItem.getAttributes()));

        for(int i = 0; i< rarityComboBox.getItemCount(); i++){
            if(rarityComboBox.getItemAt(i).equals(selectedItem.getRarity()))
                rarityComboBox.setSelectedIndex(i);
        }

        for(int i = 0; i< ownerComboBox.getItemCount(); i++){
            if(ownerComboBox.getItemAt(i).equals(selectedItem.getOwner()))
                ownerComboBox.setSelectedIndex(i);
        }

        if(selectedItem.getPicture()!=null) {
            itemPictue.setIcon(new ImageIcon(selectedItem.getPicture()));
        }
        else
            itemPictue.setIcon(null);
    }

    private Item createItem() {
        String name = textFields.get("name").getText(),
                description = descriptionPane.getText(),
                attributes = textFields.get("attributes").getText(),
                rarity = rarityComboBox.getSelectedItem().toString(),
                owner = ownerComboBox.getSelectedItem().toString();

        Item newItem = new Item(name, description, attributes, rarity);

        if (!owner.equals("None")) {
            Player temp=null;
            for (Player p : data.getPlayers())
                if (p.getName().equals(owner))
                    temp = p;
                newItem.setOwner(temp);
        }
        return newItem;
    }

    public void newItem(){
        Item newItem = createItem();

        data.getItems().add(newItem);
        model.add(model.getSize(),newItem);
    }

    public void editItem(String itemName, int index) {

        newItem();

        Item temp = null;

        for (Item i : data.getItems())
            if (i.getName().equals(itemName)) {
                temp = i;
            }

        data.getItems().remove(temp);
        model.remove(index);

    }
}
