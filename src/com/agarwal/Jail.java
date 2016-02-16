package com.agarwal;
public class Jail extends Place{

	Jail(int chargeToGetOut){
		this.name = "Jail";
	}

	public int getChargeToGetOut() {
		return Constants.Jail_Charge;
	}

	public void lockUp(Player player){
		player.isInJail = true;
	}

	@Override
	public boolean DoAction(Player player) {
		if(!player.isInJail){
			return true;
		}
		else if(player.timeServed == 3){
			if(Constants.Jail_Charge > player.getCreditCard().amount){
				return false;
			}
			else{
				player.getCreditCard().subtractMoney(Constants.Jail_Charge);
				player.isInJail = false;
				return true;
			}
		}
		else{
			player.timeServed++;
		}
		return true;
	}
}