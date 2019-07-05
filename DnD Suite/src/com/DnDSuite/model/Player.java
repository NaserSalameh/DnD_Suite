package com.DnDSuite.model;

public class Player extends Creature {

    private String player;

    public Player(String name, String race, String player,Stat playerStat){
        super(name,race,playerStat);
        this.player = player;
    }

    public Player(String name, String race, String player){
        super(name,race);
        this.player = player;
    }

    public String getPlayer(){return this.player;}

    public void setPlayer(String player) {this.player = player;}
}
