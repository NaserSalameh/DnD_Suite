package com.DnDSuite.model;

public class NPC extends Creature {
    public NPC(String name, String race, Stat playerStat) {
        super(name, race, playerStat);
    }

    public NPC(String name, String race) {
        super(name, race);
    }
}
