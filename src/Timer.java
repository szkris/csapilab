
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
    public Timer(Game g) {
    	System.out.println("Constructor Timer");
    	game = g;
    }

    /**
     * @return
     */
    public void start() {
    	System.out.println("Timer.start");
    	game.move();
    }

    /**
     * @return
     */
    public void stop() {
    	System.out.println("Timer.stop");
    }

}