package com.DnDSuite.controller;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Location;
import com.DnDSuite.view.locationsGUI.LocationsGUI;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.HashMap;

public class LocationsController {

    private JTree locationsTree;
    private HashMap<String, JTextField> textFields;
    private JList questsList;
    private JLabel locationPicture;
    private JLabel locationMap;
    DefaultTreeModel treeModel;

    private CampaignData data;

    public LocationsController(LocationsGUI locationsGUI, CampaignData data){

        this.data = data;

        this.locationsTree = locationsGUI.getLocationsTree();
        this.textFields = locationsGUI.getTextFields();
        this.questsList = locationsGUI.getQuestsList();
        this.locationPicture = locationsGUI.getLocationPicture();
        this.locationMap = locationsGUI.getLocationMap();

         this.treeModel = (DefaultTreeModel) locationsTree.getModel();

        setLocationsTree();
        setFields(data.getLocations().get(0).getName());
    }

    private void setLocationsTree(){
       DefaultMutableTreeNode world = new DefaultMutableTreeNode(data.getLocations().get(0).getName());
        treeModel.setRoot(world);

        //better nesting needed
        for(int i=1;i<data.getLocations().size();i++){
//            if(data.getLocations().get(i).getWithin().getName().equals(world.toString())) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(data.getLocations().get(i).getName());
                treeModel.insertNodeInto(node, world, world.getChildCount());
  //          }
        }
    }

    public void setFields(String locationName){
        Location selectedLocation = null;

        for(Location l: data.getLocations())
            if(l.getName().equals(locationName))
                selectedLocation = l;

        textFields.get("location").setText(selectedLocation.getName());
        textFields.get("equivalent").setText(String.valueOf(selectedLocation.getEquivalent()));
        textFields.get("climate").setText(String.valueOf(selectedLocation.getClimate()));
        textFields.get("features").setText(String.valueOf(selectedLocation.getFeatures()));


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

//        DefaultListModel model = (DefaultListModel) questsList.getModel();
//        for(Quest q: selectedLocation.getQuests())
//            model.add(model.getSize(),q.getName());
//

    }

    private Location createLocation(){
        String name = textFields.get("name").getText(),
                equivalent = textFields.get("equivalent").getText(),
                climate = textFields.get("climate").getText(),
                features = textFields.get("features").getText();

        Location newLocation = new Location(name,equivalent,climate,features);

        return newLocation;
    }

    public void newLocation(DefaultMutableTreeNode within){
        Location newLocation = createLocation();

        for(Location l : data.getLocations())
            if(l.getName().equals(within.getUserObject()))
                newLocation.setWithin(l);

        data.getLocations().add(newLocation);

        DefaultMutableTreeNode node = new DefaultMutableTreeNode(newLocation.getName());
        treeModel.insertNodeInto(node, within, within.getChildCount());
    }

    public void editLocation(String locationName,DefaultMutableTreeNode locationNode, DefaultMutableTreeNode within){

        Location newLocation = createLocation();

        for(Location l : data.getLocations())
            if(l.getName().equals(locationName)) {
                data.getLocations().remove(l);
                treeModel.removeNodeFromParent(locationNode);
            }

        for(Location l : data.getLocations())
            if(l.getName().equals(within.getUserObject()))
                newLocation.setWithin(l);
        data.getLocations().add(newLocation);

        DefaultMutableTreeNode node = new DefaultMutableTreeNode(newLocation.getName());
        treeModel.insertNodeInto(node, within, within.getChildCount());

    }

}
