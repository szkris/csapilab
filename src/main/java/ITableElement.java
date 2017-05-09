package main.java;

import java.util.*;

/**
 * T�blaelemek �ltal haszn�lt f�ggv�nyeket megval�s�t� interface
 */
public interface ITableElement {

	/**
	 * Az elemr�l val� lel�p�st megval�s�t� f�ggv�ny
	 */
	public void stepOff();

	/**
	 * Az elemre val� kattint�st megval�s�t� oszt�ly
	 */
	public void click();

	/**
	 * Visszaadja a k�vetkez� t�blaelemet
	 * @param TrainElement A l�ptetni k�v�nt vonatelem
	 * @return A k�vetkez� t�blaelem
	 */
	public TableElement nextElement(TrainElement te);

	/**
	 * A t�blaelemre l�p�st megval�s�t� oszt�ly
	 * @param TrainElement A l�ptetni k�v�nt vonatelem
	 */
	public void stepOn(TrainElement te);

	/**
	 * Szomsz�dok be�ll�t�sa
	 * @param Szomsz�dok list�ja
	 */
	public void setUpConnections(ArrayList<TableElement> list);

}