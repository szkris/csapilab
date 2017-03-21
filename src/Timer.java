
import java.util.*;

/**
 * 
 */
public class Timer {

	/**
     * Mutat� a Game objektumra
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
        // TODO implement here
    	System.out.println("Timer.start");
    	game.move();
    }

    /**
     * @return
     */
    public void stop() {
        // TODO implement here
    	System.out.println("Timer.stop");
    }

}