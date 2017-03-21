
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
    }

    /**
     * @return
     */
    public TableElement getEntryPoint() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Train getNextTrain() {
        // TODO implement here
        return null;
    }

    /**
     * @param tick 
     * @return
     */
    public boolean trainReady(int tick) {
        // TODO implement here
        return false;
    }

    /**
     * @param TunnelEntrance 
     * @return
     */
    public boolean openTunnel(TunnelEntrance tunEn) {
        // TODO implement here
        return false;
    }

}