package com.agarwal;
public class Jail extends Place{

	Jail(){
		this.name = "Jail";
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