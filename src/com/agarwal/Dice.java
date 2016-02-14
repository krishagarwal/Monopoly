package com.agarwal;

/**
 * Created by Sonia Agarwal on 2/13/2016.
 */
import java.util.Random;

public class Dice {
    /*static Random rand;
    Dice(){
        rand=new Random();
    }
    public static int rollDice(){
        return rand.nextInt(12)+2;
    }*/

    //here is a much simpler way

    public static int rollDice(){
        return (int)(Math.random()*12 + 1);
    }


}
