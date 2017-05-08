
import java.util.*;

/**
 * J�t�kot megval�s�t� oszt�ly
 */
public class Game {

	public static View view = new View();
	
	/**
	 * Alap�rtelmezett konstruktor
	 */
	public Game() {
		maps.add("map1.xml");
	}
	
	/**
	 * P�ly�t tartalmaz� objektum
	 */
	private static Table table = new Table();
	
	/**
	 * P�ly�k nev�t t�rol� lista
	 */
	private static ArrayList<String> maps = new ArrayList<String>();
	
	/**
	 * Az aktu�lis p�lya sz�ma.
	 */
	private static int level = 0;
	/**
	 * Egy id�egys�g a j�t�k idej�ben.
	 */
	private int tick = 0;

	/**
	 * J�t�khoz tartoz� id�zit�
	 */
	private static Timer timer;
	
	/**
	 * Elind�tja a j�t�kot.
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
	 * A j�t�k v�gekor ker�l megh�v�sra.
	 */
	public static void gameOver() {
		timer.stop();
		//TODO gameover
		System.out.println("gameOver");
	}

	/**
	 * Gy�zelem eset�n megh�v�d� f�ggv�ny.
	 */
	public static void victory() {
		timer.stop();
		//TODO victory
		System.out.println("victory");
	}

	/**
	 * Mozgat�st megval�st� oszt�ly
	 */
	public void move() {
		tick++;
		table.move(tick);
	}
	
	/**
	 * Megvizsg�lja, hogy v�gezt�nk-e a p�ly�n, ha igen, bet�lti a k�vetkez�t
	 */
	public static void mapCompleted() {
		if(table.mapCompleted()){
			if(level>=maps.size())
			 	victory();
			loadMap(maps.get(level));
		}
	}

}