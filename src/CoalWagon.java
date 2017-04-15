
import java.util.*;

/**
 * 
 */
public class CoalWagon extends TrainElement {

	/**
	 * L�trehoz egy CoalWagon elemet a megadott param�terekkel.
	 * 
	 * @param color
	 *            Sz�n.
	 * @param empty
	 *            �res-e.
	 * @param train
	 *            Elemet tartalamz� vonat.
	 */
	public CoalWagon(Color color, boolean empty, Train train) {
		super(color, empty, train);
	}

	/**
	 * Szeneskocsit tartalmaz� vonat.
	 */
	private Train train;

}