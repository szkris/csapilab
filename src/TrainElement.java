
import java.util.*;

/**
 * 
 */
public abstract class TrainElement {

    /**
     * Default constructor
     */
	public TrainElement(){}
	
    public TrainElement(String tab) {
    	System.out.println(tab + "Constructor TrainElement");
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
    public void changeVisibility(String tab) {
    	System.out.println(tab + "TrainElement.changeVisibility");
    }

    /**
     * @param TableElement 
     * @return
     */
    public void setTableElement(TableElement te, String tab) {
        System.out.println(tab + "TrainElement.setTableElement");
    }

    /**
     * @return
     */
    public TableElement getPreviousElement(String tab) {
        System.out.println(tab + "TrainElement.getPreviousElement");
        return null;
    }

    /**
     * @return
     */
    public void move(String tab) {
        System.out.println(tab + "TrainElement.move");
    }

    /**
     * @param Color 
     * @return
     */
    public void hopOff(Color color, String tab) {
    	System.out.println(tab + "TrainElement.hopOff");
    }

    /**
     * @param TableElement 
     * @return
     */
    public void setTunnelEntrance(TableElement te, String tab) {
    	System.out.println(tab + "TrainElement.setTunnelEntrance");
    }
}