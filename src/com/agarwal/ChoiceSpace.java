package com.agarwal;

import java.util.ArrayList;
import java.util.Random;

public class ChoiceSpace extends Place {
    private static ArrayList<Card> cardArray;
    private static Random randomGenerator;
    static Card currentCard;

    ChoiceSpace(ArrayList<Card> cardArray){
        randomGenerator = new Random();
        cardArray = new ArrayList<Card>();
        this.cardArray = cardArray;
    }

    @Override
    public boolean DoAction(Player player) {
        if(currentCard.operator.equals("+")){
            player.getCreditCard().addMoney(currentCard.money);
            return true;
        }
        else if(currentCard.equals("-")){
            if(!player.getCreditCard().subtractMoney(currentCard.money)){
                return false;
            }
            player.getCreditCard().subtractMoney(currentCard.money);
            return true;
        }
        return true;
    }

    public static Card pickupCard(){
        int index = randomGenerator.nextInt(cardArray.size());
        currentCard = cardArray.get(index);
        return currentCard;
    }
}
