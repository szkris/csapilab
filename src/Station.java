
import java.util.*;

/**
 * 
 */
public class Station extends Rail {

    /**
     * Default constructor
     */
    public Station(String tab) {
    	System.out.println(tab + "Constructor Station");
    }
    
    public void stepOn(TrainElement te, String tab) {
    	System.out.println(tab + "Rail.stepOn");
    	if(occupied){
    		Game.gameOver(tab+"\t");
    		return;
    	}
    	setOccupied(true, tab+"\t");
    	te.setTunnelEntrance(this, tab+"\t");
    	te.setTableElement(this, tab+"\t");
    	te.hopOff(Color.red, tab+"\t");
    }

    /**
     * 
     */

}