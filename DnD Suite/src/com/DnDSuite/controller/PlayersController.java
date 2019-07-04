package com.DnDSuite.controller;

import com.DnDSuite.model.Player;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.util.ArrayList;
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
            Player player1 = new Player("Zenithar","Tiefling","Aris",13,200,abilities,100,30,2);
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

            for(Map.Entry<String,JTextField> entry: textFields.entrySet()){
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
        }

        public void newPlayer(){

        }

        public void editPlayer(Player player){

        }
 }

