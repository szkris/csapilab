package main;


import java.util.*;

/**
 * Táblaelemek által használt függvényeket megvalósító interface
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