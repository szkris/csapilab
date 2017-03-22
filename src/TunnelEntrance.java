
import java.util.*;

/**
 * 
 */
public class TunnelEntrance extends Rail {

    /**
     * Default constructor
     */
    public TunnelEntrance(String tab) {
    	System.out.println(tab + "Constructor TunnelEntrance");
    	table = new Table(tab + "\t");
    }

    /**
     * 
     */
    private boolean open;
    /**
     * 
     */
    private Table table;

    /**
     * @return
     */
    public boolean isOpen(String tab) {
    	System.out.println(tab + "TunnelEntrance.isOpen");
        return open;
    }

    /**
     * @return
     */
    public void changeStatus(String tab) {
    	System.out.println(tab + "TunnelEntrance.changeStatus");
    	if (open == true) open = false;
    	if (open == false) open = true;
    }
    
    public void click(String tab){
    	System.out.println(tab + "TunnelEntrance.click");
    	table.openTunnel(this, tab+"\t");
    }

    public void stepOn(TrainElement te, String tab) {
    	if(!open) {
    		Game.gameOver(tab+"\t");
    		return;
    	}
    	System.out.println(tab + "TunnelEntrance.stepOn");
    	if(occupied) {
    		Game.gameOver(tab+"\t");
    		return;
    	}
    	setOccupied(true, tab+"\t");
    	te.setTunnelEntrance(this, tab+"\t");
    	te.setTableElement(this, tab+"\t");
    }
    
    public void stepOff(String tab) {
    	System.out.println(tab + "TunnelEntrance.stepOff");
    	setOccupied(false, tab+"\t");
    }
}