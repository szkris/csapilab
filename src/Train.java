
import java.util.*;

/**
 * 
 */
public class Train {

    /**
     * Default constructor
     */
    public Train(String tab) {
    	System.out.println(tab + "Constructor Train");
    }
    
    public void move(String tab){
    	System.out.println(tab + "Train.move");
    }
    
    public void hopOff(String tab){
    	System.out.println(tab + "Train.hopOff");
    }
    
    public boolean isInTunnel(String tab){
    	System.out.println(tab + "Train.isInTunnel");
    	return false;
    }
    
    public boolean isEmpty(String tab){
    	System.out.println(tab + "Train.isEmpty");
    	return false;
    }

}