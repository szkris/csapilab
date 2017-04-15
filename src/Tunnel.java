import java.util.*;

/**
 * Egy alagutat megval�s�t� oszt�ly.
 */
public class Tunnel extends Rail {
	
    /**
     *  Itt t�roljuk, hogy az alag�t melyik bej�ratokhoz vezethet.
     */
    private List<TunnelEntrance> entrances;

    /**
     * Default konstruktor.
     */
    public Tunnel() {
    	entrances = new ArrayList<TunnelEntrance>();
    }

    /**
     * @param entrance Az adott kij�rat, amir�l meg akarjuk hat�rozni, hogy oda vezet-e az alag�t.
     * @return  Megadja hogy az adott alag�tr�sz vezet-e a kapott kij�rathoz.
     */
    public boolean leadsTo(TunnelEntrance entrance) {
    	return entrances.contains(entrance);
    }
}