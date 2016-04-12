package com.agarwal;
public abstract class Place {
	protected String name;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public abstract boolean DoAction(Player player);
}
