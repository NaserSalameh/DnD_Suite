package com.DnDSuite.model;

public class Npc extends Entity{

    private String session;
    private String description;
    private String race;
    private int age;
    private String role;
    private Location location;

    public Npc(String name, String race, int age,  String description, String session, String role){
        super(name);

        this.session =session;
        this.description = description;
        this.race = race;
        this.age = age;
        this.role = role;
        this.location = location;
    }

    public String getSession() {return this.session;}

    public void setSession(String session){this.session = session;}

    public String getDescription() { return description; }

    public void setDescription(String description){this.description = description;}

    public int getAge(){return this.age;}

    public void setAge(int age){this.age = age;}

    public String getRace(){return this.race;}

    public void setRace(String race){ this.race = race;}

    public String getRole(){return this.role;}

    public void setRole(String role){this.role = role;}

    public Location getLocation(){return this.location;}

    //must find locations somehow?
    public void setLocation(String location){

    }
}
