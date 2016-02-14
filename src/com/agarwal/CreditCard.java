package com.agarwal;

import java.util.Scanner;
public class CreditCard {
    public double amountOfBalanceInMillion;

    CreditCard(){
        amountOfBalanceInMillion = 15;
    }

    public void addMoney(int amount) {
        amountOfBalanceInMillion = amount + amountOfBalanceInMillion;
    }

    public boolean subtractMoney(int amount) {
        if(amountOfBalanceInMillion < amount){
            return false;
        } else{
            amountOfBalanceInMillion = amountOfBalanceInMillion - amount;
            return true;
        }
    }
}
