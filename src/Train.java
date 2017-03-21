
import java.util.*;

/**
 * A vonatot megval�s�t� oszt�ly
 */
public class Train {

    /**
     * Default constructor
     */
    public Train() {
    	System.out.println("Constructor Train");
    }
    
    /*
     * megh�vja a move() f�ggv�nyt minden TrainElement-re, �gy a vonat elemei tov�bb mozognak a p�ly�n
     */
    public void move(){
    	System.out.println("Train.move");
    }
    
    /*
     * lesz�ll�tja az utasokat
     */
    public void hopOff(){
    	System.out.println("Train.hopOff");
    }
    
    /*
     * megmondja, hogy a vonat alag�tban van e
     */
    public boolean isInTunnel(){
    	System.out.println("Train.isInTunnel");
    	return false;
    }
    
    /*
     * megmondja, hogy a vonat �res e
     */
    public boolean isEmpty(){
    	System.out.println("Train.isEmpty");
    	return false;
    }

}