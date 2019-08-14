package com.DnDSuite.controller;

import com.DnDSuite.model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InitiativeController {

    private ArrayList<Player> players;
    private JList playersList;
    private HashMap<String,Player> playerHashMap;

    public InitiativeController(ArrayList<Player> players,JList playersList){

        this.players= players;

        playerHashMap = new HashMap<String,Player>();

        for(Player p: players)
            playerHashMap.put(p.getName(),p);

        this.playersList = playersList;

        DefaultListModel  model = new DefaultListModel();
        this.playersList.setModel(model);

        int index=0;
        for(Map.Entry<String,Player> entry: playerHashMap.entrySet()) {
            model.add(index,entry.getKey());
            index++;
        }
    }

    public Player getPlayer(String playerName){
        return playerHashMap.get(playerName);
    }

    public void sortPlayers(DefaultTableModel model){

        for(int i = 1 ;i<model.getRowCount()-1; i++){
            if((Integer) model.getValueAt(model.getRowCount()-1,1) > (Integer) model.getValueAt(i,1) ) {
                //since all elements are pre-sorted, just find element bigger than and place there
                model.moveRow(model.getRowCount()-1,model.getRowCount()-1,i);
                break;
            }
        }
    }

    public void nextTurn(DefaultTableModel model){

        model.moveRow(1,1, model.getRowCount()-1);
    }

    public void playerHitAndHeal(JTable playersInCombat, String healthModifier, String operation) {

        DefaultTableModel model = (DefaultTableModel) playersInCombat.getModel();

        int row = playersInCombat.getSelectedRow(), col = 2;
        int newHealth = Integer.parseInt(String.valueOf(model.getValueAt(row,2)));

        //both + and - work
        if(operation.equals("Hit"))
            newHealth = newHealth - Integer.parseInt(healthModifier);
        else if(operation.equals("Heal"))
            newHealth = newHealth + Integer.parseInt(healthModifier);

        model.setValueAt(String.valueOf(newHealth),row,col);
    }
}
