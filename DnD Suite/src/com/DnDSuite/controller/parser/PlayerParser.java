package com.DnDSuite.controller.parser;

import com.DnDSuite.model.Player;
import com.DnDSuite.model.Stat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class PlayerParser {

    private DataFormatter dataFormatter;

    public PlayerParser(){
        dataFormatter = new DataFormatter();
    }

    public ArrayList<Player> parse(Sheet sheet){

        ArrayList<Player> players = new ArrayList<>();

        for(int i =1; i< sheet.getPhysicalNumberOfRows();i++){
            Row row = sheet.getRow(i);
            String line="";
            for(Cell cell: row){
                    line+=dataFormatter.formatCellValue(cell)+"===";
            }

            String[] rowCells = line.split("===");
            int[] abilities = {
                    Integer.parseInt(rowCells[7]),Integer.parseInt(rowCells[8]),
                    Integer.parseInt(rowCells[9]),Integer.parseInt(rowCells[10]),
                    Integer.parseInt(rowCells[11]),Integer.parseInt(rowCells[12])};
            Stat playerStat = new Stat(Integer.parseInt(rowCells[5]),Integer.parseInt(rowCells[6]),abilities,
                    Integer.parseInt(rowCells[13]),Integer.parseInt(rowCells[14]),Integer.parseInt(rowCells[15]));
            players.add(new Player(rowCells[0],rowCells[1],rowCells[2],rowCells[3],rowCells[4],playerStat));
        }
        System.out.println("Parsed Players...");
        return players;
    }

}
