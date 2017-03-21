
import java.util.*;

/**
 * 
 */
public class TunnelEntrance extends Rail {

    /**
     * Default constructor
     */
    public TunnelEntrance(Table t) {
    	System.out.println("Constructor TunnelEntrance");
    	table = t;
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
        return false;
    }

    /**
     * @return
     */
    public void changeStatus() {
        // TODO implement here
    	System.out.println("TunnelEntrance.changeStatus");
    }
    
    public void click(){
    	System.out.println("TunnelEntrance.click()");
    	table.openTunnel(this);
    }

}