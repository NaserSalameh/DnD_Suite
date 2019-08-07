package com.DnDSuite.controller;

import javax.swing.*;
import java.io.File;

public class loaderController {

    JFileChooser fileChooser = new JFileChooser();
    JFileChooser folderChooser = new JFileChooser();

    public File selectFile(){

        if (fileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION)
            return fileChooser.getSelectedFile();
        else {
            System.out.println("No Selection.");
            return null;
        }
    }

    public String selectFolder() {

        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setAcceptAllFileFilterUsed(false);
        if (folderChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            return folderChooser.getCurrentDirectory().getPath();
        else{
            System.out.println("No Selection.");
            return null;
        }
    }
}
