package com.agarwal;

public class Property extends Place{
	private int price;
	private String colorOfProperty;
	private int[] rent;
	private boolean isOwned;
	private Player ownerOfProperty;
	private int noOfHouses;
	private boolean hasHotel;

	Property(String name, String colorOfProperty, int price, int[] rent){
		this.name = name;
		this.rent = new int[6];
		this.rent = rent;
		this.colorOfProperty = colorOfProperty;
		this.price = price;
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

	public void setIsOwned(boolean isOwned){
		this.isOwned = isOwned;
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

	public boolean DoAction(Player player) {
		if (!isOwned) {
			//do nothing
		} else if (player.equals(ownerOfProperty)){
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
}