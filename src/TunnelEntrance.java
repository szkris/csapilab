import java.util.ArrayList;

/**
 * Egy alagútbejáratot megvalósító függvény.
 */
public class TunnelEntrance extends Rail {

	/**
	 * Itt tárolódik, hogy a bejárat aktív-e.
	 */
	private boolean open;

	/**
	 * Tárolja az alagútbejárathoz tartozó Table-t, hogy kommunikálhasson az
	 * asztallal.
	 */
	private Table table;

	/**
	 * Konstrukor, amiben egy Table-t lehet átadni.
	 */
	public TunnelEntrance(int id, Table table) {
		super(id);
		type = "tunnelEntrance";
		this.table = table;
	}

	/**
	 * @return Visszaadja, hogy nyitva van-e az alagútbejárat.
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * Egy alagútbejárat állását az ellenkezõjére változtatja.
	 */
	public void changeStatus() {
		open = !open;
	}

	@Override
	public void click() {
		if(open){
			table.closeTunnel(this);
		}
		else{
			table.openTunnel(this);
		}
	}

	@Override
	public void stepOn(TrainElement te) {
		if (occupied || !open)
			Game.gameOver();
		setOccupied(true);
		te.changeVisibility();
		te.setTunnelEntrance(this);
		te.setTableElement(this);
	}
}