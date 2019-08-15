package com.DnDSuite.controller;

import javax.swing.*;
import java.io.File;

public class LoaderController {

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
        if (folderChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory= folderChooser.getCurrentDirectory();
            File selectedFolder = folderChooser.getSelectedFile();
            return selectedDirectory.getPath()+"\\"+selectedFolder.getName();
        }
        else{
            System.out.println("No Selection.");
            return null;
        }
    }
}
