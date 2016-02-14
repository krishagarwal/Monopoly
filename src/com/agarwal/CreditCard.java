package com.agarwal;

import java.util.Scanner;
public class CreditCard {
    static public double amountOfBalanceInMillion;
    static private String nameOfPlayer;
    static Scanner myScan = new Scanner(System.in);

    CreditCard(){
        amountOfBalanceInMillion = 15;
    }
        //krish is SUPER annoying!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private  static void addMoney(int amount) {
        amountOfBalanceInMillion = amount + amountOfBalanceInMillion;
    }

    private static boolean subtractMoney(int dollars) {
        if(amountOfBalanceInMillion < dollars){
            System.out.println("Oh no! " + nameOfPlayer + " doesn't have enough money!");
            return false;
        } else{
            updateMoney(dollars);
            return true;
        }
    }

    private static void updateMoney(int money){
        amountOfBalanceInMillion = amountOfBalanceInMillion - money;
    }
}
