package com.DnDSuite.view.initiativeGUI;

import com.DnDSuite.controller.InitiativeController;
import com.DnDSuite.model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InitiativeGUI extends JPanel{

    private ArrayList<Player> players;

    private JPanel rootPanel;
    private JTable playersInCombat;
    private JButton addButton;
    private JButton removeButton;
    private JPanel combatOrder;
    private JTextField initativeTextField;
    private JButton addNPCButton;
    private JButton nextTurnButton;
    private JPanel playersPanel;
    private JList playersList;
    private JTextField npcNameTextField;
    private JButton healthButton;
    private JTextField healthTextField;
    private JTextField npcHealthTextField;
    private JButton healButton;
    private JButton hitButton;


    public InitiativeGUI(ArrayList<Player> players){
        add(rootPanel);

        InitiativeController initiativeController = new InitiativeController(players,playersList);

        initativeTextField.setText("0");
        healthTextField.setText("0");
        npcHealthTextField.setText("0");

        DefaultTableModel model = (DefaultTableModel) playersInCombat.getModel();
        model.addColumn("Players");
        model.addColumn("Initiative");
        model.addColumn("Current Health");
        model.addRow(new Object[]{"Players" , "Initiative" , "Current Health"});

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = initiativeController.getPlayer((String) playersList.getSelectedValue());
                model.addRow( new Object[] {player.getName(),Integer.parseInt(initativeTextField.getText()) + player.getStat().getInitiative(),player.getStat().getHealth()});
                initiativeController.sortPlayers(model);
            }
        });

        addNPCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow( new Object[] {npcNameTextField.getText(),Integer.parseInt(initativeTextField.getText()),npcHealthTextField.getText()});
                initiativeController.sortPlayers(model);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               model.removeRow(playersInCombat.getSelectedRow());
            }
        });

        nextTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiativeController.nextTurn(model);
            }
        });

        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiativeController.playerHitAndHeal(playersInCombat,healthTextField.getText(),"Hit");
            }
        });

        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiativeController.playerHitAndHeal(playersInCombat,healthTextField.getText(),"Heal");
            }
        });
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }
}
