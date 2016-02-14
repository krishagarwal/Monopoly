package com.agarwal;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String nameOfPlayer;
    ArrayList<Property> propertiesOwned;
    private CreditCard creditCard;

    Player(String nameOfPlayer){
        creditCard = new CreditCard();
        propertiesOwned = new ArrayList<Property>();
        this.nameOfPlayer = nameOfPlayer;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setNameOfPlayer(String nameOfPlayer){
        this.nameOfPlayer = nameOfPlayer;
    }
    public String getNameOfPlayer(){
        return nameOfPlayer;
    }
}