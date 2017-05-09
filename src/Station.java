
import java.util.*;

/**
 * Állomást megvalósító osztály
 */
public class Station extends Rail {

	/**
	 * Az állomáson álló vonatelemet tárolja. Ha nincs rajta semmi, akkor null.
	 */
	private TrainElement currentElement = null;
	
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
		type = "station";
	}
	
	/**
	 * Random szám generátor.
	 */
	private Random rand;	

	/**
	 * Állomás színe
	 */
	private Color color;
	
	// TODO comment
	/**
	 * 
	 * @return
	 */
	public Color getColor(){
		return color;
	}
	
	@Override
	public void stepOn(TrainElement te){
		if(occupied) Game.gameOver();
		setOccupied(true);
		currentElement = te;
		te.setTableElement(this);
		te.hopOff(color);
		
		if(App.random){
			if(rand.nextInt()%10==0){
				hopOn();
			}
		}
	}
	
	public TrainElement getCurrentElement(){
		return currentElement;
	}
	
	@Override
	public void stepOff(){
		setOccupied(false);
		currentElement = null;
	}
	
	/**
	 * Felszállítja az utasokat a vonat kocsijára
	 * @param te A paraméterként kapott kocsi
	 */
	public void hopOn(){
		if(currentElement!=null) currentElement.hopOn(color);
	}
	
	@Override
	public ArrayList<Integer> getNeighbours(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(elem1!=null)
			list.add(elem1.getId());
		else 
			list.add(0);
		if(elem2!=null)
			list.add(elem2.getId());
		else
			list.add(0);
		return list;
	}
}