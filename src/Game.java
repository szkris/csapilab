
import java.util.*;

/**
 * Játékot megvalósító osztály
 */
public class Game {

	private View view;
	
	/**
	 * Alapértelmezett konstruktor
	 */
	public Game() { }
	
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
		timer = new Timer(this);
		//timer.start();
		//Elso palya beoltese
		//loadMap(maps.get(0));
		//level++;
	}
	
	public Table getTable(){
		return table;
	}
	
	public void loadMap(String map){
		table.loadMap(map);
		view = new View();
		//view.loadMap(i);
		
		run();
	}

	/**
	 * A játék végekor kerül meghívásra.
	 */
	public static void gameOver() {
		//timer.stop();
		System.out.println("gameOver");
		System.exit(0);
	}

	/**
	 * Gyõzelem esetén meghívódó függvény.
	 */
	public static void victory() {
		//timer.stop();
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
			victory();
			//TODO következö pályla betöltése
			//if(level>maps.size())
			// 	victory();
			//loadMap(maps.get(level));
			//level++;
		}
	}

}