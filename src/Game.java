
import java.io.Console;
import java.util.*;

/**
 * 
 */
public class Game {

	Table tbl;
	Timer tmr;
	
    /**
     * Default constructor
     */
    public Game() {
    	System.out.println("Constructor Game");
    	tbl = new Table();
    	tmr = new Timer();
    }

    /**
     * 
     */
    private boolean hasMoreMap;

    /**
     * 
     */
    private int tick;




    /**
     * @param Train 
     * @param TableElement 
     * @return
     */
    public void startTrain(Train t, TableElement te) {
        // TODO implement here
    	System.out.println("Start train");
    }

    /**
     * @return
     */
    public void run() {
        // TODO implement here
    	System.out.println("Run");
    	tbl.loadMap();
    }

    /**
     * @return
     */
    public static void gameOver() {
        // TODO implement here
    	System.out.println("Game over");
    }

    /**
     * @return
     */
    public static void victory() {
        // TODO implement here
    	System.out.println("Victory");
    }

    /**
     * @return
     */
    public void move() {
        // TODO implement here
    	System.out.println("Move");
    }

    /**
     * @param boolean 
     * @return
     */
    public void moreMap(boolean hasMoreMap) {
        // TODO implement here
    	System.out.println("More map");
    }

    /**
     * @return
     */
    public static void mapCompleted() {
        // TODO implement here
    	System.out.println("Map completed");
    }

}