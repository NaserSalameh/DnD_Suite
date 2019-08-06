package com.DnDSuite.controller;

import com.marsG.simplerandomorglib.RandomIntegerClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceRollerController {

    RandomIntegerClient trueRNG;
    String agent;

    public DiceRollerController(){
        agent = "NaserSalameh";
        trueRNG = new RandomIntegerClient(agent);
    }

    public ArrayList<Integer> rollD(int max, int numOfRolls){
        ArrayList<Integer> intResults = new ArrayList<>();
        Random rand = new Random();
        try {
            List<String> stringResults = trueRNG.getRandomIntDecimal(1,max,numOfRolls);

            for(String s: stringResults) {
                if(Integer.parseInt(s)!=0)
                intResults.add(Integer.parseInt(s));
                else
                    intResults.add(1 + rand.nextInt(max));
            }
            return intResults;

        } catch (IOException e) {
            e.printStackTrace();
            for(int i=0;i<numOfRolls;i++) {
                    intResults.add(1 + rand.nextInt(max));
            }
            return intResults;
        }
    }
}
