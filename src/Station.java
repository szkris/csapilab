
import java.util.*;

/**
 * 
 */
public class Station extends Rail {

    /**
     * Default constructor
     */
    public Station() {
    	System.out.println("Constructor Station");
    }
    
    public void stepOn(TrainElement te){
    	System.out.println("Rail.StepOn");
    	te.hopOff(Color.red);
    }

    /**
     * 
     */

}