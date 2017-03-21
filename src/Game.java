
import java.io.Console;
import java.util.*;

/**
 * 
 */
public class Game {

	/*
	 * mutat� a t�bl�ra
	 */
	Table tbl;
	
	/*
	 * mutat� a timer-re
	 */
	Timer tmr;
	
	/**
     * T�rolja, hogy van-e m�g bet�ltend� p�lya
     */
    private boolean hasMoreMap;
    
    /**
     * Az eltelt l�p�sek sz�m (k�r�k)
     */
    private int tick;
    
    /**
     * Default constructor
     */
    public Game() {

    	System.out.println("Constructor Game");
    	// Inicializ�lja a Table �s a Timer v�ltoz�kat
    	tbl = new Table();
    	tmr = new Timer(this);
    	
    	//Be�ll�tjuk a v�ltoz�kat
    	hasMoreMap = true;
    	tick = 0;
    }

    /**
     * Elind�tja a param�terk�nt kapott vonatot a param�teerk�nt kapott helyr�l.
     * @param Train mutat� a vonatra
     * @param TableElement a p�lya azon pontja ahonnan a vonat indul
     * @return
     */
    public void startTrain(Train t, TableElement te) {
    	System.out.println("Game.startTrain");
    }

    /**
     * elind�tja a j�t�kot, megh�vja a Table loadMap() f�ggv�ny�t
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
     * glob�lis f�ggv�ny, melyet akkor h�vunk meg, ha a j�t�k v�get �r (sikertelen�l)
     * @return
     */
    public static void gameOver() {
    	System.out.println("Game.gameOver");
    }

    /**
     * glob�lis f�ggv�ny, melyet akkor h�vunk meg, ha a j�t�kos gy�z (sikeresen teljes�t minden p�ly�t)
     * @return
     */
    public static void victory() {
    	System.out.println("Game.victory");
    }

    /**
     * megh�vja a vonatok move() f�ggv�ny�t, minden ciklusban
     * @return
     */
    public void move() {
    	System.out.println("Game.move");
    	while(tbl.trainReady(1)){
    	}
    	
    }

    /**
     * visszaadja, hogy van e m�g bet�ltend� p�lya
     * @param boolean van e m�g p�lya
     * @return
     */
    public void moreMap(boolean hasMoreMap) {
    	System.out.println("Game.moreMap");
    }

    /**
     * glob�lis f�ggv�ny, melyet akkor h�vnak meg, ha a siker�lt a p�ly�t teljes�teni
     * @return
     */
    public static void mapCompleted() {
    	System.out.println("Game.mapCompleted");
    }

}