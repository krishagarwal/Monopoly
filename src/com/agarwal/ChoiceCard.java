package com.agarwal;

/**
 * Created by krish_000 on 4/12/2016.
 */
public abstract class ChoiceCard {
    private String type;
    String prompt;

    ChoiceCard(String type, String prompt){
        this.type = type;
        this.prompt = prompt;
    }

    public abstract boolean DoAction(Player player);
}
