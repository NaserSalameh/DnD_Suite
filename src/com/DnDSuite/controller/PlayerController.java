package com.DnDSuite.controller;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Player;
import com.DnDSuite.model.Stat;
import com.DnDSuite.view.playersGUI.PlayersGUI;

import javax.swing.*;
import java.util.HashMap;

public class PlayerController {

        private JList playerList;
        private DefaultListModel model;
        private HashMap<String,JTextField> textFields;
        private JComboBox raceComboBox;
        private JComboBox classComboBox;
        private JComboBox subClassComboBox;

        private JProgressBar progressBar;
        private JLabel playerPortrait;

        private CampaignData data;

        public PlayerController(PlayersGUI playersGUI, CampaignData data) {

            this.data = data;

            this.playerList = playersGUI.getPlayersList();
            this.textFields = playersGUI.getTextfields();
            this.raceComboBox = playersGUI.getRaceComboBox();
            this.classComboBox = playersGUI.getClassComboBox();
            this.subClassComboBox = playersGUI.getSubClassComboBox();

            this.progressBar=playersGUI.getExpProgressBar();
            this.playerPortrait = playersGUI.getPlayerPortrait();

            model = new DefaultListModel();
            this.playerList.setModel(model);

            for(Player p: data.getPlayers()) {
                model.add(model.getSize(),p.getName());
            }

            initialiseComboBoxes();
            //setFields(data.getPlayers().get(0).getName());
        }

        private void initialiseComboBoxes(){

            for (int i = 0; i < data.getRaces().size(); i++)
                raceComboBox.addItem(data.getRaces().get(i));


            for (int i = 0; i < data.getClasses().size(); i++)
                classComboBox.addItem(data.getClasses().get(i));


        }

     public void initialiseSubClasses(String cl){
            subClassComboBox.removeAllItems();
            for (int i = 0; i < data.getSubClasses().get(cl).size(); i++)
                subClassComboBox.addItem(data.getSubClasses().get(cl).get(i));

    }

        public void setFields(String playerName){

            Player selectedPlayer = null;

            for(Player p: data.getPlayers())
                if (p.getName().equals(playerName))
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

            setProgressBar(selectedPlayer.getName());

            if(selectedPlayer.getPortrait()!=null) {
                playerPortrait.setIcon(new ImageIcon(selectedPlayer.getPortrait()));
            }
            else
                playerPortrait.setIcon(null);

        }


    private Player createPlayer() {
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

    public void newPlayer(){
        Player newPlayer = createPlayer();

        data.getPlayers().add(newPlayer);
        model.add(model.getSize(),newPlayer.getName());
        playerList.setSelectedIndex(0);
    }

    public void editPlayer(String playerName, int index){

        newPlayer();

        Player temp = null;

        System.out.println(playerName);
        for(Player p: data.getPlayers())
            if(p.getName().equals(playerName))
                temp = p;

        data.getPlayers().remove(temp);
        model.remove(index);
    }

    public void setProgressBar(String playerName) {

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

