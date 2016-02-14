package com.agarwal;

public class Bank {
    public void addMoney(CreditCard c, int money){
        c.amountOfBalance = c.amountOfBalance + money;
    }

    public void subtractMoney(CreditCard c, int money){
        c.amountOfBalance = c.amountOfBalance - money;
    }

    public void transferMoney(CreditCard moneyCollector, CreditCard moneyLoser, int money){
        moneyCollector.amountOfBalance = moneyCollector.amountOfBalance + money;
        moneyLoser.amountOfBalance = moneyLoser.amountOfBalance - money;
    }
}
