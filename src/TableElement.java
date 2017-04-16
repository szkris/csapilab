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
	 * Az elemet meghatározó azonosító.
	 */
	@XmlAttribute(name="id")	
	@XmlID
	String id;
	
	public void setId(String id){
		this.id = id;
	}
	/**
	 * Konstruktor mely paraméterként megkapja a táblaelem ID-ját.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public TableElement(int id) {
		this.id = Integer.toString(id);
	}

	/**
	 * Táblaelem foglaltságát jelzö érték.
	 */
	protected boolean occupied;

	/**
	 * A táblán lévö vonatelem. 
	 */
	private TrainElement trainElement;

	/**
	 * Beállítja a táblaelem foglaltságát a megadott értékre.
	 * @param boolean Táblaelem kívánt foglaltsága.
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
	 * Visszatér a táblaelem ID-jével.
	 * 
	 * @return Táblaelem ID-ja.
	 */
	public int getId() {
		return Integer.parseInt(id);
	}
}