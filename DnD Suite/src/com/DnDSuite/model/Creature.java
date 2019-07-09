package com.DnDSuite.model;

public class Creature extends Entity {

    private Stat stat;
    private String race;
    private String creatureClass;

    public Creature(String name, String race, String creatureClass ,Stat playerStat){
        super(name);
        this.race = race;
        this.creatureClass=creatureClass;
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

    public String getCreatureClass(){return this.creatureClass;}

    public void setCreatureClass(String creatureClass){ this.creatureClass = creatureClass; }

}
