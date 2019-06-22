package com.DnDSuite.controller;

import com.marsG.simplerandomorglib.RandomIntegerClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiceRollerController {

    RandomIntegerClient trueRNG;
    String agent;

    public DiceRollerController(){
        agent = "NaserSalameh";
        trueRNG = new RandomIntegerClient(agent);
    }

    public ArrayList<Integer> rollD(int max, int numOfRolls){
        ArrayList<Integer> intResults = new ArrayList<>();
        try {
            List<String> stringResults = trueRNG.getRandomIntDecimal(1,max,numOfRolls);

            for(String s: stringResults) {
                intResults.add(Integer.parseInt(s));
            }
            return intResults;

        } catch (IOException e) {
            e.printStackTrace();
            return intResults;
        }
    }
}
