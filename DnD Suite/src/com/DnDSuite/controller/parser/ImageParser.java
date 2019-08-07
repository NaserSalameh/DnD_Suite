package com.DnDSuite.controller.parser;

import com.DnDSuite.model.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageParser {

    // File representing the folder that you select using a FileChooser
    private File dir = new File("pictures");

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

    public ImageParser(CampaignData data){ this.data = data; }

    public ImageParser(CampaignData data, String location){
        this.data = data;
        dir = new File(location);
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

    public String parsePlayersImages(){
        HashMap<String,BufferedImage> playerImages = parse("Players");
        for(Map.Entry entry : playerImages.entrySet())
            for(Player p: data.getPlayers()){
                if(entry.getKey().equals(p.getName())) {
                    p.setPortrait((BufferedImage) entry.getValue());
                }
            }
        return("Parsed Player Images...");
    }

    public String parseNpcImages(){
        HashMap<String,BufferedImage> npcImages = parse("NPCs");
        for(Map.Entry entry : npcImages.entrySet())
            for(Npc n: data.getNpcs()){
                if(entry.getKey().equals(n.getName())) {
                    n.setPortrait((BufferedImage) entry.getValue());
                }
            }
        return("Parsed NPC Images...");
    }

    public String parseLocationImages(){
        HashMap<String,BufferedImage> locationPictures = parse("Locations\\Pictures");
        HashMap<String,BufferedImage> locationMaps = parse("Locations\\Maps");
        for(Map.Entry entry : locationPictures.entrySet())
            for(Location l: data.getLocations()){
                if(entry.getKey().equals(l.getName())) {
                    l.setPicture((BufferedImage) entry.getValue());
                    l.setPicture((BufferedImage) locationMaps.get(l.getName()));
                }
            }
        return("Parsed Location Images...");
    }

    public String parseItemImages(){
        HashMap<String,BufferedImage> itemPictures = parse("Items");
        for(Map.Entry entry : itemPictures.entrySet())
            for(Item i: data.getItems()){
                if(entry.getKey().equals(i.getName())) {
                    i.setPicture((BufferedImage) entry.getValue());
                }
            }
        return("Parsed Item Images...");
    }

}
