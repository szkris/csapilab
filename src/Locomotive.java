
import java.util.*;

/**
 * 
 */
public class Locomotive extends TrainElement {

    /**
     * Default constructor
     */
	private Train train;
	
    public Locomotive(Train t) {
    	System.out.println("Constructor Locomotive");
    	train = t;
    }
    
}