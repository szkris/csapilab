
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
    public Game(String tab) {

    	System.out.println(tab + "Constructor Game");
    	// Inicializálja a Table és a Timer változókat
    	tbl = new Table(tab+"\t");
    	tmr = new Timer(this, tab+"\t");
    	
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
    public void startTrain(Train t, TableElement te, String tab) {
    	System.out.println(tab + "Game.startTrain");
    }

    /**
     * elindítja a játékot, meghívja a Table loadMap() függvényét
     * @return
     */
    public void run(String tab) {
    	System.out.println(tab + "Game.Run()");
    	tbl.loadMap(tab+"\t");
    	System.out.println(tab + "HasMoreMap: 1-True, 2-False");
    	String _hasmoremap = new Scanner(System.in).nextLine();
    	
    	switch(_hasmoremap){
    	case "1":
    		tbl.loadMap(tab+"\t");
    		moreMap(true, tab+"\t");
    		tmr.start(tab+"\t");
    		tmr.stop(tab+"\t");
    		break;
    	case "2": 
    		victory(tab+"\t");
    		break;
    	}
    		
    }

    /**
     * globális függvény, melyet akkor hívunk meg, ha a játék véget ér (sikertelenül)
     * @return
     */
    public static void gameOver(String tab) {
    	System.out.println(tab + "Game.gameOver");
    }

    /**
     * globális függvény, melyet akkor hívunk meg, ha a játékos gyõz (sikeresen teljesít minden pályát)
     * @return
     */
    public static void victory(String tab) {
    	System.out.println(tab + "Game.victory");
    }

    /**
     * meghívja a vonatok move() függvényét, minden ciklusban
     * @return
     */
    public void move(String tab) {
    	System.out.println(tab + "Game.move");
    	while(tbl.trainReady(1, tab+"\t")){
    	}
    	
    }

    /**
     * visszaadja, hogy van e még betöltendõ pálya
     * @param boolean van e még pálya
     * @return
     */
    public void moreMap(boolean hasMoreMap, String tab) {
    	System.out.println(tab + "Game.moreMap");
    }

    /**
     * globális függvény, melyet akkor hívnak meg, ha a sikerült a pályát teljesíteni
     * @return
     */
    public static void mapCompleted(String tab) {
    	System.out.println(tab + "Game.mapCompleted");
    }

}