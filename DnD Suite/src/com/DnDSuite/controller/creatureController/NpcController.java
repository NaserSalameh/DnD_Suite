package com.DnDSuite.controller.creatureController;

import com.DnDSuite.controller.creatureController.CreatureController;
import com.DnDSuite.model.NPC;

import javax.swing.*;
import java.util.HashMap;

public class NpcController extends CreatureController {

    private HashMap<String, NPC> mockPlayers;

    public NpcController(JList playerslList, HashMap<String, JTextField> textFields, JComboBox raceComboBox, JComboBox classComboBox) {
        super(playerslList, textFields, raceComboBox, classComboBox);
    }

}
