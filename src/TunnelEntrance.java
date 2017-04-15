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
     * Ebben a tagváltozóban tárolódik, hogy egy alagút zárva van-e, vagy nyitva. True = nyitva, false = zárva.
     */
    private boolean open;

    /**
     *
     */
    private Table table;

    /**
     * @return Visszaadja, hogy nyitva van-e az alagútbejárat.
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Egy alagútbejárat állását az ellenkezõjére változtatja. 
     */
    public void changeStatus() {
    	open = !open;
    }

}