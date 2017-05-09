
import java.awt.Image;
import java.io.IOException;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * J�t�kot megval�s�t� oszt�ly
 */
public class Game{

	public static View view = new View();
	public static boolean running;
	
	/**
	 * Alap�rtelmezett konstruktor
	 */
	public Game() {
		maps.add("map1.xml");
		maps.add("map2.xml");
		view.setTable(table);
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
	private static Timer timer = null;
	
	/**
	 * Elind�tja a j�t�kot.
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
	 * A j�t�k v�gekor ker�l megh�v�sra.
	 */
	public static void gameOver() {
		running=false;
		timer.stop();		
		JOptionPane.showMessageDialog(App.getFrame(), "Game Over!");
		App.Menu();
	}

	/**
	 * Gy�zelem eset�n megh�v�d� f�ggv�ny.
	 */
	public static void victory() {
		running=false;
		timer.stop();
		JOptionPane.showMessageDialog(App.getFrame(), "Victory!");
		App.Menu();
	}

	/**
	 * Mozgat�st megval�st� oszt�ly
	 */
	public void move() {
		tick++;
		if(!running)
			return;
		table.move(tick);
		view.drawAll();
	}
	
	/**
	 * Megvizsg�lja, hogy v�gezt�nk-e a p�ly�n, ha igen, bet�lti a k�vetkez�t
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