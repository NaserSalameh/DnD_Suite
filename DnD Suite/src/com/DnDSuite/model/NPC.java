package com.DnDSuite.model;

public class NPC extends Creature {
    public NPC(String name, String race, String creatureClass,Stat playerStat) {
        super(name, race, creatureClass, playerStat);
    }

    public NPC(String name, String race) {
        super(name, race);
    }
}
