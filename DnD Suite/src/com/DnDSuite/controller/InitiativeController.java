package com.DnDSuite.controller;

import com.DnDSuite.model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InitiativeController {

    private JList playerslList;
    private HashMap<String,Player> mockPlayers;

    public InitiativeController(JList playerslList){

        //find better way to incorporate after data is set
        mockPlayers = new HashMap<String,Player>();

        int[] abilities = {10,10,10,10,10,10};
        Player player1 = new Player("Zenithar","Tiefling","Fighter","Aris");
        mockPlayers.put("Zenithar",player1);

        this.playerslList = playerslList;

        DefaultListModel  model = new DefaultListModel();
        this.playerslList.setModel(model);

        int index=0;
        for(Map.Entry<String,Player> entry: mockPlayers.entrySet()) {
            model.add(index,entry.getKey());
            index++;
        }
    }

    public Player getPlayer(String playerName){
        return mockPlayers.get(playerName);
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

    public void playerHit(JTable playersInCombat, String healthModifier) {

        DefaultTableModel model = (DefaultTableModel) playersInCombat.getModel();

        int row = playersInCombat.getSelectedRow(), col = 2;
        int newHealth;

        //both + and - work
        newHealth = Integer.parseInt((String) model.getValueAt(row,2)) + Integer.parseInt(healthModifier);
        model.setValueAt(String.valueOf(newHealth),row,col);
    }
}
