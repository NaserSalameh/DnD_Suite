package com.DnDSuite.view;

import javax.swing.*;
import java.util.ArrayList;

public class Front extends JFrame{
    private JTabbedPane tabbedPane1;
    private JButton selectCampaignButton;
    private JTextPane resultDisplay;
    private JPanel dicePanel;
    private JPanel D2;
    private JPanel D4;
    private JPanel D6;
    private JPanel D8;
    private JPanel D10;
    private JPanel D12;
    private JPanel D20;
    private JPanel D100;
    private JTextField d2TextField;
    private JPanel RollButtonPanel;
    private JButton RollButton;
    private JTextField d4TextField;
    private JTextField d6TextField;
    private JTextField d10TextField;
    private JTextField d20TextField;
    private JTextField d8TextField;
    private JTextField d12TextField;
    private JTextField d100TextField;
    private JPanel rootPanel;

    public Front(){
        add(rootPanel);
        setTitle("DnD Suite");
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ArrayList<JTextField> diceAmounts = new ArrayList<>();

        d2TextField.setName("d2TextField");
        d2TextField.setText("0");
        diceAmounts.add(d2TextField);
        d4TextField.setName("d4TextField");
        d4TextField.setText("0");
        diceAmounts.add(d4TextField);
        d6TextField.setName("d6TextField");
        d6TextField.setText("0");
        diceAmounts.add(d6TextField);
        d8TextField.setName("d8TextField");
        d8TextField.setText("0");
        diceAmounts.add(d8TextField);
        d10TextField.setName("d10TextField");
        d10TextField.setText("0");
        diceAmounts.add(d10TextField);
        d12TextField.setName("d12TextField");
        d12TextField.setText("0");
        diceAmounts.add(d12TextField);
        d20TextField.setName("d20TextField");
        d20TextField.setText("0");
        diceAmounts.add(d20TextField);
        d100TextField.setName("d100TextField");
        d100TextField.setText("0");
        diceAmounts.add(d100TextField);

        RollButton.addActionListener(new RollButtonListener(diceAmounts, resultDisplay));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
