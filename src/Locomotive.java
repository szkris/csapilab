
import java.util.*;

/**
 * 
 */
public class Locomotive extends TrainElement {

    /**
     * Default constructor
     */
	private Train train;
	
    public Locomotive(Train t, String tab) {
    	System.out.println(tab + "Constructor Locomotive");
    	train = t;
    }
    
}