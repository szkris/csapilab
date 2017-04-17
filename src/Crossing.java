
import java.util.*;

/**
 * Keresztez�d�st megval�s�t� oszt�ly
 */
public class Crossing extends Rail {

	/**
	 * Default constructor
	 */
	public Crossing(int id) {
		super(id);
	}

	/**
	 * Harmadig szomsz�dos elem
	 */
	private TableElement elem3;

	/**
	 * Negyedik szomsz�dos elem
	 */
	private TableElement elem4;
	
	@Override
	public TableElement nextElement(TrainElement te) {
		TableElement prev = te.getPreviousElement();
		if (prev == elem1)
			return elem2;
		else if(prev == elem2)
			return elem1;
		else if(prev==elem3)
			return elem4;
		else return elem3;
	}

	@Override
	public void setUpConnections(ArrayList<TableElement> list) {
		this.elem1 = list.get(0);
		this.elem3 = list.get(1);
		this.elem2 = list.get(2);
		this.elem4 = list.get(3);
	}

}