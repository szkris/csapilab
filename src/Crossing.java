
import java.util.*;

/**
 * 
 */
public class Crossing extends Rail {

	/**
	 * Default constructor
	 */
	public Crossing(int id) {
		super(id);
	}

	/**
	 * Harmadig szomszédos elem
	 */
	private TableElement elem3;

	/**
	 * Negyedik szomszédos elem
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
		// TODO Auto-generated method stub
	}

}