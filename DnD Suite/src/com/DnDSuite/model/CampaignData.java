package com.DnDSuite.model;

import java.util.ArrayList;

public class CampaignData {

    private ArrayList<String> races;
    private ArrayList<String> classes;
    private ArrayList<String> subClasses;
    private ArrayList<Player> players;
    private ArrayList<Npc> npcs;
    private ArrayList<Item> items;

    public CampaignData(){
        races = new ArrayList<>();
        classes = new ArrayList<>();
        subClasses = new ArrayList<>();
        players = new ArrayList<>();
        npcs = new ArrayList<>();
        items = new ArrayList<>();
    }

    public ArrayList<String> getRaces(){ return this.races;}

    public void setRaces(ArrayList<String> races){this.races = races;}

    public ArrayList<String> getClasses(){ return this.classes;}

    public void setClasses(ArrayList<String> classes){this.classes = classes;}

    public ArrayList<String> getSubClasses(){ return this.subClasses;}

    public void setSubClasses(ArrayList<String> subClasses){this.subClasses = subClasses;}

    public ArrayList<Player> getPlayers(){ return this.players;}

    public void setPlayers(ArrayList<Player> players){this.players = players;}

    public ArrayList<Npc> getNpcs(){ return this.npcs;}

    public void setNpcs(ArrayList<Npc> npcs){this.npcs = npcs;}

    public ArrayList<Item> getItems(){ return this.items;}

    public void setItems(ArrayList<Item> items){this.items = items;}

}
