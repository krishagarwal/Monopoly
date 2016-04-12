package com.agarwal;


public class Property extends SellablePlace{
	private String colorOfProperty;
	private int[] rent;
	private int noOfHouses;
	private int priceToBuyHouse;
	int numOfPropertiesToCompleteMonopoly;

	Property(String name, String colorOfProperty, int price, int[] rent, int priceToBuyHouse, int numOfPropertiesToCompleteMonopoly){
		myRounder = new Rounder();
		this.name = name;
		this.rent = new int[6];
		this.rent = rent;
		this.colorOfProperty = colorOfProperty;
		this.price = price;
		isMortgaged = false;
		noOfHouses = 0;
		this.priceToBuyHouse = priceToBuyHouse;
		this.numOfPropertiesToCompleteMonopoly = numOfPropertiesToCompleteMonopoly;
	}

	public void setColorOfProperty(String colorOfProperty){
		this.colorOfProperty = colorOfProperty;
	}
	public String getColorOfProperty(){
		return colorOfProperty;
	}


	public void setRent(int rent, int noOfHouses)
	{
		this.rent[noOfHouses] = rent;
	}

	public int getRent(){
		/*if (checkIfHasHotel()){
			return rent[5];
		}
		else {*/
			return rent[noOfHouses];
		//}
	}

	public int getPriceToBuyHouse() {
		return priceToBuyHouse;
	}

	@Override
	public boolean DoAction(Player player) {
		if (isOwned && !player.equals(owner)) {
			int rent = getRent();
			boolean success = player.getCreditCard().subtractMoney(rent);
			if (!success ) {
				return false;
			}
			owner.getCreditCard().addMoney(rent);
		}
		return true;
	}

	public boolean buyHouse(Property property, int housesToBuy){
		if(!owner.checkIfHasMonopoly(property.colorOfProperty)){
			return false;
		}
		else if(checkIfHasHotel()){
			return false;
		}
		else if(!owner.getCreditCard().subtractMoney(housesToBuy*priceToBuyHouse)){
			return false;
		}
		owner.getCreditCard().subtractMoney(housesToBuy*priceToBuyHouse);
		return true;
	}

	public boolean checkIfHasHotel(){
		if(noOfHouses == 5){
			return true;
		}
		return false;
	}
}