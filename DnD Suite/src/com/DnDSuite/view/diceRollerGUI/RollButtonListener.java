package com.DnDSuite.view.diceRollerGUI;

import com.DnDSuite.controller.DiceRollerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class RollButtonListener implements ActionListener {

    private DiceRollerController diceRollerController;
    private JTextPane resultDisplay;
    private ArrayList<JTextField> diceAmounts;
    private ArrayList<Integer> rollResults;
    private JTextField modifierTextField;
    private ButtonGroup modifierBG;

    private int[] numOfRollsArr;

    public RollButtonListener(ArrayList diceAmounts, ButtonGroup modifierBG, JTextField modifierTextField,JTextPane resultDisplay){
        diceRollerController = new DiceRollerController();

        this.modifierTextField = modifierTextField;
        this.modifierBG = modifierBG;
        this.diceAmounts=diceAmounts;
        this.resultDisplay = resultDisplay;
        this.rollResults = new ArrayList<>();
        this.numOfRollsArr = new int[8];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer sum=0 , avg =0, totalRolls=0;
        for (Component c : diceAmounts) {
            Integer numOfRolls = Integer.parseInt(((JTextField) c).getText());
                switch (c.getName()) {
                    case "d2TextField":
                        if(!((JTextField) c).getText().equals(String.valueOf(0)))
                            rollResults.addAll(diceRollerController.rollD(2, numOfRolls));
                        numOfRollsArr[0]=numOfRolls;
                        avg+=(1*numOfRolls);
                        break;
                    case "d4TextField":
                        if(!((JTextField) c).getText().equals(String.valueOf(0)))
                            rollResults.addAll(diceRollerController.rollD(4,numOfRolls));
                        numOfRollsArr[1]=numOfRolls;
                        avg+=(2*numOfRolls);
                        break;

                    case "d6TextField":
                        if(!((JTextField) c).getText().equals(String.valueOf(0)))
                            rollResults.addAll(diceRollerController.rollD(6,numOfRolls));
                        numOfRollsArr[2]=numOfRolls;
                        avg+=(3*numOfRolls);
                        break;

                    case "d8TextField":
                        if(!((JTextField) c).getText().equals(String.valueOf(0)))
                            rollResults.addAll(diceRollerController.rollD(8,numOfRolls));
                        numOfRollsArr[3]=numOfRolls;
                        avg+=(4*numOfRolls);
                        break;

                    case "d10TextField":
                        if(!((JTextField) c).getText().equals(String.valueOf(0)))
                            rollResults.addAll(diceRollerController.rollD(10,numOfRolls));
                        numOfRollsArr[4]=numOfRolls;
                        avg+=(5*numOfRolls);
                        break;

                    case "d12TextField":
                        if(!((JTextField) c).getText().equals(String.valueOf(0)))
                            rollResults.addAll(diceRollerController.rollD(12,numOfRolls));
                        numOfRollsArr[5]=numOfRolls;
                        avg+=(6*numOfRolls);
                        break;

                    case "d20TextField":
                        if(!((JTextField) c).getText().equals(String.valueOf(0)))
                            rollResults.addAll(diceRollerController.rollD(20,numOfRolls));
                        numOfRollsArr[6]=numOfRolls;
                        avg+=(10*numOfRolls);
                        break;

                    case "d100TextField":
                        if(!((JTextField) c).getText().equals(String.valueOf(0)))
                            rollResults.addAll(diceRollerController.rollD(100,numOfRolls));
                        numOfRollsArr[7]=numOfRolls;
                        avg+=(50*numOfRolls);
                        break;
                }
        }
        for (Integer i: rollResults) {
            sum += i;
        }

        rollResults.clear();

        String modifierOP = "";
        Integer newSum = sum;
        switch(modifierBG.getSelection().getActionCommand()){
            case "Add":
                newSum+=Integer.parseInt(modifierTextField.getText());
                modifierOP = "+";
                break;
            case "Sub":
                newSum-=Integer.parseInt(modifierTextField.getText());
                modifierOP = "-";
                break;
            case "Mult":
                newSum*=Integer.parseInt(modifierTextField.getText());
                modifierOP = "*";
                break;
            case "Div":
                newSum/=Integer.parseInt(modifierTextField.getText());
                modifierOP = "/";
                break;
        }

        String resultText = "Rolled "+numOfRollsArr[0]+"d2, " + numOfRollsArr[1]+"d4, " + numOfRollsArr[2]+"d6, "+
                numOfRollsArr[3]+"d8, " + numOfRollsArr[4]+"d10, " + numOfRollsArr[5]+"d12, " + numOfRollsArr[6]+"d20, "+
                numOfRollsArr[7]+"d100."+
                "\nResult: " + sum.toString() + " "+ modifierOP +" "+(modifierTextField.getText() + "= " +newSum.toString() +"\nAverage: " + avg);

        resultDisplay.setText(resultText);

    }

}
