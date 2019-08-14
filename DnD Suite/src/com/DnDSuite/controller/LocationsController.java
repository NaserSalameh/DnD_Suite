package com.DnDSuite.controller;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Location;
import com.DnDSuite.model.Quest;
import com.DnDSuite.view.locationsGUI.LocationsGUI;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class LocationsController {

    private JTree locationsTree;
    private HashMap<String, JTextField> textFields;
    private JList questsList;
    private JLabel locationPicture;
    private JLabel locationMap;
    private JComboBox withinComboBox;
    DefaultListModel model;
    DefaultTreeModel treeModel;


    private CampaignData data;

    public LocationsController(LocationsGUI locationsGUI, CampaignData data){

        this.data = data;

        this.locationsTree = locationsGUI.getLocationsTree();
        this.textFields = locationsGUI.getTextFields();
        this.questsList = locationsGUI.getQuestsList();
        this.locationPicture = locationsGUI.getLocationPicture();
        this.locationMap = locationsGUI.getLocationMap();
        this.withinComboBox = locationsGUI.getWithinComboBox();

        model = new DefaultListModel();
        this.questsList.setModel(model);

        this.treeModel = (DefaultTreeModel) locationsTree.getModel();


        setLocationsTree();
        initialiseComboBoxes();
        setFields(data.getLocations().get(0).getName());
    }

    private void setLocationsTree(){
        DefaultMutableTreeNode world = new DefaultMutableTreeNode(data.getLocations().get(0).getName());
        treeModel.setRoot(world);

        ArrayList<Location> locations =new ArrayList<>();

        for(Location l: data.getLocations())
            locations.add(l);

        locations.remove(0);

        Enumeration e = world.breadthFirstEnumeration();

            while(!locations.isEmpty()) {
                while (e.hasMoreElements()) {
                    DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) e.nextElement();
                    for (int i = 0; i < locations.size(); i++) {
                        if (locations.get(i).getWithin().getName().equals(String.valueOf(currentNode))) {
                            currentNode.add(new DefaultMutableTreeNode(locations.get(i).getName()));
                            locations.remove(i);
                        }
                    }
                }
                e=world.breadthFirstEnumeration();
            }
    }

    private void initialiseComboBoxes(){

        for (int i = 0; i < data.getLocations().size(); i++)
            withinComboBox.addItem(data.getLocations().get(i).getName());

    }

    public void setFields(String locationName){
        Location selectedLocation = null;

        for(Location l: data.getLocations())
            if(l.getName().equals(locationName))
                selectedLocation = l;

        textFields.get("location").setText(selectedLocation.getName());

        if(selectedLocation.getWithin()!=null)
            for(int i = 0; i< withinComboBox.getItemCount(); i++) {
            if (withinComboBox.getItemAt(i).equals(selectedLocation.getWithin().getName()))
                withinComboBox.setSelectedIndex(i);
            }
        else
            withinComboBox.setSelectedIndex(0);

        textFields.get("equivalent").setText(String.valueOf(selectedLocation.getEquivalent()));
        textFields.get("climate").setText(String.valueOf(selectedLocation.getClimate()));
        textFields.get("features").setText(String.valueOf(selectedLocation.getFeatures()));

        model.removeAllElements();
        for(Quest q: selectedLocation.getQuests())
            model.add(model.getSize(), q.getName());


        if(selectedLocation.getPicture()!=null) {
            locationPicture.setIcon(new ImageIcon(selectedLocation.getPicture()));
        }
        else
            locationPicture.setIcon(null);

        if(selectedLocation.getMap()!=null) {
            locationMap.setIcon(new ImageIcon(selectedLocation.getMap()));
        }
        else
            locationMap.setIcon(null);

    }

    private Location createLocation(){
        String name = textFields.get("location").getText(),
                equivalent = textFields.get("equivalent").getText(),
                climate = textFields.get("climate").getText(),
                features = textFields.get("features").getText();

        Location within = null;
        for(Location l : data.getLocations())
            if(l.getName().equals(withinComboBox.getSelectedIndex()))
                within = l;

        Location newLocation = new Location(name,within,equivalent,climate,features);

        return newLocation;
    }

    public void newLocation(){
        Location newLocation = createLocation();

        DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
        Enumeration e = root.breadthFirstEnumeration();
        while(e.hasMoreElements()) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) e.nextElement();
            if (currentNode.equals(newLocation.getWithin().getName()));
                currentNode.add(new DefaultMutableTreeNode(newLocation.getName()));
        }

    }

    public void removeLocation(String locationName, DefaultMutableTreeNode locationNode){

        for(Location l : data.getLocations())
            if(l.getName().equals(locationName)) {
                data.getLocations().remove(l);
                treeModel.removeNodeFromParent(locationNode);
            }

    }




}
