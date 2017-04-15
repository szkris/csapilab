import java.util.ArrayList;

public class TunnelRoute {
	/**
	 * Alagút eleje
	 */
	private TunnelEntrance from;

	/**
	 * Alagút vége
	 */
	private TunnelEntrance to;

	/**
	 * Az alagútszakaszt alkotó alagút elemek.
	 */
	private ArrayList<Tunnel> tunnels;

	/**
	 * Megegyezik-e a paraméterekkel megadott alagútszakasszal.
	 * 
	 * @param start
	 *            Alagútszakasz kezdete.
	 * @param end
	 *            Alagútszakasz vége.
	 * @return Megegyezik-e az alagúttal.
	 */
	public boolean route(TunnelEntrance start, TunnelEntrance end) {
		return (start == from && end == to);
	}

	/**
	 * Visszaadja a következö elemet az alagútszakaszon.
	 * 
	 * @param Jelenlegi
	 *            pozíció
	 * @return Következö pozíció
	 */
	public TableElement getNext(Tunnel at) {
		for (int i = 0; i < tunnels.size(); i++) {
			if (tunnels.get(i) == at) {
				if (i == tunnels.size() - 1)
					return to;
				else
					return tunnels.get(i + 1);
			}
		}
		return null;
	}
}
