package com.DnDSuite.model;

import java.util.ArrayList;

public class Quest {


    private String name;
    private ArrayList<Location> locations;
    private ArrayList<Npc> npcs;
    private String description;

    public Quest(String name, String description){
        this.name = name;
        this.description = description;

        this.locations=new ArrayList<>();
        this.npcs = new ArrayList<>();
    }

    public String getName() { return this.name;}

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Npc> getNpcs() {
        return npcs;
    }

    public void setNpcs(ArrayList<Npc> npcs) {
        this.npcs = npcs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
