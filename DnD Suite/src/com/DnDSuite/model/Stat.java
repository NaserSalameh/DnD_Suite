package com.DnDSuite.model;

public class Stat {

    private int level;
    private int exp;

    private int strength;
    private int dexterity;
    private int constitution;
    private int wisdom;
    private int intelligence;
    private int charisma;

    private int health;
    private int initiative;
    private int speed;

    public Stat(int level, int exp, int[] ability, int health,int speed, int initiative){

        this.level = level;
        this.exp = exp;

        this.strength = ability[0];
        this.dexterity = ability[1];
        this.constitution = ability[2];
        this.wisdom = ability[3];
        this.intelligence = ability[4];
        this.charisma = ability[5];

        this.health = health;
        this.speed= speed;
        this.initiative = initiative;

    }

    public int getLevel(){ return this.level; }

    public void setLevel(int level){ this.level = level; }

    public int getExp(){return  this.exp;}

    public void setExp(){this.exp = exp;}

    public int getStrength(){ return this.strength; }

    public void setStrength(int strength){ this.strength = strength; }

    public int getDexterity(){ return this.dexterity; }

    public void setDexterity(int dexterity){ this.dexterity = dexterity; }

    public int getConstitution(){ return this.constitution; }

    public void setConstitution(int constitution){ this.constitution = constitution; }

    public int getWisdom(){ return this.wisdom; }

    public void setWisdom(int wisdom){ this.wisdom = wisdom; }

    public int getIntelligence(){ return this.intelligence; }

    public void setIntelligence(int intelligence){ this.intelligence = intelligence; }

    public int getCharisma(){ return this.charisma; }

    public void setCharisma(int charisma){ this.charisma = charisma; }

    public int getHealth(){return this.health;}

    public void setHealth(int health) { this.health = health; }

    public int getInitiative() {return this.initiative;}

    public void setInitiative(int initiative){this.initiative = initiative;}

    public int getSpeed() {return this.speed;}

    public void setSpeed(int speed) {this.speed = speed;}
}
