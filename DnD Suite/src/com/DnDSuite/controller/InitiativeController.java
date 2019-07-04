package com.DnDSuite.controller;

import com.DnDSuite.model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.ArrayList;

public class InitiativeController {

    private JList playerslList;

    public InitiativeController(JList playerslList){

        //find better way to incorporate after data is set
        ArrayList<Player> mockPlayers = new ArrayList<>();
        int[] abilities = {10,10,10,10,10,10};
        mockPlayers.add(new Player("Zenithar","Tiefling","Aris",13,200,abilities,100,30,2));

        this.playerslList = playerslList;

        DefaultListModel  model = new DefaultListModel();
        this.playerslList.setModel(model);

        for (int i= 0 ; i <mockPlayers.size(); i++)
            model.add(i, mockPlayers.get(i).getName() + " (" +mockPlayers.get(i).getPlayerStat().getHealth() + ")");
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
