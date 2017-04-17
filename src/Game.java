
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
	 * Elindítja a játékot.
	 */
	public void run() {
		//TODO
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
	}
	
	/**
	 * 
	 */
	public static void mapCompleted() {
		// TODO implement here
	}

}