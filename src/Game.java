
import java.util.*;

/**
 * Játékot megvalósító osztály
 */
public class Game {

	public static View view = new View();
	
	/**
	 * Alapértelmezett konstruktor
	 */
	public Game() {
		maps.add("map1.xml");
	}
	
	/**
	 * Pályát tartalmazó objektum
	 */
	private static Table table = new Table();
	
	/**
	 * Pályák nevét tároló lista
	 */
	private static ArrayList<String> maps = new ArrayList<String>();
	
	/**
	 * Az aktuális pálya száma.
	 */
	private static int level = 0;
	/**
	 * Egy idõegység a játék idejében.
	 */
	private int tick = 0;

	/**
	 * Játékhoz tartozó idözitö
	 */
	private static Timer timer;
	
	/**
	 * Elindítja a játékot.
	 */
	public void run() {
		if(timer!=null) timer.stop();
		//Elso palya beoltese
		String map = maps.get(level);
		loadMap(map);
		timer = new Timer(this);
		timer.start();
	}
	
	public Table getTable(){
		return table;
	}
	
	public static void loadMap(String map){
		table.loadMap(map);
		view.loadMap(level);
		level++;
	}

	/**
	 * A játék végekor kerül meghívásra.
	 */
	public static void gameOver() {
		timer.stop();
		//TODO gameover
		System.out.println("gameOver");
	}

	/**
	 * Gyõzelem esetén meghívódó függvény.
	 */
	public static void victory() {
		timer.stop();
		//TODO victory
		System.out.println("victory");
	}

	/**
	 * Mozgatást megvalóstó osztály
	 */
	public void move() {
		tick++;
		table.move(tick);
	}
	
	/**
	 * Megvizsgálja, hogy végeztünk-e a pályán, ha igen, betölti a következöt
	 */
	public static void mapCompleted() {
		if(table.mapCompleted()){
			if(level>=maps.size())
			 	victory();
			loadMap(maps.get(level));
		}
	}

}