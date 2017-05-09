package main;


import java.util.*;

/**
 * T�blaelemek �ltal haszn�lt f�ggv�nyeket megval�s�t� interface
 */
public interface ITableElement {

	/**
	 * @return
	 */
	public void stepOff();

	/**
	 * @return
	 */
	public void click();

	/**
	 * @param TrainElement
	 * @return
	 */
	public TableElement nextElement(TrainElement te);

	/**
	 * @param TrainElement
	 * @return
	 */
	public void stepOn(TrainElement te);

	public void setUpConnections(ArrayList<TableElement> list);

}