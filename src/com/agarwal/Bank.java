package com.agarwal;

public class Bank {
    public void addMoney(CreditCard c, int money){
        c.amount = c.amount + money;
    }

    public void subtractMoney(CreditCard c, int money){
        c.amount = c.amount - money;
    }

    public void transferMoney(CreditCard moneyCollector, CreditCard moneyLoser, int money){
        moneyCollector.amount = moneyCollector.amount + money;
        moneyLoser.amount = moneyLoser.amount - money;
    }
}
