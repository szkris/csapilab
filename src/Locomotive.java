
import java.util.*;

/**
 * A mozdonyt megvalósító osztály
 */
public class Locomotive extends TrainElement {

    /*
     * mutató a vonatra, amely a mozdonyt tartalmazza
     */
	private Train train;
	
	/**
     * Default constructor
     */
    public Locomotive(Train t) {
    	System.out.println("Constructor Locomotive");
    	train = t;
    }
    
}