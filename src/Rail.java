
import java.util.*;

/**
 * S�neket megval�s�t� oszt�ly
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
		type = "rail";
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
		this.elem1 = list.get(0);
		this.elem2 = list.get(1);
	}

}