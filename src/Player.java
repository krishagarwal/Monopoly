import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String nameOfPlayer;
    private ArrayList<Property> propertiesOwned;
    private static Random rand;

    Player(String nameOfPlayer){
        propertiesOwned = new ArrayList<Property>();
        rand = new Random();
        this.nameOfPlayer = nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer){
        this.nameOfPlayer = nameOfPlayer;
    }
    public String getNameOfPlayer(){
        return nameOfPlayer;
    }

    public static void rollDice(){
        diceNumber = rand.nextInt(6) + 1;
    }
    public static int getDiceNumber(){
        return diceNumber;
    }

    public ArrayList<Property> getPropertiesOwned(){
        return propertiesOwned;
    }
}