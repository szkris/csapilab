
import java.util.*;

/**
 * 
 */
public class TableElement implements ITableElement {

    /**
     * Default constructor
     */
	
	
	public TableElement(){
		
	}
    public TableElement(String tab) {
    	System.out.println(tab + "Constructor TableElement");
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
    public void setOccupied(boolean bool, String tab) {
    	System.out.println(tab + "TableElement.setOccupied");
    }

    /**
     * @return
     */
    public void stepOff(String tab ) {
    	System.out.println(tab + "TableElement.stepOff");
    	setOccupied(false, tab+"\t");
    }

    /**
     * @return
     */
    public void click(String tab) {
    	System.out.println(tab + "TableElement.click");
    }

    /**
     * @param TrainElement 
     * @return
     */
    public void nextElement(TrainElement te, String tab) {
    	System.out.println(tab + "TableElement.nextElement");
    }

    /**
     * @param TrainElement 
     * @return
     */
    public void stepOn(TrainElement te, String tab) {
    	System.out.println(tab + "TableElement.stepOn");
    	if(occupied) {
    		Game.gameOver(tab+"\t");
    		return;
    	}
    	setOccupied(true, tab+"\t");
    	te.setTableElement(this, tab+"\t");
    }

}