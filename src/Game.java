
import java.io.Console;
import java.util.*;

/**
 * 
 */
public class Game {

	Table tbl;
	Timer tmr;
	
	/**
     * Tárolja, hogy van-e még betöltendõ pálya
     */
    private boolean hasMoreMap;
    
    /**
     * Az eltelt lépések szám (körök)
     */
    private int tick;
    
    /**
     * Default constructor
     */
    public Game() {

    	System.out.println("Constructor Game");
    	// Inicializálja a Table és a Timer változókat
    	tbl = new Table();
    	tmr = new Timer(this);
    	
    	//Beállítjuk a változókat
    	hasMoreMap = true;
    	tick = 0;

    	//System.out.println("Game objektum létrejott!");
    }

    /**
     * @param Train 
     * @param TableElement 
     * @return
     */
    public void startTrain(Train t, TableElement te) {
        // TODO implement here
    	System.out.println("Game.startTrain(Train t, TableElement te)");
    }

    /**
     * @return
     */
    public void run() {
        // TODO implement here

    	System.out.println("Game.Run()");
    	System.out.println("HasMoreMap: 1-True, 2-False");
    	String _hasmoremap = new Scanner(System.in).nextLine();
    	if(_hasmoremap.equals("1")){
    		tbl.loadMap();
    		moreMap(true);
    		tmr.start();
    		tmr.stop();
    	}
    	if(_hasmoremap.equals("2"))
    		return;
    }

    /**
     * @return
     */
    public static void gameOver() {
        // TODO implement here
    	System.out.println("Game.gameOver()");
    }

    /**
     * @return
     */
    public static void victory() {
        // TODO implement here
    	System.out.println("Game.victory()");
    }

    /**
     * @return
     */
    public void move() {
        // TODO implement here
    	System.out.println("Game.move()");
    	tbl.trainReady(1);
    	
    }

    /**
     * @param boolean 
     * @return
     */
    public void moreMap(boolean hasMoreMap) {
        // TODO implement here
    	System.out.println("moreMap(boolean hasMoreMap)");
    }

    /**
     * @return
     */
    public static void mapCompleted() {
        // TODO implement here
    	System.out.println("mapCompleted()");
    }

}