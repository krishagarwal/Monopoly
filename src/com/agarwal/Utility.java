package com.agarwal;

public class Utility extends SellablePlace {

    Utility(String name){
        super();
        this.name = name;
        this.price = Constants.Utility_Price;
    }

    public int getRent(int diceNumber){
        if (isOwned && !isMortgaged) {
            if (owner.utilitiesOwned.size() == 2) {
                return diceNumber * 100;
            } else if (owner.utilitiesOwned.size() == 1) {
                return diceNumber * 40;
            }
        }
        return 0;
    }

    @Override
    public boolean DoAction(Player player) {
        if (isOwned && !player.equals(owner)){
            int diceNum = Dice.rollDice();
            int charge = getRent(diceNum);
            boolean success = player.getCreditCard().subtractMoney(charge);
            if (!success) {
                return false;
            }
            owner.getCreditCard().addMoney(charge);
        }
        return true;
    }
}