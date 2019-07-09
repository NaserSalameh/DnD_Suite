package com.DnDSuite.controller.creatureController;

import com.DnDSuite.model.Creature;
import com.DnDSuite.model.Player;
import com.DnDSuite.model.Stat;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class CreatureController {

        private JList creaturelList;
        protected HashMap<String,JTextField> textFields;
        protected JComboBox raceComboBox;
        protected JComboBox classComboBox;
        protected HashMap<String, Creature> mockCreatures;

        public CreatureController(JList creaturelList, HashMap<String, JTextField> textFields, JComboBox raceComboBox, JComboBox classComboBox) {

            this.creaturelList = creaturelList;
            this.textFields = textFields;
            this.raceComboBox = raceComboBox;
            this.classComboBox = classComboBox;

            mockCreatures = new HashMap<String,Creature>();

            int[] abilities = {10,10,10,10,10,10};
            Creature creature1 = new Player("Zenithar","Tiefling", "Fighter","Aris");
            mockCreatures.put("Zenithar",creature1);


            DefaultListModel model = new DefaultListModel();
            this.creaturelList.setModel(model);

            int index=0;
            for(Map.Entry<String,Creature> entry: mockCreatures.entrySet()) {
                model.add(index,entry.getKey());
                index++;
            }

            initialiseComboBoxes();
            setFields(creature1.getName());
        }

        public void initialiseComboBoxes(){
            String[] races = {
                    "Dragonborn",
                    "Dwarf",
                    "Elf",
                    "Gnome",
                    "Half Elf",
                    "Half Orc",
                    "Halfling",
                    "Human" ,
                    "Tiefling",
                    "Aarakocra",
                    "Aasimar",
                    "Bug Bear",
                    "Firbolg",
                    "Goblin",
                    "Grung",
                    "Hobgoblin",
                    "Kenku",
                    "Kobold",
                    "Lizardfolk",
                    "Orc",
                    "Tabaxi",
                    "Triton",
                    "Changeling",
                    "Eladrin",
                    "Genasi",
                    "Goliath",
                    "Minotaur",
                    "Shifter",
                    "Warforged"
            };

            for (int i = 0; i < races.length; i++)
            {
                raceComboBox.addItem(races[i]);
            }

            String[] classes = {
                    "Barbarian",
                    "Bard",
                    "Cleric",
                    "Druid",
                    "Fighter",
                    "Monk",
                    "Paladin",
                    "Ranger",
                    "Rogue",
                    "Sorcerer",
                    "Warlock",
                    "Wizard"
            };

            for (int i = 0; i < classes.length; i++)
            {
                classComboBox.addItem(classes[i]);
            }

        }

        public void setFields(String creatureName){

            Creature selectedCreature = mockCreatures.get(creatureName);

            textFields.get("name").setText(selectedCreature.getName());

            for(int i = 0; i< raceComboBox.getItemCount(); i++){
                if(raceComboBox.getItemAt(i).equals(selectedCreature.getRace()))
                    raceComboBox.setSelectedIndex(i);
            }

            for(int i = 0; i< classComboBox.getItemCount(); i++){
                if(classComboBox.getItemAt(i).equals(selectedCreature.getClass()))
                    classComboBox.setSelectedIndex(i);
            }

            textFields.get("level").setText(String.valueOf(selectedCreature.getStat().getLevel()));
            textFields.get("exp").setText(String.valueOf(selectedCreature.getStat().getExp()));
            textFields.get("health").setText(String.valueOf(selectedCreature.getStat().getHealth()));
            textFields.get("strength").setText(String.valueOf(selectedCreature.getStat().getStrength()));
            textFields.get("dexterity").setText(String.valueOf(selectedCreature.getStat().getDexterity()));
            textFields.get("constitution").setText(String.valueOf(selectedCreature.getStat().getConstitution()));
            textFields.get("intelligence").setText(String.valueOf(selectedCreature.getStat().getIntelligence()));
            textFields.get("wisdom").setText(String.valueOf(selectedCreature.getStat().getWisdom()));
            textFields.get("charisma").setText(String.valueOf(selectedCreature.getStat().getCharisma()));
            textFields.get("speed").setText(String.valueOf(selectedCreature.getStat().getSpeed()));
            textFields.get("initiative").setText(String.valueOf(selectedCreature.getStat().getInitiative()));
        }


    private Player createCreature() {
        String name = textFields.get("name").getText(),
                race = (String) raceComboBox.getSelectedItem(),
                creatureClass = (String) classComboBox.getSelectedItem(),
                player = textFields.get("player").getText();

        int level = Integer.parseInt(textFields.get("level").getText()),
                exp = Integer.parseInt(textFields.get("exp").getText()),
                health = Integer.parseInt(textFields.get("health").getText()),
                strength = Integer.parseInt(textFields.get("strength").getText()),
                dexterity = Integer.parseInt(textFields.get("dexterity").getText()),
                constitution = Integer.parseInt(textFields.get("constitution").getText()),
                intelligence = Integer.parseInt(textFields.get("intelligence").getText()),
                wisdom = Integer.parseInt(textFields.get("wisdom").getText()),
                charisma = Integer.parseInt(textFields.get("charisma").getText()),
                speed = Integer.parseInt(textFields.get("speed").getText()),
                initiative = Integer.parseInt(textFields.get("initiative").getText());

        int[] creatureAbilities = {strength, dexterity,constitution,intelligence,wisdom,charisma};
        Stat creatureStat = new Stat(level,exp,creatureAbilities,health,speed,initiative);

        return new Player(name,race,creatureClass,player,creatureStat);
    }

    public void newCreature(){
            Player newPlayer = createCreature();

            //will be changed to data file
        mockCreatures.put(newPlayer.getName(),newPlayer);
        }

    public void editCreature(){
        Player newPlayer = createCreature();
        //will be changed to data file
        mockCreatures.replace(newPlayer.getName(),newPlayer);
    }

}

