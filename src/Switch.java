
import java.util.*;

/**
 * 
 */
public class Switch extends TableElement {

    /**
     * Default constructor
     */
    public Switch(int id) {
    	super(id);
    }

    /**
     * 
     */
    private TableElement fix;

    /**
     * 
     */
    private TableElement active;

    /**
     * 
     */
    private TableElement inactive;

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
		// TODO Auto-generated method stub
		return active;
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