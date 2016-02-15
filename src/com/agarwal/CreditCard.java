package com.agarwal;

public class CreditCard {
    public double amount;

    CreditCard(){
        amount = 15000;
    }

    public void addMoney(int amount) {
        this.amount = amount + this.amount;
    }

    public boolean subtractMoney(int amount) {
        if(this.amount < amount){
            return false;
        } else{
            this.amount = this.amount - amount;
            return true;
        }
    }
}
