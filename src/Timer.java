
import java.util.*;

/**
 * Idõegységenként jelez a Game-nek hogy mozgathassa a pályán lévõ vonatokat
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
     * Elindítja az idõzítõt ami idõközönként meghívja a Game move() függvényét
     * @return
     */
    public void start() {
    	System.out.println("Timer.start");
    	game.move();
    }

    /**
     * Leállítja a belsõ órájá
     * @return
     */
    public void stop() {
    	System.out.println("Timer.stop");
    }

}