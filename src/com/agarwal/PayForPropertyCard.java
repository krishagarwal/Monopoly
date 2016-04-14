package com.agarwal;

/**
 * Created by krish_000 on 4/14/2016.
 */
public class PayForPropertyCard extends ChoiceCard{

    int pricePerHouse;
    int pricePerHotel;

    @Override
    public boolean DoAction(Player player){
        int numOfTotalHotels = 0;
        int numOfTotalHouses = 0;
        for (int i = 0; i < player.propertiesOwned.size();i++){
            if(player.propertiesOwned.get(i).checkIfHasHotel()){
                numOfTotalHotels++;
            }
            else{
                numOfTotalHotels = numOfTotalHouses + player.propertiesOwned.get(i).noOfHouses;
            }
        }

        boolean isSuccess = player.getCreditCard().subtractMoney((numOfTotalHouses*pricePerHouse) + (numOfTotalHotels*pricePerHotel));
        return isSuccess;
    }

    public PayForPropertyCard(String type, String prompt, int pricePerHotel, int pricePerHouse){
        super(type, prompt);
        this.pricePerHotel = pricePerHotel;
        this.pricePerHouse = pricePerHouse;
    }
}