import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String nameOfPlayer;
    ArrayList<Property> propertiesOwned;

    Player(String nameOfPlayer){
        propertiesOwned = new ArrayList<Property>();
        this.nameOfPlayer = nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer){
        this.nameOfPlayer = nameOfPlayer;
    }
    public String getNameOfPlayer(){
        return nameOfPlayer;
    }
}