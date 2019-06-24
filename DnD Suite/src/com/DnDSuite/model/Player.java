package com.DnDSuite.model;

public class Player extends Entity {

    //to be changed into stats
    private int health;

    public Player(String name){
        super(name);
        health=50;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
