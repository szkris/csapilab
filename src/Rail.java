
import java.util.*;

/**
 * 
 */
public class Rail extends TableElement {

    /**
     * Default constructor
     */
    public Rail(int id) {
    	super(id);
    }

    /**
     * 
     */
    private TableElement elem1;

    /**
     * 
     */
    private TableElement elem2;

	@Override
	public void stepOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TableElement nextElement(TrainElement te) {
		return elem1;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stepOn(TrainElement te) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpConnections(ArrayList<TableElement> list) {
		// TODO Auto-generated method stub
		
	}


}