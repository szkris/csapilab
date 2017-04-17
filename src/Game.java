
import java.util.*;

/**
 * Játékot megvalósító osztály
 */
public class Game {

	/**
	 * Default constructor
	 */
	public Game() { }
	
	/**
	 * Pályát tartalmazó objektum
	 */
	private Table table = new Table();

	/**
	 * Egy idõegység a játék idejében.
	 */
	private int tick;

	/**
	 * Játékhoz tartozó idözitö
	 */
	private Timer timer; 
	/**
	 * Elindítja a játékot.
	 */
	public void run() {
		timer = new Timer(this);
		timer.start();
	}
	
	public void loadMap(String map){
		table.loadMap(map);
	}

	/**
	 * A játék végekor kerül meghívásra.
	 */
	public static void gameOver() {
		// TODO implement here
	}

	/**
	 * Gyõzelem esetén meghívódó függvény.
	 */
	public static void victory() {
		// TODO implement here
	}

	/**
	 * Mozgatást megvalóstó osztály
	 */
	public void move() {
		tick++;
		table.move(tick);
	}
	
	/**
	 * 
	 */
	public static void mapCompleted() {
		// TODO implement here
	}

}