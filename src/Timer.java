
import java.util.*;

/**
 * Idözitöt megvalóstó osztály
 */
public class Timer {

	java.util.Timer timer;
	
	/**
	 * Konstruktor, mely átvesz egy játék osztály elemet.
	 * @param game A játék, amelynek a timer-t szánjuk.
	 */
	public Timer(Game game) {
		this.game = game;
	}

	/**
	 * A timerhez tartozó játékmenet
	 */
	private Game game;

	/**
	 * Elindítja az idözitöt
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
	 * Leállítja az idözítöt
	 */
	public void stop() {
		timer.cancel();
	}
}