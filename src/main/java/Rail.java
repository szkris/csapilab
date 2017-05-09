package main.java;


import java.util.*;

/**
 * S�neket megval�s�t� oszt�ly
 */
public class Rail extends TableElement {

	/**
	 * Konstruktor mely param�terk�nt megkapja a t�blaelem ID-j�t.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public Rail(int id) {
		super(id);
		type = "rail";
	}

	/**
	 * Az egyik ir�nyba l�v� szomsz�dja.
	 */
	protected TableElement elem1;

	/**
	 * A m�sik ir�nyba lev� szomsz�dja.
	 */
	protected TableElement elem2;

	@Override
	public void click() {
	}

	@Override
	public TableElement nextElement(TrainElement te) {
		TableElement prev = te.getPreviousElement();
		if (prev == elem1)
			return elem2;
		else 
			return elem1;
	}

	@Override
	public void setUpConnections(ArrayList<TableElement> list) {
		this.elem1 = list.get(0);
		this.elem2 = list.get(1);
	}
	
	@Override
	public ArrayList<Integer> getNeighbours(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(elem1!=null)
			list.add(elem1.getId());
		else 
			list.add(0);
		if(elem2!=null)
			list.add(elem2.getId());
		else
			list.add(0);
		return list;
	}

}