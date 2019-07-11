package com.DnDSuite.model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private String race;
    private BufferedImage portrait;
    private String creatureClass;
    private String creatureSubClass;
    private String player;
    private Stat stat;


    public Player(String name, String race, String creatureClass, String creatureSubClass,String player,Stat playerStat, BufferedImage portrait){

        super(name);
        this.race = race;
        this.creatureClass=creatureClass;
        this.creatureSubClass = creatureSubClass;
        this.portrait = portrait;

        this.stat=playerStat;
        this.player = player;
    }

    public Player(String name, String race, String creatureClass, String creatureSubClass,String player,Stat playerStat){

        super(name);
        this.race = race;
        this.creatureClass=creatureClass;
        this.creatureSubClass = creatureSubClass;

        this.stat=playerStat;
        this.player = player;
    }

    public Player(String name, String race, String creatureClass, String creatureSubClass, String player){

        super(name);

        this.race = race;
        this.creatureClass = creatureClass;
        this.creatureSubClass = creatureSubClass;

        int[] abilities = {10,10,10,10,10,10};
        this.stat= new Stat(1,0,abilities,10,30,0);
        this.player = player;
    }

    public String getRace() { return this.race; }

    public void setRace(String race){this.race = race;}

    public Image getPortrait(){ return this.portrait;}

    public void setPortrait(BufferedImage portrait){ this.portrait = portrait; }

    public String getCreatureClass(){return this.creatureClass;}

    public void setCreatureClass(String creatureClass){ this.creatureClass = creatureClass; }

    public String getCreatureSubClass(){return this.creatureSubClass;}

    public void setCreatureSubClass(String creatureSubClass){ this.creatureSubClass = creatureSubClass;}

    public String getPlayer(){return this.player;}

    public void setPlayer(String player) {this.player = player;}

    public Stat getStat(){
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
