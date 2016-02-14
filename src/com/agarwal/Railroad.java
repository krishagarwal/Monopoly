package com.agarwal;

public class Railroad extends Place {
    private int price;
    private int[] rent;

    Railroad(int price, int[] rent){
        rent = new int[3];
        nameOfSpace = "Railroad";
        this.price = price;
        this.rent = rent;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public void setRent(int rent, int position){
        this.rent[position] = rent;
    }
    public int getRent(int position){
        return rent[position];
    }
}
