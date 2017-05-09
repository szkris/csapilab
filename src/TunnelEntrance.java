import java.util.ArrayList;

/**
 * Egy alag�tbej�ratot megval�s�t� f�ggv�ny.
 */
public class TunnelEntrance extends Rail {
	
	/**
	 * Itt t�rol�dik, hogy a bej�rat akt�v-e.
	 */
	private boolean open;
	
	Rail rail = null;

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
		type = "tunnelentrance";
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
		if (occupied || !open || !table.twoEntrancesOpen())
			Game.gameOver();
		setOccupied(true);
		te.changeVisibility();
		te.setTunnelEntrance(this);
		te.setTableElement(this);
	}
	@Override
	public ArrayList<Integer> getNeighbours(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(elem1.getType()!="tunnel")
			list.add(elem1.getId());
		if(elem2.getType()!="tunnel")
			list.add(elem2.getId());
		return list;
	}
}