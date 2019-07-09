package com.DnDSuite.controller.creatureController;

import com.DnDSuite.controller.creatureController.CreatureController;
import com.DnDSuite.model.Player;

import javax.swing.*;
import java.util.HashMap;

public class PlayerController extends CreatureController {

    public PlayerController(JList playerslList, HashMap<String, JTextField> textFields, JComboBox raceComboBox, JComboBox classComboBox) {
        super(playerslList, textFields, raceComboBox, classComboBox);
    }

    public void setProgressBar(JProgressBar progressBar, String playerName) {
        Player selectedPlayer = (Player) super.mockCreatures.get(playerName);

        int playerExp = selectedPlayer.getStat().getExp()
                , playerLevelExpCap=selectedPlayer.getStat().getLevelExps().get(selectedPlayer.getStat().getLevel());

        progressBar.setMaximum(playerLevelExpCap);
        progressBar.setValue(playerExp);
    }

    public void setFields(String playerName, JTextField playerTextField){
        Player selectedPlayer = (Player) super.mockCreatures.get(playerName);

        super.setFields(playerName);
        playerTextField.setText(selectedPlayer.getPlayer());
    }

}
