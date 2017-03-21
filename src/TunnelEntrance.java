
import java.util.*;

/**
 * 
 */
public class TunnelEntrance extends Rail {

    /**
     * Default constructor
     */
    public TunnelEntrance() {
    	System.out.println("Constructor TunnelEntrance");
    }

    /**
     * 
     */
    private boolean open;
    /**
     * 
     */
    private Table table = new Table();

    /**
     * @return
     */
    public boolean isOpen() {
        // TODO implement here
    	System.out.println("TunnelEntrance.isOpen");
        return open;
    }

    /**
     * @return
     */
    public void changeStatus() {
        // TODO implement here
    	System.out.println("TunnelEntrance.changeStatus");
    	if (open == true) open = false;
    	if (open == false) open = true;
    }
    
    public void click(){
    	System.out.println("TunnelEntrance.click()");
    	table.openTunnel(this);
    }

    public void stepOn(TrainElement te) {
        // TODO implement here
    	System.out.println("TunnelEntrance.steOn");
    	if(occupied) Game.gameOver();
    	setOccupied(true);
    	te.setTunnelEntrance(this);
    	te.setTableElement(this);
    }
    
    public void stepOff() {
        // TODO implement here
    	System.out.println("TunnelEntrance.stepOff");
    	setOccupied(false);
    }
}