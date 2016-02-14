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

    public ArrayList<Property> getPropertiesOwned(){
        return propertiesOwned;
    }
}