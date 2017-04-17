
import java.util.*;

/**
 * Id�zit�t megval�st� oszt�ly
 */
public class Timer {

	java.util.Timer timer;
	
	/**
	 * Konstruktor, mely �tvesz egy j�t�k oszt�ly elemet.
	 * @param game A j�t�k, amelynek a timer-t sz�njuk.
	 */
	public Timer(Game game) {
		this.game = game;
	}

	/**
	 * A timerhez tartoz� j�t�kmenet
	 */
	private Game game;

	/**
	 * Elind�tja az id�zit�t
	 */
	public void start() {
		timer = new java.util.Timer(true);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				game.move();
			}
		};
		timer.schedule(task, 1000);
	}

	/**
	 * Le�ll�tja az id�z�t�t
	 */
	public void stop() {
		timer.cancel();
	}
}