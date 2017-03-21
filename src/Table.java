
import java.util.*;

/**
 * 
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
     * @return
     */
    public void loadMap() {
    	System.out.println("Table.loadMap");
    }

    /**
     * @return
     */
    public TableElement getEntryPoint() {
    	System.out.println("Table.getEntryPoint");
        return null;
    }

    /**
     * @return
     */
    public Train getNextTrain() {
    	System.out.println("Table.getNextTrain");
        return null;
    }

    /**
     * @param tick 
     * @return
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
     * @param TunnelEntrance 
     * @return
     */
    public boolean openTunnel(TunnelEntrance tunEn) {
    	System.out.println("Table.openTunnel");
    	openTunnelEntrances = tunEn;
    	openTunnelEntrances.changeStatus();
        return false;
    }

}