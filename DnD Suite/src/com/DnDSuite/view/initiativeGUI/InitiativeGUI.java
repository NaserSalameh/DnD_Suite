package com.DnDSuite.view.initiativeGUI;

import com.DnDSuite.controller.InitiativeController;
import com.DnDSuite.model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitiativeGUI extends JPanel{
    private JPanel rootPanel;
    private JTable playersInCombat;
    private JButton addButton;
    private JButton removeButton;
    private JPanel combatOrder;
    private JTextField initativeTextField;
    private JButton addNPCButton;
    private JButton nextTurnButton;
    private JPanel players;
    private JList playersList;
    private JTextField npcNameTextField;
    private JButton healthButton;
    private JTextField healthTextField;
    private JTextField npcHealthTextField;


    public InitiativeGUI(){
        add(rootPanel);

        InitiativeController initiativeController = new InitiativeController(playersList);

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
                model.addRow( new Object[] {player.getName(),Integer.parseInt(initativeTextField.getText()) + player.getPlayerStat().getInitiative(),player.getPlayerStat().getHealth()});
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

        healthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiativeController.playerHit(playersInCombat,healthTextField.getText());
            }
        });
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }
}
