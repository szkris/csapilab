import java.util.*;

/**
 * Egy alagutat megval�s�t� oszt�ly.
 */
public class Tunnel extends TableElement {
	
    /**
     * Itt t�roljuk, hogy az alag�t melyik bej�ratokhoz vezethet.
     */
    private ArrayList<TunnelEntrance> entrances;
    private ArrayList<Tunnel> tunnels;
    
    /**
     * Default konstruktor.
     */
    public Tunnel(int id) {
    	super(id);
    }

    /**
     * @param entrance Az adott kij�rat, amir�l meg akarjuk hat�rozni, hogy oda vezet-e az alag�t.
     * @return  Megadja hogy az adott alag�tr�sz vezet-e a kapott kij�rathoz.
     */
    public boolean leadsTo(TunnelEntrance entrance) {
    	return entrances.contains(entrance);
    }
    
    @Override
	public void stepOff() {
		setOccupied(false);
	}	
	
	@Override
	public TableElement nextElement(TrainElement te) {
		TunnelEntrance[] open = new TunnelEntrance[2];
		int i = 0;
		for (TunnelEntrance tunnelEntrance : entrances) {
			if(tunnelEntrance.isOpen()){
				open[i] = tunnelEntrance;
				i++;
			}
		}
		TableElement fromEntrance = te.getTunnelEntrance();
		TableElement prev = te.getPreviousElement();
		if(fromEntrance == open[0]){
			for (Tunnel tunnel : tunnels) {
				if(tunnel.leadsTo(open[1]) && tunnel!=prev);
					return tunnel;
			}
		} else {
			for (Tunnel tunnel : tunnels) {
				if(tunnel.leadsTo(open[0]) && tunnel!=prev);
					return tunnel;
			}
		}
		
		if(open[0]==fromEntrance) return open[1];
		else return open[0];
	}
	
	@Override
	public void stepOn(TrainElement te) {
		if(occupied) {
			Game.gameOver();
		} else {
			setOccupied(true);
			te.setTableElement(this);
		}
	}
	
	@Override
	public void click() { }
	
	@Override
	public void setUpConnections(ArrayList<TableElement> list) { }
	
	/**
	 * Be�ll�tja, hogy mely kij�ratokhoz vezet a Tunnel.
	 * @param entrances Ezekhez a kij�ratokhoz vezet.
	 */
	public void setEntrances(ArrayList<TunnelEntrance> entrances){
		this.entrances = entrances;
	}
	
	/**
	 * Be�ll�tja milyen szomsz�dos Tunnel-ek vannak.
	 * @param tunnels Szomsz�dos Tunnel-ek.
	 */
	public void setTunnels(ArrayList<Tunnel> tunnels){
		this.tunnels = tunnels;
	}
}