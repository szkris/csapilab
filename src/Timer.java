
import java.util.*;

/**
 * 
 */
public class Timer {

	/**
     * Mutató a Game objektumra
     */
    private Game game;
	
    /**
     * Default constructor
     */
    public Timer(Game g, String tab) {
    	System.out.println(tab + "Constructor Timer");
    	game = g;
    }

    /**
     * @return
     */
    public void start(String tab) {
    	System.out.println(tab + "Timer.start");
    	game.move(tab+"\t");
    }

    /**
     * @return
     */
    public void stop(String tab) {
    	System.out.println(tab+ "Timer.stop");
    }

}