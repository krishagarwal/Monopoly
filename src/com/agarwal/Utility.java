package com.agarwal;

public class Utility extends Place {

    private int price;
    private Player ownerOfUtility;
    private boolean isOwned;


    Utility(String name){
        this.name = name;
        price = Constants.Utility_Price;
    }

    public int getCharge(){
        if (ownerOfUtility.utilitiesOwned.size() == 2){
            return Dice.getDiceNum()*100;
        }
        else if (ownerOfUtility.utilitiesOwned.size() == 1){
            return Dice.getDiceNum()*40;
        }
        return 0;
    }

    public void setOwnerOfUtility(Player ownerOfUtility) {
        this.ownerOfUtility = ownerOfUtility;
        this.isOwned = true;
    }

    public Player getOwnerOfRailroad() {
        return ownerOfUtility;
    }

    public boolean getIsOwned(){
        return isOwned;
    }


    @Override
    public boolean DoAction(Player player) {
        if (!isOwned){
            //do nothing
        }
        else if (player.equals(ownerOfUtility)){
            //do nothing
        }
        else {
            boolean success = player.getCreditCard().subtractMoney(getCharge());
            if(!success){
                return false;
            }
            player.getCreditCard().subtractMoney(getCharge());
            ownerOfUtility.getCreditCard().addMoney(getCharge());
        }
        return true;
    }
}