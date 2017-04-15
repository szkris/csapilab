import java.util.*;

/**
 * 
 */
public abstract class TableElement implements ITableElement {

	
	/**
	 * Az elemet meghatározó azonosító.
	 */
	final int id;
	
    /**
     * Default konstruktor.
     * @param id Az elem ID-ja.
     */
    public TableElement(int id) {
    	this.id = id;
    }

    /**
     * 
     */
    protected boolean occupied;

    /**
     * 
     */
    private TrainElement trainelement;

    /**
     * @param boolean 
     * @return
     */
    public void setOccupied(boolean te) {
        // TODO implement here
        
    }
}