
import java.util.*;

/**
 * A mozdonyt megval�s�t� oszt�ly.
 */
public class Locomotive extends TrainElement {

	/**
	 * L�trehoz egy Locomotive elemet a megadott param�terekkel.
	 * 
	 * @param color
	 *            Sz�n.
	 * @param empty
	 *            �res-e.
	 * @param train
	 *            Elemet tartalamz� vonat.
	 */
	public Locomotive(Color color, boolean empty, Train train) {
		super(color, empty, train);
	}

	/**
	 * A loco-t tartalamz� vonat.
	 */
	private Train train;
}