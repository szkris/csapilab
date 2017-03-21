
import java.util.*;

/**
 * Alagút bejáratot megvalósító osztály
 */
public class TunnelEntrance extends Rail {

    /**
     * Default constructor
     */
    public TunnelEntrance() {
    	System.out.println("Constructor TunnelEntrance");
    }

    /**
     * tárolja, hogy a bejárat aktív-e
     */
    private boolean open;
    
    /**
     * mutató a pályára
     */
    private Table table = new Table();

    /**
     * visszaadja, hogy a bejárat aktív-e
     * @return boolean aktív-e
     */
    public boolean isOpen() {
        // TODO implement here
    	System.out.println("TunnelEntrance.isOpen");
        return open;
    }

    /**
     * megváltoztatja a bejárat állapotát, nyitva illetve zárva között
     * @return
     */
    public void changeStatus() {
    	System.out.println("TunnelEntrance.changeStatus");
    	if (open == true) open = false;
    	if (open == false) open = true;
    }
    
    /**
     * megvalósítja, hogy mi történjen amikor egy alagút bejáratra kattintunk
     */
    public void click(){
    	System.out.println("TunnelEntrance.click");
    	table.openTunnel(this);
    }

    /**
     * megvalósítja, mi történjen, amikor egy TrainElement a mezõre lép
     */
    public void stepOn(TrainElement te) {
    	System.out.println("TunnelEntrance.steOn");
    	if(occupied) Game.gameOver();
    	setOccupied(true);
    	te.setTunnelEntrance(this);
    	te.setTableElement(this);
    }
    
    /**
     * megvalósítja, mi történjen, amikor egy TrainElement elhagyja a mezõt
     */
    public void stepOff() {
    	System.out.println("TunnelEntrance.stepOff");
    	setOccupied(false);
    }
}