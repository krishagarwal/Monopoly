package com.agarwal;

import javax.swing.text.Utilities;
import java.util.ArrayList;

public class Player {
    private String nameOfPlayer;
    ArrayList<Property> propertiesOwned;
    ArrayList<Railroad> railroadsOwned;
    ArrayList<Utility> utilitiesOwned;
    private CreditCard creditCard;
    boolean isInJail;
    int timeServed;

    Player(String nameOfPlayer){
        creditCard = new CreditCard();
        utilitiesOwned = new ArrayList<Utility>();
        propertiesOwned = new ArrayList<Property>();
        this.nameOfPlayer = nameOfPlayer;
        railroadsOwned = new ArrayList<Railroad>();
        isInJail = false;
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