package com.agarwal;

public class Bank {
    public void addMoney(CreditCard c, int money){
        c.amountOfBalanceInMillion = c.amountOfBalanceInMillion + money;
    }

    public void subtractMoney(CreditCard c, int money){
        c.amountOfBalanceInMillion = c.amountOfBalanceInMillion - money;
    }

    public void transferMoney(CreditCard moneyCollector, CreditCard moneyLoser, int money){
        moneyCollector.amountOfBalanceInMillion = moneyCollector.amountOfBalanceInMillion + money;
        moneyLoser.amountOfBalanceInMillion = moneyLoser.amountOfBalanceInMillion - money;
    }
}
