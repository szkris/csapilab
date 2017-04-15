
import java.util.*;

/**
 * 
 */
public abstract class TrainElement {

    /**
     * Default constructor
     */
    public TrainElement() {
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
     * Egy TrainElement objektum láthatóságát változtatja meg ellenkezõjére.
     */
    public void changeVisibility() {
        visible = !visible;
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
        // TODO implement here
    }

    /**
     * @param TableElement 
     * @return
     */
    public void setTunnelEntrance(TableElement te) {
        // TODO implement here
    }

    /**
     * @param Color 
     * @return
     */
    public void hopOn(Color color) {
        // TODO implement here
    }
}