import java.util.*;

/**
 * Egy alagútbejáratot megvalósító függvény.
 */
public class TunnelEntrance extends Rail {

    /**
     * Konstrukor, amiben egy Table-t lehet átadni.
     */
    public TunnelEntrance(Table table) {
    	this.table = table;
    }

    /**
     * Itt tárolódik, hogy a bejárat aktív-e.
     */
    private boolean open;

    /**
     * Tárolja az alagútbejárathoz tartozó Table-t, hogy kommunikálhasson az asztallal.
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