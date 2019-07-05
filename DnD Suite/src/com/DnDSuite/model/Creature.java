package com.DnDSuite.model;

public class Creature extends Entity {

    private Stat stat;
    private String race;

    public Creature(String name, String race, Stat playerStat){
        super(name);
        this.race = race;
        this.stat=playerStat;
    }

    public Creature(String name, String race){
        super(name);
        this.race = race;

        int[] abilities = {10,10,10,10,10,10};
        this.stat= new Stat(1,0,abilities,10,30,0);
    }

    public Stat getStat(){
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public String getRace() { return this.race; }

    public void setRace(String race){this.race = race;}


}
