package com.agarwal;

public class Railroad extends Place {
    private int price;
    private int[] rent;
    private boolean isOwned;
    private Player ownerOfRailroad;
    private int priceToUnmortgage;
    private boolean isMortgaged;
    private int moneyFromMortgage;
    private Player mortgagedPropertyOwner;

    Railroad(String name){
        rent = new int[5];
        rent[0] = 0;
        rent[1] = Constants.RAILROAD_RENT_1;
        rent[2] = Constants.RAILROAD_RENT_2;
        rent[3] = Constants.RAILROAD_RENT_3;
        rent[4] = Constants.RAILROAD_RENT_4;
        price = Constants.RAILROAD_PRICE;
        this.name = name;
        isMortgaged = false;
        moneyFromMortgage = Constants.Railroad_Mortgage_Money;
        priceToUnmortgage = Constants.Railroad_Unmortgage_Price;
    }

    public int getPrice() {
        return price;
    }

    public int getRent(){
        return rent[ownerOfRailroad.railroadsOwned.size()];
    }

    public void setOwnerOfRailroad(Player ownerOfRailroad) {
        this.ownerOfRailroad = ownerOfRailroad;
        this.isOwned = true;
    }

    public Player getOwnerOfRailroad() {
        return ownerOfRailroad;
    }

    public boolean getIsOwned(){
        return isOwned;
    }

    @Override
    public boolean DoAction(Player player) {
        if (!isOwned) {
            //do nothing
        } else if (player.equals(ownerOfRailroad)){
            //do nothing
        } else if(ownerOfRailroad.equals(Bank.getBankPlayer())){
            //do nothing
        } else {
            int rent = getRent();
            boolean success = player.getCreditCard().subtractMoney(rent);
            if (!success ) {
                return false;
            }
            player.getCreditCard().subtractMoney(rent);
            ownerOfRailroad.getCreditCard().addMoney(rent);
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
        if(player.equals(ownerOfRailroad)){
            player.getCreditCard().addMoney(moneyFromMortgage);
            setOwnerOfRailroad(Bank.getBankPlayer());
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
            ownerOfRailroad = player;
            return true;
        }
        return false;
    }
}
