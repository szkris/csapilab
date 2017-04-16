
import java.util.*;

/**
 * 
 */
public class Station extends Rail {

	/**
	 * Konstruktor mely param�terk�nt megkapja a t�blaelem ID-j�t.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public Station(int id) {
		super(id);
		rand = new Random(id);
	}
	
	/**
	 * Random sz�m gener�tor.
	 */
	private Random rand;	

	/**
	 * �llom�s sz�ne
	 */
	private Color color;
	
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