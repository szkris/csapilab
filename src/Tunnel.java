import java.util.*;

/**
 * Egy alagutat megvalósító osztály.
 */
public class Tunnel extends Rail {
	
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
}