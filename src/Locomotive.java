
import java.util.*;

/**
 * A mozdonyt megval�s�t� oszt�ly
 */
public class Locomotive extends TrainElement {

    /*
     * mutat� a vonatra, amely a mozdonyt tartalmazza
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