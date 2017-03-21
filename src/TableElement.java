
import java.util.*;

/**
 * 
 */
public class TableElement implements ITableElement {

    /**
     * Default constructor
     */
    public TableElement() {
    	System.out.println("Constructor TableElement");
    }

    /**
     * látható-e a mezõ
     */
    protected boolean occupied;

    /**
     * A mezõn lévõ vonat elem
     */
    private TrainElement trainelement;

    /**
     * @param boolean 
     * @return
     */
    public void setOccupied(boolean bool) {
        // TODO implement here
    	System.out.println("TableElement.setOccupied");
    }

    /**
     * @return
     */
    public void stepOff() {
        // TODO implement here
    	System.out.println("TableElement.stepOff");
    	setOccupied(false);
    }

    /**
     * @return
     */
    public void click() {
        // TODO implement here
    	System.out.println("TableElement.click");
    }

    /**
     * @param TrainElement 
     * @return
     */
    public void nextElement(TrainElement te) {
        // TODO implement here
    	System.out.println("TableElement.nextElement");
    }

    /**
     * @param TrainElement 
     * @return
     */
    public void stepOn(TrainElement te) {
        // TODO implement here
    	System.out.println("TableElement.stepOn");
    	if(occupied) Game.gameOver();
    	setOccupied(true);
    	te.setTableElement(this);
    }

}