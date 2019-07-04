package com.DnDSuite.model;

public class Player extends Entity {

    private Stat playerStat;
    private String race;
    private String player;

    public Player(String name, String race, String player,int level, int exp,int[] ability, int health,int speed, int initiative){
        super(name);
        this.race = race;
        this.player = player;
        playerStat=new Stat(level, exp, ability, health,speed,initiative);
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
