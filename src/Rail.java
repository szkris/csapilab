
import java.util.*;

/**
 * Síneket megvalósító osztály
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
		type = "rail";
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
		this.elem1 = list.get(0);
		this.elem2 = list.get(1);
	}

}