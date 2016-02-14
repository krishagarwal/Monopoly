public class Calculator {
    public void addMoney(Credit_Card c, int money){
        c.amountOfBalance = c.amountOfBalance + money;
    }

    public void subtractMoney(Credit_Card c, int money){
        c.amountOfBalance = c.amountOfBalance - money;
    }

    public void transferMoney(Credit_Card moneyCollector, Credit_Card moneyLoser, int money){
        moneyCollector.amountOfBalance = moneyCollector.amountOfBalance + money;
        moneyLoser.amountOfBalance = moneyLoser.amountOfBalance - money;
    }
}
