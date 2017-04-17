
import java.util.*;

/**
 * �llom�st megval�s�t� oszt�ly
 */
public class Station extends Rail {

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