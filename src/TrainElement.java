
import java.util.*;

/**
 * 
 */
public abstract class TrainElement {

    /**
     * Default constructor
     */
    public TrainElement() {
    	System.out.println("Constructor TrainElement");
    }

    /**
     * 
     */
    private boolean visible;

    /**
     * 
     */
    private TableElement prevTableElement;

    /**
     * 
     */
    private TableElement currentTableElement;

    /**
     * 
     */
    private TableElement enteredTunnel;





    /**
     * @return
     */
    public void changeVisibility() {
        // TODO implement here
    	
    }

    /**
     * @param TableElement 
     * @return
     */
    public void setTableElement(TableElement te) {
        // TODO implement here
    }

    /**
     * @return
     */
    public TableElement getPreviousElement() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void move() {
        // TODO implement here
    }

    /**
     * @param Color 
     * @return
     */
    public void hopOff(Color color) {
    	System.out.println("TrainElement.hopOff");
        // TODO implement here
    }

    /**
     * @param TableElement 
     * @return
     */
    public void setTunnelEntrance(TableElement te) {
        // TODO implement here
    }
}