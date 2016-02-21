package com.agarwal;

public class SellablePlace extends Place{
    protected int price;
    protected Player owner;
    protected boolean isOwned;
    protected boolean isMortgaged;
    protected Rounder myRounder;

    SellablePlace() {
        myRounder = new Rounder();
        isMortgaged = false;
        isOwned = false;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
        this.isOwned = true;
    }

    public Player getOwner() {
        return owner;
    }

    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }

    public boolean getIsOwned(){
        return isOwned;
    }

    public void setIsMortgaged(boolean isMortgaged) {
        this.isMortgaged = isMortgaged;
    }

    public boolean getIsMortgaged(){
        return isMortgaged;
    }

    @Override
    public boolean DoAction(Player player) {
        return false;
    }

    public boolean mortgageProperty(){
        if (isMortgaged || !isOwned) {
            return false;
        }

        owner.getCreditCard().addMoney(price / 2);
        isMortgaged = true;
        return true;
    }

    public boolean unmortgageProperty(){
        if (!isMortgaged){
            return false;
        }

        int priceToUnmortgage = myRounder.roundToNearestTens((int)(price * 0.55));
        if(priceToUnmortgage > owner.getCreditCard().amount){
            return false;
        }

        owner.getCreditCard().subtractMoney(priceToUnmortgage);
        isMortgaged = false;
        return true;
    }
}
