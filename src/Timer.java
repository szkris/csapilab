
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
    public Timer(Game g, String tab) {
    	System.out.println(tab + "Constructor Timer");
    	game = g;
    }

    /**
     * Elindítja az idõzítõt ami idõközönként meghívja a Game move() függvényét
     * @return
     */
    public void start(String tab) {
    	System.out.println(tab + "Timer.start");
    	game.move(tab+"\t");
    }

    /**
     * Leállítja a belsõ órájá
     * @return
     */
    public void stop(String tab) {
    	System.out.println(tab+ "Timer.stop");
    }

}