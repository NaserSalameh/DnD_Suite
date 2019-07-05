package com.DnDSuite.model;

import java.util.HashMap;

public class Stat {

    private int level;
    private int exp;
    private HashMap<Integer,Integer> levelExps;

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
        setUpLevelExps();

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

    public HashMap<Integer,Integer> getLevelExps(){return this.levelExps;}

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

    private void setUpLevelExps(){
        this.levelExps = new HashMap<Integer, Integer>();

        this.levelExps.put(1,300);
        this.levelExps.put(2,900);
        this.levelExps.put(3,2700);
        this.levelExps.put(4,6500);
        this.levelExps.put(5,14000);
        this.levelExps.put(6,23000);
        this.levelExps.put(7,34000);
        this.levelExps.put(8,48000);
        this.levelExps.put(9,64000);
        this.levelExps.put(10,85000);
        this.levelExps.put(11,100000);
        this.levelExps.put(12,120000);
        this.levelExps.put(13,140000);
        this.levelExps.put(14,165000);
        this.levelExps.put(15,195000);
        this.levelExps.put(16,225000);
        this.levelExps.put(17,265000);
        this.levelExps.put(18,305000);
        this.levelExps.put(19,355000);
    }
}
