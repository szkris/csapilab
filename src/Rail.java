
import java.util.*;

/**
 * 
 */
public class Rail extends TableElement {

	/**
	 * Konstruktor mely param�terk�nt megkapja a t�blaelem ID-j�t.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public Rail(int id) {
		super(id);
	}

	/**
	 * Az egyik ir�nyba l�v� szomsz�dja.
	 */
	protected TableElement elem1;

	/**
	 * A m�sik ir�nyba lev� szomsz�dja.
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