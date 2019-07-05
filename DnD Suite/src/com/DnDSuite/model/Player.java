package com.DnDSuite.model;

public class Player extends Entity {

    private Stat playerStat;
    private String race;
    private String player;

    public Player(String name, String race, String player,Stat playerStat){
        super(name);
        this.race = race;
        this.player = player;
        this.playerStat=playerStat;
    }

    public Player(String name, String race, String player){
        super(name);
        this.race = race;
        this.player = player;

        int[] abilities = {10,10,10,10,10,10};
        this.playerStat= new Stat(1,0,abilities,10,30,0);
    }

    public Stat getPlayerStat(){
        return playerStat;
    }

    public void setPlayerStat(Stat playerStat) {
        this.playerStat = playerStat;
    }

    public String getRace() { return this.race; }

    public void setRace(String race){this.race = race;}

    public String getPlayer(){return this.player;}

    public void setPlayer(String player) {this.player = player;}
}
