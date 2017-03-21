
import java.util.*;

/**
 * A vas�t�llom�s megval�s�t�s��rt felel�s objektum
 */
public class Station extends Rail {

    /**
     * Default constructor
     */
    public Station() {
    	System.out.println("Constructor Station");
    }
    
    /**
     * Akkor h�vjuk, amikor egy vonat elem az �llom�sra l�p
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