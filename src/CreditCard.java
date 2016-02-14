//Ishika
import java.util.Scanner;
public class CreditCard {
    static public double amountOfBalanceInMillion;
    static private String nameOfPlayer;
    static Scanner myScan = new Scanner(System.in);

    CreditCard(String nameOfPlayer){
        amountOfBalanceInMillion = 15;
    }

    private  static void addMoney(String playerName)
    {
        System.out.println("How much should be added to " + playerName + "'s account?");
        amountOfBalanceInMillion = (myScan.nextDouble()) + amountOfBalanceInMillion;
    }

    private static boolean subtractMoney(String playerName)
    {
        System.out.println("How much money should be subtracted from " + playerName + "'s account?");
        double amountInMillion = 0.0;

        if(amountOfBalanceInMillion < amountInMillion){
            System.out.println("Oh no! " + playerName + " doesn't have enough money!");
            return false;
        } else{
            return true;
        }
    }
}
