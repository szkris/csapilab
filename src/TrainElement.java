
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
    	System.out.println("TrainElement.changeVisibility");
    }

    /**
     * @param TableElement 
     * @return
     */
    public void setTableElement(TableElement te) {
        System.out.println("TrainElement.setTableElement");
    }

    /**
     * @return
     */
    public TableElement getPreviousElement() {
        System.out.println("TrainElement.getPreviousElement");
        return null;
    }

    /**
     * @return
     */
    public void move() {
        System.out.println("TrainElement.move");
    }

    /**
     * @param Color 
     * @return
     */
    public void hopOff(Color color) {
    	System.out.println("TrainElement.hopOff");
    }

    /**
     * @param TableElement 
     * @return
     */
    public void setTunnelEntrance(TableElement te) {
    	System.out.println("TrainElement.setTunnelEntrance");
    }
}