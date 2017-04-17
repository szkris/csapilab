
import java.util.*;

/**
 * Állomást megvalósító osztály
 */
public class Station extends Rail {
	
	private String type = "station";

	/**
	 * Konstruktor mely paraméterként megkapja a táblaelem ID-ját.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public Station(int id, Color color) {
		super(id);
		rand = new Random(id);
		this.color = color;
	}
	
	public String getType(){
		return type;
	}
	
	/**
	 * Random szám generátor.
	 */
	private Random rand;	

	/**
	 * Állomás színe
	 */
	private Color color;
	
	public Color getColor(){
		return color;
	}
	
	@Override
	public void stepOn(TrainElement te){
		if(occupied) Game.gameOver();
		setOccupied(true);
		te.setTableElement(this);
		te.hopOff(color);
		if(rand.nextInt()%10==0){
			te.hopOn(color);
		}
	}
}