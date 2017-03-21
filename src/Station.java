
import java.util.*;

/**
 * 
 */
public class Station extends Rail {

    /**
     * Default constructor
     */
    public Station() {
    	System.out.println("Constructor Station");
    }
    
    public void stepOn(TrainElement te) {
    	System.out.println("Rail.stepOn");
    	if(occupied) Game.gameOver();
    	setOccupied(true);
    	te.setTunnelEntrance(this);
    	te.setTableElement(this);
    	te.hopOff(Color.red);
    }

    /**
     * 
     */

}