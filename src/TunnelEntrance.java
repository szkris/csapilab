
import java.util.*;

/**
 * 
 */
public class TunnelEntrance extends Rail {

    /**
     * Default constructor
     */
    public TunnelEntrance() {
    	System.out.println("Constructor TunnelEntrance");
    }

    /**
     * 
     */
    private boolean open;

    /**
     * 
     */
    private Table table;

    /**
     * @return
     */
    public boolean isOpen() {
        // TODO implement here
    	System.out.println("TunnelEntrance.isOpen");
        return open;
    }

    /**
     * @return
     */
    public void changeStatus() {
        // TODO implement here
    	System.out.println("TunnelEntrance.changeStatus");
    	if (open == true) open = false;
    	if (open == false) open = true;
    }

}