
import java.util.*;

/**
 * 
 */
public class Rail extends TableElement {

	/**
	 * Konstruktor mely paraméterként megkapja a táblaelem ID-ját.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public Rail(int id) {
		super(id);
	}

	/**
	 * Az egyik irányba lévö szomszédja.
	 */
	protected TableElement elem1;

	/**
	 * A másik irányba levö szomszédja.
	 */
	protected TableElement elem2;

	@Override
	public void click() {
	}

	@Override
	public TableElement nextElement(TrainElement te) {
		TableElement prev = te.getPreviousElement();
		if (prev == elem1)
			return elem2;
		else
			return elem1;
	}

	@Override
	public void setUpConnections(ArrayList<TableElement> list) {
		// TODO Auto-generated method stub

	}

}