
import java.util.*;

/**
 * 
 */
public class Field extends TableElement {

	/**
	 * Konstruktor mely paraméterként megkapja a táblaelem ID-ját.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public Field(int id) {
		super(id);
	}

	@Override
	public void click() {	}

	@Override
	public TableElement nextElement(TrainElement te) {
		return null;
	}

	@Override
	public void stepOn(TrainElement te) {
		Game.gameOver();
	}

	@Override
	public void setUpConnections(ArrayList<TableElement> list) {
		// TODO Auto-generated method stub

	}

}