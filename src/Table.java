
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
    public Table(String tab) {
    	System.out.println(tab + "Constructor Table");
    }

    /**
     * @return
     */
    public void loadMap(String tab) {
    	System.out.println(tab + "Table.loadMap");
    }

    /**
     * @return
     */
    public TableElement getEntryPoint(String tab) {
    	System.out.println(tab + "Table.getEntryPoint");
        return null;
    }

    /**
     * @return
     */
    public Train getNextTrain(String tab) {
    	System.out.println(tab + "Table.getNextTrain");
        return null;
    }

    /**
     * @param tick 
     * @return
     */
    public boolean trainReady(int tick, String tab) {
    	System.out.println(tab + "Table.trainReady()");
        System.out.println(tab + "1-ready, 2-not ready");
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
    public boolean openTunnel(TunnelEntrance tunEn, String tab) {
    	System.out.println(tab + "Table.openTunnel");
    	openTunnelEntrances = tunEn;
    	openTunnelEntrances.changeStatus(tab+"\t");
        return false;
    }

}