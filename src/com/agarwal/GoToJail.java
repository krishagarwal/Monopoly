package com.agarwal;

public class GoToJail extends Place{

    GoToJail(){
        name = "Go to Jail";
    }

    @Override
    public boolean DoAction(Player player) {
        player.isInJail = true;
        player.timeServed = 0;
        return true;
    }
}
