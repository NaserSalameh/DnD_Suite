package com.DnDSuite.controller.parser;

import com.DnDSuite.model.CampaignData;
import com.DnDSuite.model.Npc;
import com.DnDSuite.model.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageParser {

    // File representing the folder that you select using a FileChooser
    static final File dir = new File("pictures");

    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
            "jpg", "jpeg" ,"png", "bmp" // and other formats you need
    };
    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    private CampaignData data;

    public ImageParser(CampaignData data){
        this.data = data;
    }

    public HashMap<String, BufferedImage> parse(String folderName) {
        File dir = new File("pictures\\" + folderName);
        HashMap<String, BufferedImage> images = new HashMap<>();
        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(f);
                    images.put(f.getName().substring(0,f.getName().indexOf(".")),img);
                } catch (final IOException e) {
                    // handle errors here
                }
            }
        }
        return images;
    }

    public void parsePlayersImages(){
        HashMap<String,BufferedImage> playerImages = parse("Players");
        for(Map.Entry entry : playerImages.entrySet())
            for(Player p: data.getPlayers()){
                if(entry.getKey().equals(p.getName())) {
                    p.setPortrait((BufferedImage) entry.getValue());
                }
            }
        System.out.println("Parsed Player Portraits...");
    }

    public void parseNpcImages(){
        HashMap<String,BufferedImage> playerImages = parse("NPCs");
        for(Map.Entry entry : playerImages.entrySet())
            for(Npc n: data.getNpcs()){
                if(entry.getKey().equals(n.getName())) {
                    n.setPortrait((BufferedImage) entry.getValue());
                }
            }
        System.out.println("Parsed NPC Portraits...");
    }

}
