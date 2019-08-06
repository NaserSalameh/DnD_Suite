package com.DnDSuite.controller;

import javax.swing.*;
import java.io.File;

public class FrontController {

    JFileChooser fileChooser = new JFileChooser();

    public File selectFile(){

        if (fileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile();
        }
        else
            return null;
    }

}
