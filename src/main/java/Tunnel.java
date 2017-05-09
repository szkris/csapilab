package main.java;

import java.util.*;

/**
 * Egy alagutat megval�s�t� oszt�ly.
 */
public class Tunnel extends TableElement {

	private Table table;

	/**
	 * Default konstruktor.
	 */
	public Tunnel(int id, Table table) {
		super(id);
		type = "tunnel";
		this.table = table;
	}

	@Override
	public TableElement nextElement(TrainElement te) {
		return table.getNextTunnel(te.getTunnelEntrance(), this);
	}

	@Override
	public void stepOn(TrainElement te) {
		if (occupied) {
			Game.gameOver();
		} else {
			setOccupied(true);
			te.setTableElement(this);
		}
	}

	@Override
	public void click() {
	}

	@Override
	public void setUpConnections(ArrayList<TableElement> list) {
	}
}