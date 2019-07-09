package com.DnDSuite.model;

public class Player extends Creature {

    private String player;

    public Player(String name, String race, String creatureClass,String player,Stat playerStat){
        super(name,race, creatureClass, playerStat);
        this.player = player;
    }

    public Player(String name, String race, String creatureClass, String player){
        super(name,race);
        this.player = player;
    }

    public String getPlayer(){return this.player;}

    public void setPlayer(String player) {this.player = player;}
}
