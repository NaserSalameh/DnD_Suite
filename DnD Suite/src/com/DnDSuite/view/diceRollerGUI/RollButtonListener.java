package com.DnDSuite.view.diceRollerGUI;

import com.DnDSuite.controller.DiceRollerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

        String resultText="Rolled ";
        for(int i=0;i<numOfRollsArr.length;i++){
            if(numOfRollsArr[i]!=0) {
                resultText += numOfRollsArr[i];
                switch (i) {
                    case 0:
                        resultText += "d2. ";
                        break;
                    case 1:
                        resultText += "d4. ";
                        break;
                    case 2:
                        resultText += "d6. ";
                        break;
                    case 3:
                        resultText += "d8. ";
                        break;
                    case 4:
                        resultText += "d10. ";
                        break;
                    case 5:
                        resultText += "d12. ";
                        break;
                    case 6:
                        resultText += "d20. ";
                        break;
                    case 7:
                        resultText += "d100. ";
                        break;
                }
            }
        }
         resultText+= "\nResult: " + sum.toString() + " "+ modifierOP +" "+(modifierTextField.getText() + "= " +newSum.toString() +"\nAverage: " + avg);

        resultDisplay.setText(resultText);

    }

}
