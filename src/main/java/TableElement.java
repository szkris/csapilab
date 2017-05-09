package main.java;

import java.util.*;

/**
 * Táblaelemeket megvalósító abstract ösosztály
 */
public abstract class TableElement implements ITableElement {

	/**
	 * Az elemet meghatározó azonosító.
	 */
	final int id;
	protected String type;

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
	
	public ArrayList<Integer> getNeighbours(){return null;}
	
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
	
	/**
	 * Visszatér az elem típusával
	 * @return
	 */
	public String getType(){
		return type;
	}
}