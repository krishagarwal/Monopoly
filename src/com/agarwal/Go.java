package com.agarwal;

public class Go extends Place {

    Go(){
        name = "Go";
    }

    public boolean DoAction(Player player) {
        player.getCreditCard().addMoney(2000);
        return true;
    }
}
