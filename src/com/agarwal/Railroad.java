package com.agarwal;

public class Railroad extends SellablePlace {
    private int[] rent;

    Railroad(String name) {
        rent = new int[5];
        rent[0] = 0;
        rent[1] = Constants.RAILROAD_RENT_1;
        rent[2] = Constants.RAILROAD_RENT_2;
        rent[3] = Constants.RAILROAD_RENT_3;
        rent[4] = Constants.RAILROAD_RENT_4;
        price = Constants.RAILROAD_PRICE;
        this.name = name;
        isMortgaged = false;
    }

    public int getRent() {
        return rent[owner.railroadsOwned.size()];
    }

    public Player getOwnerOfRailroad() {
        return owner;
    }

    public boolean getIsOwned() {
        return isOwned;
    }

    @Override
    public boolean DoAction(Player player) {
        if (isOwned && !player.equals(owner)) {
            int rent = getRent();
            boolean success = player.getCreditCard().subtractMoney(rent);
            if (!success) {
                return false;
            }
            owner.getCreditCard().addMoney(rent);
        }
        return true;
    }
}