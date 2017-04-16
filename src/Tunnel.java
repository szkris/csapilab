import java.util.*;

/**
 * Egy alagutat megval�s�t� oszt�ly.
 */
public class Tunnel extends TableElement {

	/**
	 * Itt t�roljuk, hogy az alag�ttal mely elemek szomsz�dosak
	 */
	private ArrayList<TableElement> neighbours;
	private Table table;

	/**
	 * Default konstruktor.
	 */
	public Tunnel(int id, Table table) {
		super(id);
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
		this.neighbours = list;
	}
}