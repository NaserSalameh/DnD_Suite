package com.DnDSuite.model;

import java.awt.image.BufferedImage;

public class Item extends Entity {

    private String description;
    private String attributes;
    private String rarity;
    private Player owner;
    private BufferedImage picture;

    public Item(String name,String description, String attributes, String rarity){

        super(name);
        this.description = description;
        this.attributes = attributes;
        this.rarity = rarity;

    }


    public Item(String name,String description, String attributes, String rarity, Player owner){

        super(name);
        this.description = description;
        this.attributes = attributes;
        this.rarity = rarity;
        this.owner = owner;

    }

    public Item(String name,String description, String attributes, String rarity, Player owner, BufferedImage picture){

        super(name);
        this.description = description;
        this.attributes = attributes;
        this.rarity = rarity;
        this.owner = owner;
        this.picture = picture;
    }

    public String getDescription(){return this.description;}

    public void setDescription(String description){ this.description = description;}

    public String getAttributes(){return this.attributes;}

    public void setAttributes(String attributes){ this.attributes = attributes;}

    public String getRarity(){return this.rarity;}

    public void setRarity(String rarity){ this.rarity = rarity;}

    public Player getOwner(){return this.owner;}

    public void setOwner(Player owner){ this.owner = owner;}

    public BufferedImage getPicture(){ return this.picture;}

    public void setPicture(BufferedImage picture){ this.picture = picture;}

}
