
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
    public Game() {

    	System.out.println("Constructor Game");
    	// Inicializ�lja a Table �s a Timer v�ltoz�kat
    	tbl = new Table();
    	tmr = new Timer(this);
    	
    	//Be�ll�tjuk a v�ltoz�kat
    	hasMoreMap = true;
    	tick = 0;

    	//System.out.println("Game objektum l�trejott!");
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
    	System.out.println("Game.move()");
    	while(tbl.trainReady(1)){
    		//do nothing
    	}
    	
    }

    /**
     * @param boolean 
     * @return
     */
    public void moreMap(boolean hasMoreMap) {
        // TODO implement here
    	System.out.println("Game.moreMap(boolean hasMoreMap)");
    }

    /**
     * @return
     */
    public static void mapCompleted() {
        // TODO implement here
    	System.out.println("Game.mapCompleted()");
    }

}