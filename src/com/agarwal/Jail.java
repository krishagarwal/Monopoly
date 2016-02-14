package com.agarwal;
public class Jail extends Place{
	int chargeToGetOut;

	Jail(int chargeToGetOut){
		this.nameOfSpace = "Jail";
		this.chargeToGetOut = chargeToGetOut;
	}

	public void setChargeToGetOut(int chargeToGetOut) {
		this.chargeToGetOut = chargeToGetOut;
	}
	public int getChargeToGetOut() {
		return chargeToGetOut;
	}
}