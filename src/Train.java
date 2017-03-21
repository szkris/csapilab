
import java.util.*;

/**
 * A vonatot megvalósító osztály
 */
public class Train {

    /**
     * Default constructor
     */
    public Train() {
    	System.out.println("Constructor Train");
    }
    
    /*
     * meghívja a move() függvényt minden TrainElement-re, így a vonat elemei tovább mozognak a pályán
     */
    public void move(){
    	System.out.println("Train.move");
    }
    
    /*
     * leszállítja az utasokat
     */
    public void hopOff(){
    	System.out.println("Train.hopOff");
    }
    
    /*
     * megmondja, hogy a vonat alagútban van e
     */
    public boolean isInTunnel(){
    	System.out.println("Train.isInTunnel");
    	return false;
    }
    
    /*
     * megmondja, hogy a vonat üres e
     */
    public boolean isEmpty(){
    	System.out.println("Train.isEmpty");
    	return false;
    }

}