package com.agarwal;
public class Jail extends Place{
	int chargeToGetOut;

	Jail(int chargeToGetOut){
		this.name = "Jail";
		this.chargeToGetOut = chargeToGetOut;
	}

	public int getChargeToGetOut() {
		return chargeToGetOut;
	}

	@Override
	public boolean DoAction(Player player) {
		return false;
	}
}