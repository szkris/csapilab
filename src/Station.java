
import java.util.*;

/**
 * �llom�st megval�s�t� oszt�ly
 */
public class Station extends Rail {

	/**
	 * Az �llom�son �ll� vonatelemet t�rolja. Ha nincs rajta semmi, akkor null.
	 */
	private TrainElement currentElement = null;
	
	/**
	 * Konstruktor mely param�terk�nt megkapja a t�blaelem ID-j�t.
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
	 * Random sz�m gener�tor.
	 */
	private Random rand;	

	/**
	 * �llom�s sz�ne
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
	 * Felsz�ll�tja az utasokat a vonat kocsij�ra
	 * @param te A param�terk�nt kapott kocsi
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