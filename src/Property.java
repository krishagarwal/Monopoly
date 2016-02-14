public class Property extends Place{
	private int price;
	private int defaultRent;
	private String colorOfProperty;
	private int[] rent;
	private boolean isOwned;
	private Player ownerOfProperty;

	Property(int defaultRent, String colorOfProperty, int price, int[] rent){
		this.rent = new int[4];
		this.defaultRent = defaultRent;
		this.colorOfProperty = colorOfProperty;
		this.price = price;
		this.rent = rent;
	}

	public void setDefaultRent(int defaultRent){
		this.defaultRent = defaultRent;
	}
	public int getDefaultRent(){
		return defaultRent;
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

	public void setRent(int rent, int position)
	{
		this.rent[position] = rent;
	}
	public int getRent(int position){
		return rent[position];
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
}