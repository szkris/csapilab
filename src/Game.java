
import java.io.Console;
import java.util.*;

/**
 * 
 */
public class Game {

	/*
	 * mutató a táblára
	 */
	Table tbl;
	
	/*
	 * mutató a timer-re
	 */
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
     * Elindítja a paraméterként kapott vonatot a paraméteerként kapott helyrõl.
     * @param Train mutató a vonatra
     * @param TableElement a pálya azon pontja ahonnan a vonat indul
     * @return
     */
    public void startTrain(Train t, TableElement te) {
    	System.out.println("Game.startTrain");
    }

    /**
     * elindítja a játékot, meghívja a Table loadMap() függvényét
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
     * globális függvény, melyet akkor hívunk meg, ha a játék véget ér (sikertelenül)
     * @return
     */
    public static void gameOver() {
    	System.out.println("Game.gameOver");
    }

    /**
     * globális függvény, melyet akkor hívunk meg, ha a játékos gyõz (sikeresen teljesít minden pályát)
     * @return
     */
    public static void victory() {
    	System.out.println("Game.victory");
    }

    /**
     * meghívja a vonatok move() függvényét, minden ciklusban
     * @return
     */
    public void move() {
    	System.out.println("Game.move");
    	while(tbl.trainReady(1)){
    	}
    	
    }

    /**
     * visszaadja, hogy van e még betöltendõ pálya
     * @param boolean van e még pálya
     * @return
     */
    public void moreMap(boolean hasMoreMap) {
    	System.out.println("Game.moreMap");
    }

    /**
     * globális függvény, melyet akkor hívnak meg, ha a sikerült a pályát teljesíteni
     * @return
     */
    public static void mapCompleted() {
    	System.out.println("Game.mapCompleted");
    }

}