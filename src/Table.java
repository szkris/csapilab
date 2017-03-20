
import java.util.*;

/**
 * 
 */
public class Table {

    /**
     * Default constructor
     */
    public Table() {
    	System.out.println("Constructor Table");
    }

    /**
     * 
     */
    private int numberOfLevels;

    /**
     * 
     */
    private int currentLevel;




    /**
     * 
     */
    private TunnelEntrance openTunnelEntrances;


    /**
     * @return
     */
    public void loadMap() {
        // TODO implement here
    	System.out.println("Table.loadMap");
    }

    /**
     * @return
     */
    public TableElement getEntryPoint() {
        // TODO implement here
    	System.out.println("Table.getEntryPoint");
        return null;
    }

    /**
     * @return
     */
    public Train getNextTrain() {
        // TODO implement here
    	System.out.println("Table.getNextTrain");
        return null;
    }

    /**
     * @param tick 
     * @return
     */
    public boolean trainReady(int tick) {
        // TODO implement here
    	System.out.println("Table.trainReady");
        return false;
    }

    /**
     * @param TunnelEntrance 
     * @return
     */
    public boolean openTunnel(TunnelEntrance tunEn) {
        // TODO implement here
    	System.out.println("Table.openTunnel");
        return false;
    }

}