import java.util.*;

/**
 * Egy alagutat megvalósító osztály.
 */
public class Tunnel extends TableElement {
	
    /**
     *  Itt tároljuk, hogy az alagút melyik bejáratokhoz vezethet.
     */
    private List<TunnelEntrance> entrances;

    /**
     * Default konstruktor.
     */
    public Tunnel() {
    	entrances = new ArrayList<TunnelEntrance>();
    }

    /**
     * @param entrance Az adott kijárat, amirõl meg akarjuk határozni, hogy oda vezet-e az alagút.
     * @return  Megadja hogy az adott alagútrész vezet-e a kapott kijárathoz.
     */
    public boolean leadsTo(TunnelEntrance entrance) {
    	return entrances.contains(entrance);
    }

	@Override
	public void stepOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextElement(TrainElement te) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stepOn(TrainElement te) {
		// TODO Auto-generated method stub
		
	}
}