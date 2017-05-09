package main.java;

import java.util.*;

/**
 * Táblaelemek által használt függvényeket megvalósító interface
 */
public interface ITableElement {

	/**
	 * Az elemröl való lelépést megvalósító függvény
	 */
	public void stepOff();

	/**
	 * Az elemre való kattintást megvalósító osztály
	 */
	public void click();

	/**
	 * Visszaadja a következö táblaelemet
	 * @param TrainElement A léptetni kívánt vonatelem
	 * @return A következö táblaelem
	 */
	public TableElement nextElement(TrainElement te);

	/**
	 * A táblaelemre lépést megvalósító osztály
	 * @param TrainElement A léptetni kívánt vonatelem
	 */
	public void stepOn(TrainElement te);

	/**
	 * Szomszédok beállítása
	 * @param Szomszédok listája
	 */
	public void setUpConnections(ArrayList<TableElement> list);

}