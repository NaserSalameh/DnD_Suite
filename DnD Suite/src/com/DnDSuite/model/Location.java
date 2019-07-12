package com.DnDSuite.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Location {

    private String name;
    private Location within;
    private String equivalent;
    private String climate;
    private String features;
    private ArrayList<Quest> quests;
    private ArrayList<Npc> npcs;
    private BufferedImage picture;
    private BufferedImage map;

    public Location(String name,Location Within, String equivalent, String climate, String features){

        this.name = name;
        this.within = within;
        this.equivalent = equivalent;
        this.climate = climate;
        this.features = features;

    }

    public Location(String name, String equivalent, String climate, String features){

        this.name = name;
        this.equivalent = equivalent;
        this.climate = climate;
        this.features = features;

    }

    public Location(String name, String equivalent, String climate, String features, BufferedImage picture, BufferedImage map){

        this.name = name;
        this.equivalent = equivalent;
        this.climate = climate;
        this.features = features;
        this.picture = picture;
        this.map = map;

    }

    public String getName(){ return this.name; }

    public void setName(String name){ this.name = name; }

    public Location getWithin() {return this.within;}

    public void setWithin(Location within){ this.within = within;}

    public String getEquivalent(){ return this.equivalent; }

    public void setEquivalent(String equivalent){ this.equivalent = equivalent; }

    public String getFeatures(){ return this.features; }

    public void setFeatures(String features){ this.features = features; }

    public String getClimate(){ return this.climate; }

    public void setClimate(String climate){ this.climate = climate; }

    public ArrayList<Quest> getQuests(){ return this.quests; }

    public void addQuest(Quest quest){ this.quests.add(quest); }

    public ArrayList<Npc> getNpcs(){ return this.npcs; }

    public void addNpc(Npc npc){ this.npcs.add(npc); }

    public BufferedImage getPicture(){ return this.picture; }

    public void setPicture(BufferedImage picture){ this.picture = picture; }

    public BufferedImage getMap(){ return this.map; }

    public void setMap(BufferedImage map){ this.map = map; }
}