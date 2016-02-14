package com.agarwal;

/**
 * Created by Sonia Agarwal on 2/13/2016.
 */
import java.util.Random;

public class Dice {
    static Random rand;
    Dice(){
        rand=new Random();
    }
    public static int rollDice(){
        return rand.nextInt(12)+2;
    }
}
