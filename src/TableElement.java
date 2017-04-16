import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class TableElement implements ITableElement {

	/**
	 * Az elemet meghat�roz� azonos�t�.
	 */
	@XmlAttribute(name="id")	
	@XmlID
	String id;
	
	public void setId(String id){
		this.id = id;
	}
	/**
	 * Konstruktor mely param�terk�nt megkapja a t�blaelem ID-j�t.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public TableElement(int id) {
		this.id = Integer.toString(id);
	}

	/**
	 * T�blaelem foglalts�g�t jelz� �rt�k.
	 */
	protected boolean occupied;

	/**
	 * A t�bl�n l�v� vonatelem. 
	 */
	private TrainElement trainElement;

	/**
	 * Be�ll�tja a t�blaelem foglalts�g�t a megadott �rt�kre.
	 * @param boolean T�blaelem k�v�nt foglalts�ga.
	 */
	public void setOccupied(boolean te) {
		occupied = te;
	}
	
	@Override
	public void stepOff() {
		setOccupied(false);
	}
	
	@Override
	public void stepOn(TrainElement te){
		if(occupied) Game.gameOver();
		setOccupied(true);
		te.setTableElement(this);
	}

	/**
	 * Visszat�r a t�blaelem ID-j�vel.
	 * 
	 * @return T�blaelem ID-ja.
	 */
	public int getId() {
		return Integer.parseInt(id);
	}
}