
import java.util.*;

/**
 * A Table osztály tárolja a pálya elemeit
 */
public class Table {

	/**
     * Szintek száma
     */
    private int numberOfLevels;

    /**
     * Aktuális szint
     */
    private int currentLevel;
    
    /**
     * A nyitott alagútbejáratok
     */
    private TunnelEntrance openTunnelEntrances;
    
    /**
     * A vonatokat tároló lista
     */
    private ArrayList<Train> trains;
	
    /**
     * Default constructor
     */
    public Table() {
    	System.out.println("Constructor Table");
    }

    /**
     * betölti a következ pályát
     * @return
     */
    public void loadMap() {
    	System.out.println("Table.loadMap");
    }

    /**
     * véletlenszerûen választ egy belépési pontot a vonatnak
     * @return
     */
    public TableElement getEntryPoint() {
    	System.out.println("Table.getEntryPoint");
        return null;
    }

    /**
     * visszaadja a soron következõ vonatot a trains listából
     * @return
     */
    public Train getNextTrain() {
    	System.out.println("Table.getNextTrain");
        return null;
    }

    /**
     * megmmondja hogy a paraméterként kapott idõpillanatban kell e indítani vonatot
     * @param tick idõpillanat (idõegység)
     * @return boolean kell e indítani vonatot
     */
    public boolean trainReady(int tick) {
    	System.out.println("Table.trainReady()");
        System.out.println("1-ready, 2-not ready");
        String ready = new Scanner(System.in).nextLine();
        if (ready.equals("1")){
        	return true;
        }
        if (ready.equals("2")){
        	return false;
        }
        return false;
    }

    /**
     * a TunnelEntrance hívja meg, a table tudja, hogy hány alagútbejárat van nyitva, ettõl függ hogy kattintásra nyit e új bejáratot
     * @param TunnelEntrance alagút bejárat
     * @return sikerült e az alagút nyitás
     */
    public boolean openTunnel(TunnelEntrance tunEn) {
    	System.out.println("Table.openTunnel");
    	openTunnelEntrances = tunEn;
    	openTunnelEntrances.changeStatus();
        return false;
    }

}