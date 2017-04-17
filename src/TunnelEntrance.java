import java.util.ArrayList;

/**
 * Egy alag�tbej�ratot megval�s�t� f�ggv�ny.
 */
public class TunnelEntrance extends Rail {

	/**
	 * Itt t�rol�dik, hogy a bej�rat akt�v-e.
	 */
	private boolean open;

	/**
	 * T�rolja az alag�tbej�rathoz tartoz� Table-t, hogy kommunik�lhasson az
	 * asztallal.
	 */
	private Table table;

	/**
	 * Konstrukor, amiben egy Table-t lehet �tadni.
	 */
	public TunnelEntrance(int id, Table table) {
		super(id);
		type = "tunnelEntrance";
		this.table = table;
	}

	/**
	 * @return Visszaadja, hogy nyitva van-e az alag�tbej�rat.
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * Egy alag�tbej�rat �ll�s�t az ellenkez�j�re v�ltoztatja.
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