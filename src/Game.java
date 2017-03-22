
import java.io.Console;
import java.util.*;

/**
 * 
 */
public class Game {

	Table tbl;
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
    public Game(String tab) {

    	System.out.println(tab + "Constructor Game");
    	// Inicializ�lja a Table �s a Timer v�ltoz�kat
    	tbl = new Table(tab+"\t");
    	tmr = new Timer(this, tab+"\t");
    	
    	//Be�ll�tjuk a v�ltoz�kat
    	hasMoreMap = true;
    	tick = 0;
    }

    /**
     * @param Train 
     * @param TableElement 
     * @return
     */
    public void startTrain(Train t, TableElement te, String tab) {
    	System.out.println(tab + "Game.startTrain");
    }

    /**
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
     * @return
     */
    public static void gameOver(String tab) {
    	System.out.println(tab + "Game.gameOver");
    }

    /**
     * @return
     */
    public static void victory(String tab) {
    	System.out.println(tab + "Game.victory");
    }

    /**
     * @return
     */
    public void move(String tab) {
    	System.out.println(tab + "Game.move");
    	while(tbl.trainReady(1, tab+"\t")){
    	}
    	
    }

    /**
     * @param boolean 
     * @return
     */
    public void moreMap(boolean hasMoreMap, String tab) {
    	System.out.println(tab + "Game.moreMap");
    }

    /**
     * @return
     */
    public static void mapCompleted(String tab) {
    	System.out.println(tab + "Game.mapCompleted");
    }

}