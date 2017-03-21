
import java.util.*;

/**
 * 
 */
public class TableElement implements ITableElement {

    /**
     * Default constructor
     */
    public TableElement() {
    	System.out.println("	Constructor TableElement");
    }

    /**
     * 
     */
    private boolean occupied;



    /**
     * 
     */
    private TrainElement trainelement;

    /**
     * @param boolean 
     * @return
     */
    public void setOccupied(boolean occupied) {
        // TODO implement here
    	System.out.println("	TableElement.setOccupied");
    }

    /**
     * @return
     */
    public void stepOff() {
        // TODO implement here
    	System.out.println("	TableElement.stepOff");
    }

    /**
     * @return
     */
    public void click() {
        // TODO implement here
    	System.out.println("	TableElement.click");
    }

    /**
     * @param TrainElement 
     * @return
     */
    public void nextElement(TrainElement te) {
        // TODO implement here
    	System.out.println("	TableElement.nextElement");
    }

    /**
     * @param TrainElement 
     * @return
     */
    public void stepOn(TrainElement te) {
        // TODO implement here
    	System.out.println("	TableElement.steOn");
    }

}