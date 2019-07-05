package com.DnDSuite.controller;

import com.DnDSuite.model.Player;
import com.DnDSuite.model.Stat;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PlayersController {
        private JList playerslList;
        private HashMap<String,JTextField> textFields;
        private HashMap<String, Player> mockPlayers;


        public PlayersController(JList playerslList, HashMap<String, JTextField> textFields) {

            this.playerslList = playerslList;
            this.textFields = textFields;


            //find better way to incorporate after data is set
            mockPlayers = new HashMap<String,Player>();

            int[] abilities = {10,10,10,10,10,10};
            Player player1 = new Player("Zenithar","Tiefling","Aris");
            mockPlayers.put("Zenithar",player1);


            DefaultListModel model = new DefaultListModel();
            this.playerslList.setModel(model);

            //fix with hashmaps?
            int index=0;
            for(Map.Entry<String,Player> entry: mockPlayers.entrySet()) {
                model.add(index,entry.getKey());
                index++;
            }

            setTextFields(player1.getName());
        }

        public void setTextFields(String playerName){

            Player selectedPlayer = mockPlayers.get(playerName);

            textFields.get("name").setText(selectedPlayer.getName());
            textFields.get("race").setText(selectedPlayer.getRace());
            textFields.get("player").setText(selectedPlayer.getPlayer());
            textFields.get("level").setText(String.valueOf(selectedPlayer.getPlayerStat().getLevel()));
            textFields.get("exp").setText(String.valueOf(selectedPlayer.getPlayerStat().getExp()));
            textFields.get("health").setText(String.valueOf(selectedPlayer.getPlayerStat().getHealth()));
            textFields.get("strength").setText(String.valueOf(selectedPlayer.getPlayerStat().getStrength()));
            textFields.get("dexterity").setText(String.valueOf(selectedPlayer.getPlayerStat().getDexterity()));
            textFields.get("constitution").setText(String.valueOf(selectedPlayer.getPlayerStat().getConstitution()));
            textFields.get("intelligence").setText(String.valueOf(selectedPlayer.getPlayerStat().getIntelligence()));
            textFields.get("wisdom").setText(String.valueOf(selectedPlayer.getPlayerStat().getWisdom()));
            textFields.get("charisma").setText(String.valueOf(selectedPlayer.getPlayerStat().getCharisma()));
            textFields.get("speed").setText(String.valueOf(selectedPlayer.getPlayerStat().getSpeed()));
            textFields.get("initiative").setText(String.valueOf(selectedPlayer.getPlayerStat().getInitiative()));
        }


    public void setProgressBar(JProgressBar progressBar, String playerName) {


        Player selectedPlayer = mockPlayers.get(playerName);

        int playerExp = selectedPlayer.getPlayerStat().getExp()
                , playerLevelExpCap=selectedPlayer.getPlayerStat().getLevelExps().get(selectedPlayer.getPlayerStat().getLevel());

        progressBar.setMaximum(playerLevelExpCap);
        progressBar.setValue(playerExp);
    }

    private Player createPlayer() {
        String name = textFields.get("name").getText(),
                race = textFields.get("race").getText(),
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

        int[] playerAbilities = {strength, dexterity,constitution,intelligence,wisdom,charisma};
        Stat playerStat = new Stat(level,exp,playerAbilities,health,speed,initiative);

        return new Player(name,race,player,playerStat);
    }

    public void newPlayer(){
            Player newPlayer = createPlayer();

            //will be changed to data file
            mockPlayers.put(newPlayer.getName(),newPlayer);
        }

    public void editPlayer(){
        Player newPlayer = createPlayer();
        //will be changed to data file
        mockPlayers.replace(newPlayer.getName(),newPlayer);
    }

}

