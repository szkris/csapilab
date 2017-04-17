import java.util.*;

import javafx.animation.SequentialTransitionBuilder;

/**
 * Táblaelemeket megvalósító abstract ösosztály
 */
public abstract class TableElement implements ITableElement {

	/**
	 * Az elemet meghatározó azonosító.
	 */
	final int id;

	/**
	 * Konstruktor mely paraméterként megkapja a táblaelem ID-ját.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public TableElement(int id) {
		this.id = id;
	}

	/**
	 * Táblaelem foglaltságát jelzö érték.
	 */
	protected boolean occupied;

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
		return id;
	}
}