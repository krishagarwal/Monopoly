package com.agarwal;

public class Dice {
    //Krish changed it for utility class purposes

    private static int diceNum;

    public static int getDiceNum() {
        return diceNum;
    }

    public static int rollDice(){
        diceNum =  (int)(Math.random()*11 + 2);
        return diceNum;
    }
}
