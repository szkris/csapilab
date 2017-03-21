
import java.util.*;

/**
 * Alag�t bej�ratot megval�s�t� oszt�ly
 */
public class TunnelEntrance extends Rail {

    /**
     * Default constructor
     */
    public TunnelEntrance() {
    	System.out.println("Constructor TunnelEntrance");
    }

    /**
     * t�rolja, hogy a bej�rat akt�v-e
     */
    private boolean open;
    
    /**
     * mutat� a p�ly�ra
     */
    private Table table = new Table();

    /**
     * visszaadja, hogy a bej�rat akt�v-e
     * @return boolean akt�v-e
     */
    public boolean isOpen() {
        // TODO implement here
    	System.out.println("TunnelEntrance.isOpen");
        return open;
    }

    /**
     * megv�ltoztatja a bej�rat �llapot�t, nyitva illetve z�rva k�z�tt
     * @return
     */
    public void changeStatus() {
    	System.out.println("TunnelEntrance.changeStatus");
    	if (open == true) open = false;
    	if (open == false) open = true;
    }
    
    /**
     * megval�s�tja, hogy mi t�rt�njen amikor egy alag�t bej�ratra kattintunk
     */
    public void click(){
    	System.out.println("TunnelEntrance.click");
    	table.openTunnel(this);
    }

    /**
     * megval�s�tja, mi t�rt�njen, amikor egy TrainElement a mez�re l�p
     */
    public void stepOn(TrainElement te) {
    	System.out.println("TunnelEntrance.steOn");
    	if(occupied) Game.gameOver();
    	setOccupied(true);
    	te.setTunnelEntrance(this);
    	te.setTableElement(this);
    }
    
    /**
     * megval�s�tja, mi t�rt�njen, amikor egy TrainElement elhagyja a mez�t
     */
    public void stepOff() {
    	System.out.println("TunnelEntrance.stepOff");
    	setOccupied(false);
    }
}