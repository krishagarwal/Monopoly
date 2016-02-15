package com.agarwal;

public class Railroad extends Place {
    private int price;
    private int[] rent;
    private boolean isOwned;
    private Player ownerOfRailroad;

    Railroad(String name){
        rent = new int[5];
        rent[0] = 0;
        rent[1] = Constants.RAILROAD_RENT_1;
        rent[2] = Constants.RAILROAD_RENT_2;
        rent[3] = Constants.RAILROAD_RENT_3;
        rent[4] = Constants.RAILROAD_RENT_4;
        price = Constants.RAILROAD_PRICE;
        this.name = name;
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
        } else {
            int rent = getRent();
            boolean success = player.getCreditCard().subtractMoney(rent);
            if (!success ) {
                return false;
            }
            ownerOfRailroad.getCreditCard().addMoney(rent);
        }
        return true;
    }
}
