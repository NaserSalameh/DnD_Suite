package com.DnDSuite.view.locationsGUI;

import com.DnDSuite.controller.LocationsController;
import com.DnDSuite.model.CampaignData;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.util.HashMap;

public class LocationsGUI extends JPanel{
    private JTree locationsTree;
    private JPanel rootPanel;
    private JPanel locationDetails;
    private JTextField locationJTextField;
    private JTextField equivalentJTextField;
    private JTextField climateJTextField;
    private JTextField featuresJTextField;
    private JList questsList;
    private JLabel questsJList;
    private JLabel locationPortrait;
    private JButton editButton;
    private JButton addButton;
    private JLabel locationMap;
    private HashMap<String,JTextField> textFields;

    private CampaignData data;

    public LocationsGUI(CampaignData data){

        this.data = data;

        add(rootPanel);

        textFields = new HashMap<String, JTextField>();

        textFields.put("location",locationJTextField);
        textFields.put("equivalent", equivalentJTextField);
        textFields.put("climate", climateJTextField);
        textFields.put("features", featuresJTextField);

        LocationsController locationsController = new LocationsController(this, data);

        locationsTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                String selectedLocation =locationsTree.getLastSelectedPathComponent().toString();
                locationsController.setFields(selectedLocation);
            }
        });

    }

    public JPanel getRootPanel(){ return this.rootPanel;}

    public JTree getLocationsTree(){ return this.locationsTree;}

    public HashMap<String, JTextField> getTextFields(){ return this.textFields;}

    public JList getQuestsList(){ return this.questsList;}

    public JLabel getLocationPicture(){ return this.locationPortrait;}

    public JLabel getLocationMap() { return this.locationMap;}

}
