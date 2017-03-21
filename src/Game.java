
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
    }

    /**
     * @param Train 
     * @param TableElement 
     * @return
     */
    public void startTrain(Train t, TableElement te) {
    	System.out.println("Game.startTrain");
    }

    /**
     * @return
     */
    public void run() {
    	System.out.println("Game.Run()");
    	System.out.println("HasMoreMap: 1-True, 2-False");
    	String _hasmoremap = new Scanner(System.in).nextLine();
    	
    	switch(_hasmoremap){
    	case "1":
    		tbl.loadMap();
    		moreMap(true);
    		tmr.start();
    		tmr.stop();
    		break;
    	case "2": 
    		victory();
    		break;
    	}
    		
    }

    /**
     * @return
     */
    public static void gameOver() {
    	System.out.println("Game.gameOver");
    }

    /**
     * @return
     */
    public static void victory() {
    	System.out.println("Game.victory");
    }

    /**
     * @return
     */
    public void move() {
    	System.out.println("Game.move");
    	while(tbl.trainReady(1)){
    	}
    	
    }

    /**
     * @param boolean 
     * @return
     */
    public void moreMap(boolean hasMoreMap) {
    	System.out.println("Game.moreMap");
    }

    /**
     * @return
     */
    public static void mapCompleted() {
    	System.out.println("Game.mapCompleted");
    }

}