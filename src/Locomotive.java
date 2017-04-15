
import java.util.*;

/**
 * A mozdonyt megvalósító osztály.
 */
public class Locomotive extends TrainElement {

	/**
	 * Létrehoz egy Locomotive elemet a megadott paraméterekkel.
	 * 
	 * @param color
	 *            Szín.
	 * @param empty
	 *            Üres-e.
	 * @param train
	 *            Elemet tartalamzó vonat.
	 */
	public Locomotive(Color color, boolean empty, Train train) {
		super(color, empty, train);
	}

	/**
	 * A loco-t tartalamzó vonat.
	 */
	private Train train;
}