
import java.util.*;

/**
 * 
 */
public class CoalWagon extends TrainElement {

	/**
	 * Létrehoz egy CoalWagon elemet a megadott paraméterekkel.
	 * 
	 * @param color
	 *            Szín.
	 * @param empty
	 *            Üres-e.
	 * @param train
	 *            Elemet tartalamzó vonat.
	 */
	public CoalWagon(Color color, boolean empty, Train train) {
		super(color, empty, train);
	}

	/**
	 * Szeneskocsit tartalmazó vonat.
	 */
	private Train train;

}