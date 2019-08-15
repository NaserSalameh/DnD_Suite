package com.DnDSuite.view.itemsGUI;

import com.DnDSuite.controller.ItemController;
import com.DnDSuite.model.CampaignData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ItemsGUI extends JPanel{
    private JList itemsList;
    private JPanel rootPanel;
    private JTextField nameTextField;
    private JTextField attributesTextField;
    private JTextPane descriptionPane;
    private JLabel itemPicture;
    private JComboBox ownerComboBox;
    private JComboBox rarityComboBox;
    private JButton editButton;
    private JButton newButton;
    private HashMap<String,JTextField> textFields;

    private CampaignData data;

    public ItemsGUI(CampaignData data){
        this.data = data;

        add(rootPanel);

        textFields = new HashMap<String, JTextField>();

        textFields.put("name", nameTextField);
        textFields.put("attributes", attributesTextField);

        ItemController itemController = new ItemController(this,data);

        itemsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                itemController.setFields(String.valueOf(itemsList.getSelectedValue()));
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemController.newItem();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemController.editItem(String.valueOf(itemsList.getSelectedValue()),itemsList.getSelectedIndex());
            }
        });

    }

    public JList getItemsList(){return this.itemsList;}

    public HashMap<String, JTextField> getTextFields(){ return this.textFields;}

    public JComboBox getRarityComboBox() {return this.rarityComboBox;}

    public JComboBox getOwnerComboBox() {return this.ownerComboBox;}

    public JTextPane getDescriptionPane() {return this.descriptionPane;}

    public JLabel getItemPicture() {return this.itemPicture;}

    public JPanel getRootPanel() { return this.rootPanel; }
}
