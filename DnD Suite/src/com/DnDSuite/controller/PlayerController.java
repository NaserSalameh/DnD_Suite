package com.DnDSuite.controller;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Player;
import com.DnDSuite.model.Stat;

import javax.swing.*;
import java.util.HashMap;

public class PlayerController {

        private JList creatureList;
        protected DefaultListModel model;
        protected HashMap<String,JTextField> textFields;
        protected JComboBox raceComboBox;
        protected JComboBox classComboBox;
        protected JComboBox subClassComboBox;

        private CampaignData data;

        public PlayerController(CampaignData data, JList creatureList, HashMap<String, JTextField> textFields, JComboBox raceComboBox, JComboBox classComboBox, JComboBox subClassComboBox) {

            this.data = data;

            this.creatureList = creatureList;
            this.textFields = textFields;
            this.raceComboBox = raceComboBox;
            this.classComboBox = classComboBox;
            this.subClassComboBox = subClassComboBox;

            model = new DefaultListModel();
            this.creatureList.setModel(model);


            for(Player p: data.getPlayers()) {
                model.add(model.getSize(),p.getName());
            }

            initialiseComboBoxes();
            setFields(data.getPlayers().get(0).getName());
        }

        private void initialiseComboBoxes(){

            for (int i = 0; i < data.getRaces().size(); i++)
            {
                raceComboBox.addItem(data.getRaces().get(i));
            }

            for (int i = 0; i < data.getClasses().size(); i++)
            {
                classComboBox.addItem(data.getClasses().get(i));
            }

        }

     public void initialiseSubClasses(String cl){
            subClassComboBox.removeAllItems();
            for (int i = 0; i < data.getSubClasses().get(cl).size(); i++)
             {
                subClassComboBox.addItem(data.getSubClasses().get(cl).get(i));
             }
    }

        public void setFields(String playerName){

            Player selectedPlayer = null;

            for(Player p: data.getPlayers())
                if(p.getName().equals(playerName))
                    selectedPlayer = p;

            textFields.get("name").setText(selectedPlayer.getName());

            for(int i = 0; i< raceComboBox.getItemCount(); i++){
                if(raceComboBox.getItemAt(i).equals(selectedPlayer.getRace()))
                    raceComboBox.setSelectedIndex(i);
            }

            for(int i = 0; i< classComboBox.getItemCount(); i++){
                if(classComboBox.getItemAt(i).equals(selectedPlayer.getCreatureClass())) {
                    classComboBox.setSelectedIndex(i);
                    initialiseSubClasses(selectedPlayer.getCreatureClass());
                }
            }

            textFields.get("player").setText(String.valueOf(selectedPlayer.getPlayer()));
            textFields.get("level").setText(String.valueOf(selectedPlayer.getStat().getLevel()));
            textFields.get("exp").setText(String.valueOf(selectedPlayer.getStat().getExp()));
            textFields.get("health").setText(String.valueOf(selectedPlayer.getStat().getHealth()));
            textFields.get("strength").setText(String.valueOf(selectedPlayer.getStat().getStrength()));
            textFields.get("dexterity").setText(String.valueOf(selectedPlayer.getStat().getDexterity()));
            textFields.get("constitution").setText(String.valueOf(selectedPlayer.getStat().getConstitution()));
            textFields.get("intelligence").setText(String.valueOf(selectedPlayer.getStat().getIntelligence()));
            textFields.get("wisdom").setText(String.valueOf(selectedPlayer.getStat().getWisdom()));
            textFields.get("charisma").setText(String.valueOf(selectedPlayer.getStat().getCharisma()));
            textFields.get("speed").setText(String.valueOf(selectedPlayer.getStat().getSpeed()));
            textFields.get("initiative").setText(String.valueOf(selectedPlayer.getStat().getInitiative()));
        }


    protected Player createPlayer() {
        String name = textFields.get("name").getText(),
                race = (String) raceComboBox.getSelectedItem(),
                creatureClass = (String) classComboBox.getSelectedItem(),
                creatureSubClass = (String) subClassComboBox.getSelectedItem(),
                player = (String) textFields.get("player").getText();


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

        return new Player(name,race,creatureClass,creatureSubClass,player,creatureStat);
    }

    public void newCreature(String playerName){
        Player newPlayer = createPlayer();

        //will be changed to data file
        data.getPlayers().add(newPlayer);
        model.add(model.getSize(),newPlayer);
    }

    public void editCreature(String playerName,int index){

        Player newPlayer = createPlayer();
            for(Player p: data.getPlayers())
            if(p.getName().equals(playerName)) {
                data.getPlayers().remove(p);
                model.remove(index);
            }

            data.getPlayers().add(newPlayer);
            model.add(model.getSize(),newPlayer);

    }

    public void setProgressBar(JProgressBar progressBar, String playerName) {

            Player selectedPlayer = null;

        for(Player p: data.getPlayers())
            if(p.getName().equals(playerName))
                selectedPlayer = p;

        int playerExp = selectedPlayer.getStat().getExp()
                , playerLevelExpCap=selectedPlayer.getStat().getLevelExps().get(selectedPlayer.getStat().getLevel());

        progressBar.setMaximum(playerLevelExpCap);
        progressBar.setValue(playerExp);
    }

}

