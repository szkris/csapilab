
import java.util.*;

/**
 * 
 */
public class Field extends TableElement {

	/**
	 * Konstruktor mely param�terk�nt megkapja a t�blaelem ID-j�t.
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