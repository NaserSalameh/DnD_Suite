package com.DnDSuite.controller.parser;

import com.DnDSuite.model.CampaignData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public class Parser {

    CampaignData data;

    private ImageParser imageParser;

    private PlayerParser playerParser;
    private RaceParser raceParser;
    private ClassParser classParser;
    private NpcParser npcParser;
    private LocationParser locationParser;
    private ItemParser itemParser;
    private QuestParser questParser;

    public Parser(Workbook workbook, CampaignData data) throws IOException {

        this.data = data;

        //imageParser = new ImageParser(data);

        playerParser = new PlayerParser();
        classParser = new ClassParser();
        raceParser = new RaceParser();
        npcParser = new NpcParser();
        locationParser = new LocationParser();
        itemParser = new ItemParser();
        questParser = new QuestParser();

        for(Sheet sheet: workbook) {
            if(sheet.getSheetName().equals("Players")){
                data.setPlayers(playerParser.parse(sheet));
                //imageParser.parsePlayersImages();
            }
            else if(sheet.getSheetName().equals("Races"))
                data.setRaces(raceParser.parse(sheet));
            else if(sheet.getSheetName().equals("Classes")) {
                data.setClasses(classParser.parseClasses(sheet));
                data.setSubClasses(classParser.parseSubClasses(sheet));
            }
            else if(sheet.getSheetName().equals("NPCs")) {
                data.setNpcs(npcParser.parse(sheet, data));
                //imageParser.parseNpcImages();
            }

            else if(sheet.getSheetName().equals("Locations")) {
                data.setLocations(locationParser.parse(sheet));
                //imageParser.parseLocationImages();
            }

            else if(sheet.getSheetName().equals("Items")) {
                data.setItems(itemParser.parse(sheet,data));
                //imageParser.parseItemImages();
            }

            else if(sheet.getSheetName().equals("Quests")) {
                data.setQuests(questParser.parse(sheet,data));
            }
        }
        parseConnections(workbook);
    }

    private void parseConnections(Workbook workbook){
        for(Sheet sheet: workbook){
             if(sheet.getSheetName().equals("NPCs")) {
                 npcParser.parseConnections(sheet,data);
            }

            else if(sheet.getSheetName().equals("Locations")) {
                locationParser.parseConnections(sheet,data);
            }

            else if(sheet.getSheetName().equals("Items")) {
                 itemParser.parseConnections(sheet,data);
            }

            else if(sheet.getSheetName().equals("Quests")) {
                 questParser.parseConnections(sheet,data);
            }
        }
        //System.out.println("Parsed All Connections...");
    }
}