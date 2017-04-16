
import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
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
    @XmlAttribute(name="refid1")
    @XmlIDREF
	private TableElement elem1;

	/**
	 * 
	 */
    @XmlAttribute(name="refid2")
    @XmlIDREF
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