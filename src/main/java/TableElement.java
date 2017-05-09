package main.java;

import java.util.*;

/**
 * T�blaelemeket megval�s�t� abstract �soszt�ly
 */
public abstract class TableElement implements ITableElement {

	/**
	 * Az elemet meghat�roz� azonos�t�.
	 */
	final int id;
	protected String type;

	/**
	 * Konstruktor mely param�terk�nt megkapja a t�blaelem ID-j�t.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public TableElement(int id) {
		this.id = id;
	}

	/**
	 * T�blaelem foglalts�g�t jelz� �rt�k.
	 */
	protected boolean occupied;

	/**
	 * Be�ll�tja a t�blaelem foglalts�g�t a megadott �rt�kre.
	 * @param boolean T�blaelem k�v�nt foglalts�ga.
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
	 * Visszat�r a t�blaelem ID-j�vel.
	 * 
	 * @return T�blaelem ID-ja.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Visszat�r az elem t�pus�val
	 * @return
	 */
	public String getType(){
		return type;
	}
}