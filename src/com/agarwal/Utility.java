package com.agarwal;

public class Utility extends Place {

    private int price;
    private Player ownerOfUtility;
    private boolean isOwned;
    private int priceToUnmortgage;
    private boolean isMortgaged;
    private int moneyFromMortgage;
    private Player mortgagedPropertyOwner;

    Utility(String name){
        this.name = name;
        price = Constants.Utility_Price;
        isMortgaged = false;
        moneyFromMortgage = Constants.Utility_Mortgage_Money;
        priceToUnmortgage = Constants.Utility_Unmortgage_Price;
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
        } else if(ownerOfUtility.equals(Bank.getBankPlayer())){
            //do nothing
        } else if (player.equals(ownerOfUtility)){
            //do nothing
        } else {
            boolean success = player.getCreditCard().subtractMoney(getCharge());
            if(!success){
                return false;
            }
            player.getCreditCard().subtractMoney(getCharge());
            ownerOfUtility.getCreditCard().addMoney(getCharge());
        }
        return true;
    }

    public void setIsMortgaged(boolean isMortgaged) {
        this.isMortgaged = isMortgaged;
    }
    public boolean getIsMortgaged(){
        return isMortgaged;
    }

    public boolean mortgageProperty(Player player){
        if(player.equals(ownerOfUtility)){
            player.getCreditCard().addMoney(moneyFromMortgage);
            setOwnerOfUtility(Bank.getBankPlayer());
            mortgagedPropertyOwner = player;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean unmortgageProperty(Player player){
        if(player.equals(mortgagedPropertyOwner)){
            if(priceToUnmortgage > player.getCreditCard().amount){
                return false;
            }

            player.getCreditCard().subtractMoney(priceToUnmortgage);
            mortgagedPropertyOwner = null;
            ownerOfUtility = player;
            return true;
        }
        return false;
    }
}