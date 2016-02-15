package com.agarwal;

public class Tax extends Place{
    private int taxToPay;

    Tax(int taxToPay, String name){
        this.taxToPay = taxToPay;
        this.name = name;
    }

    @Override
    public boolean DoAction(Player player) {
        if(taxToPay > player.getCreditCard().amount){
            return false;
        }
        return true;
    }
}
