
import java.util.*;

/**
 * J�t�kot megval�s�t� oszt�ly
 */
public class Game {

	/**
	 * Alap�rtelmezett konstruktor
	 */
	public Game() { }
	
	/**
	 * P�ly�t tartalmaz� objektum
	 */
	private Table table = new Table();

	/**
	 * Egy id�egys�g a j�t�k idej�ben.
	 */
	private int tick = 0;

	/**
	 * J�t�khoz tartoz� id�zit�
	 */
	private Timer timer;
	
	/**
	 * Elind�tja a j�t�kot.
	 */
	public void run() {
		timer = new Timer(this);
		timer.start();
	}
	
	public void loadMap(String map){
		table.loadMap(map);
	}

	/**
	 * A j�t�k v�gekor ker�l megh�v�sra.
	 */
	public static void gameOver() {
		// TODO implement here
	}

	/**
	 * Gy�zelem eset�n megh�v�d� f�ggv�ny.
	 */
	public static void victory() {
		// TODO implement here
	}

	/**
	 * Mozgat�st megval�st� oszt�ly
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