
import java.util.*;

/**
 * 
 */
public class Train {

    /**
     * Default constructor
     */
    public Train() {
    	System.out.println("Constructor Train");
    }
    
    public void move(){
    	System.out.println("Train.move()");
    }
    
    public void hopOff(){
    	System.out.println("Train.hopOff()");
    }
    
    public boolean isInTunnel(){
    	System.out.println("Train.isInTunnel()");
    	return false;
    }
    
    public boolean isEmpty(){
    	System.out.println("Train.isEmpty()");
    	return false;
    }

}