import java.util.*;

/**
 * 
 */
public class TunnelEntrance extends Rail {

    /**
     * Default kontruktor.
     */
    public TunnelEntrance() {
    	
    }

    /**
     * Ebben a tagv�ltoz�ban t�rol�dik, hogy egy alag�t z�rva van-e, vagy nyitva. True = nyitva, false = z�rva.
     */
    private boolean open;

    /**
     *
     */
    private Table table;

    /**
     * @return Visszaadja, hogy nyitva van-e az alag�tbej�rat.
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Egy alag�tbej�rat �ll�s�t az ellenkez�j�re v�ltoztatja. 
     */
    public void changeStatus() {
    	open = !open;
    }

}