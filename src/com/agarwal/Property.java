package com.agarwal;


public class Property extends Place{
	private int price;
	private String colorOfProperty;
	private int[] rent;
	private boolean isOwned;
	private Player ownerOfProperty;
	private int noOfHouses;
	private boolean hasHotel;
	private int priceToUnmortgage;
	private boolean isMortgaged;
	private int moneyFromMortgage;
	Rounder myRounder;
	private Player mortgagedPropertyOwner;
	private int priceToBuyHouse;
	int propertiesOwnedOfSameColor;
	int numOfPropertiesToCompleteMonopoly;
	int currentRent;

	Property(String name, String colorOfProperty, int price, int[] rent, int priceToBuyHouse, int numOfPropertiesToCompleteMonopoly){
		myRounder = new Rounder();
		this.name = name;
		this.rent = new int[6];
		this.rent = rent;
		this.colorOfProperty = colorOfProperty;
		this.price = price;
		isMortgaged = false;
		noOfHouses = 0;
		moneyFromMortgage = price/2;
		priceToUnmortgage = myRounder.roundToNearestTens(moneyFromMortgage + (moneyFromMortgage/10));
		this.priceToBuyHouse = priceToBuyHouse;
		this.numOfPropertiesToCompleteMonopoly = numOfPropertiesToCompleteMonopoly;
	}

	public void setColorOfProperty(String colorOfProperty){
		this.colorOfProperty = colorOfProperty;
	}
	public String getColorOfProperty(){
		return colorOfProperty;
	}

	public void setPrice(int price){
		this.price = price;
	}
	public int getPrice(){
		return price;
	}

	public void setRent(int rent, int noOfHouses)
	{
		this.rent[noOfHouses] = rent;
	}

	public int getRent(){
		if (hasHotel){
			return rent[5];
		}
		else {
			return rent[noOfHouses];
		}
	}

	public boolean getIsOwned(){
		return isOwned;
	}

	public void setOwnerOfProperty(Player ownerOfProperty) {
		this.ownerOfProperty = ownerOfProperty;
	}
	public Player getOwnerOfProperty() {
		return ownerOfProperty;
	}

	public int getPriceToBuyHouse() {
		return priceToBuyHouse;
	}

	public boolean DoAction(Player player) {
		if (!isOwned) {
			//do nothing
		}  else if(ownerOfProperty.equals(Bank.getBankPlayer())){
			//do nothing
		}  else if (player.equals(ownerOfProperty)){
			//do nothing
		} else {
			int rent = getRent();
			boolean success = player.getCreditCard().subtractMoney(rent);
			if (!success ) {
				return false;
			}

			ownerOfProperty.getCreditCard().addMoney(rent);
		}
		return true;
	}

	public void setIsMortgaged(boolean isMortgaged) {
		this.isMortgaged = isMortgaged;
	}
	public boolean getIsMortgaged(){
		return isMortgaged;
	}

	public int getMoneyFromMortgage() {
		return moneyFromMortgage;
	}

	public int getPriceToUnmortgage() {
		return priceToUnmortgage;
	}

	public void setMortgagedPropertyOwner(Player mortgagedPropertyOwner) {
		this.mortgagedPropertyOwner = mortgagedPropertyOwner;
	}
	public Player getMortgagedPropertyOwner() {
		return mortgagedPropertyOwner;
	}

	public boolean mortgageProperty(Player player){
		if(player.equals(ownerOfProperty)){
			player.getCreditCard().addMoney(moneyFromMortgage);
			setOwnerOfProperty(Bank.getBankPlayer());
			mortgagedPropertyOwner = player;
			return true;
		}
		else{
			return false;
		}
	}
	public boolean unmortgageProperty(Player player){
		if(player.equals(mortgagedPropertyOwner)){
			if(priceToUnmortgage > player.getCreditCard().amount){
				return false;
			}

			player.getCreditCard().subtractMoney(priceToUnmortgage);
			mortgagedPropertyOwner = null;
			ownerOfProperty = player;
			return true;
		}
		return false;
	}

	public boolean buyHouse(Property property, int housesToBuy){
		if(!ownerOfProperty.checkIfHasMonopoly(property.colorOfProperty)){
			return false;
		}
		else if(hasHotel){
			return false;
		}
		else if(!ownerOfProperty.getCreditCard().subtractMoney(housesToBuy*priceToBuyHouse)){
			return false;
		}
		ownerOfProperty.getCreditCard().subtractMoney(housesToBuy*priceToBuyHouse);
		return true;
	}

	public boolean checkIfHasHotel(){
		if(noOfHouses == 5){
			return true;
		}
		return false;
	}
}