
import java.util.*;

/**
 * Id�egys�genk�nt jelez a Game-nek hogy mozgathassa a p�ly�n l�v� vonatokat
 */
public class Timer {

	/**
     * Mutat� a Game objektumra
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
     * Elind�tja az id�z�t�t ami id�k�z�nk�nt megh�vja a Game move() f�ggv�ny�t
     * @return
     */
    public void start(String tab) {
    	System.out.println(tab + "Timer.start");
    	game.move(tab+"\t");
    }

    /**
     * Le�ll�tja a bels� �r�j�
     * @return
     */
    public void stop(String tab) {
    	System.out.println(tab+ "Timer.stop");
    }

}