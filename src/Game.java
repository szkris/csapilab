
import java.awt.Image;
import java.io.IOException;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Játékot megvalósító osztály
 */
public class Game{

	public static View view = new View();
	public static boolean running;
	
	/**
	 * Alapértelmezett konstruktor
	 */
	public Game() {
		maps.add("map1.xml");
		maps.add("map2.xml");
		view.setTable(table);
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
	private static Timer timer = null;
	
	/**
	 * Elindítja a játékot.
	 * @throws IOException 
	 */
	public void run() {		
		if(timer!=null) timer.stop();
		level=0;
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
		running=true;
	}

	/**
	 * A játék végekor kerül meghívásra.
	 */
	public static void gameOver() {
		running=false;
		timer.stop();		
		JOptionPane.showMessageDialog(App.getFrame(), "Game Over!");
		App.Menu();
	}

	/**
	 * Gyõzelem esetén meghívódó függvény.
	 */
	public static void victory() {
		running=false;
		timer.stop();
		JOptionPane.showMessageDialog(App.getFrame(), "Victory!");
		App.Menu();
	}

	/**
	 * Mozgatást megvalóstó osztály
	 */
	public void move() {
		tick++;
		if(!running)
			return;
		table.move(tick);
		view.drawAll();
	}
	
	/**
	 * Megvizsgálja, hogy végeztünk-e a pályán, ha igen, betölti a következöt
	 */
	public static void mapCompleted() {
		if(table.mapCompleted()){
			running=false;
			if(level>=maps.size())
				victory();				
			else{
				JOptionPane.showMessageDialog(App.getFrame(), "Map completed!");
				loadMap(maps.get(level));
			}
		}
	}

}