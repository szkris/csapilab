
import java.util.*;

/**
 * A vasútállomás megvalósításáért felelõs objektum
 */
public class Station extends Rail {

    /**
     * Default constructor
     */
    public Station() {
    	System.out.println("Constructor Station");
    }
    
    /**
     * Akkor hívjuk, amikor egy vonat elem az állomásra lép
     */
    public void stepOn(TrainElement te) {
    	System.out.println("Rail.stepOn");
    	if(occupied) Game.gameOver();
    	setOccupied(true);
    	te.setTunnelEntrance(this);
    	te.setTableElement(this);
    	te.hopOff(Color.red);
    }
}