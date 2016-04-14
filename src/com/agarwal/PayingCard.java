package com.agarwal;

/**
 * Created by krish_000 on 4/14/2016.
 */
public class PayingCard extends ChoiceCard {

    int money;

    PayingCard(int money, String prompt, String type){
        super(type, prompt);
        this.money = money;
    }

    @Override
    public boolean DoAction(Player p) {
        int amount = (int) (p.getCreditCard().amount);
        boolean isSub = p.getCreditCard().subtractMoney(-1 * money);
        return isSub;
    }
}
