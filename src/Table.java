
import java.util.*;

/**
 * 
 */
public class Table {

	/**
	 * Default constructor
	 */
	public Table() {
		openTunnelEntrances[0] = null;
		openTunnelEntrances[1] = null;
	}

	/**
	 * 
	 */
	private int numberOfLevels;

	/**
	 * 
	 */
	private int currentLevel;

	/**
	 * 
	 */
	private ArrayList<TunnelRoute> tunnelRoutes;

	/**
	 * 
	 */
	private ArrayList<TunnelRoute> tableElements;
	/**
	 * 
	 */
	private ArrayList<Train> train;

	/**
	 * 
	 */
	private TunnelEntrance[] openTunnelEntrances = new TunnelEntrance[2];

	/**
	 * @return
	 */
	public void loadMap() {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public TableElement getEntryPoint() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public Train getNextTrain() {
		// TODO implement here
		return null;
	}

	/**
	 * @param tick
	 * @return
	 */
	public boolean trainReady(int tick) {
		// TODO implement here
		return false;
	}

	/**
	 * Kinyitja az alagútbejáratot, ha nincs már kettö aktiválva, valamit
	 * bezárja ha épp aktív.
	 * 
	 * @param TunnelEntrance
	 *            A bezárni/kinyitni kívánt alagútbejárat.
	 */
	public void openTunnel(TunnelEntrance te) {
		if (openTunnelEntrances[0] == te) {
			te.changeStatus();
			openTunnelEntrances[0] = null;
			return;
		} else if (openTunnelEntrances[1] == te) {
			te.changeStatus();
			openTunnelEntrances[1] = null;
		} else if (openTunnelEntrances[0] != null && openTunnelEntrances[1] != null) {
			return;
		} else {
			for (Train tr : train) {
				if (tr.isInTunnel())
					return;
			}
			if (openTunnelEntrances[0] != null) {
				openTunnelEntrances[0] = te;
				te.changeStatus();
				return;
			} else {
				openTunnelEntrances[1] = te;
				te.changeStatus();
				return;
			}
		}
	}

	/**
	 * Megadja, hogy az átadott paraméterenek megfelelö alagút járaton mi a
	 * következö lépés.
	 * 
	 * @param start
	 *            Melyik alagutbólbejárattól érkezett a vonat.
	 * @param at
	 *            Melyik Tunnel elemen van éppen.
	 * @return Következö Tunnel elem az alagútjáraton.
	 */
	public TableElement getNextTunnel(TunnelEntrance start, Tunnel at) {
		TunnelEntrance end;
		if (start == openTunnelEntrances[0])
			end = openTunnelEntrances[1];
		else
			end = openTunnelEntrances[0];
		TunnelRoute tr = null;
		for (TunnelRoute tunnelRoute : tunnelRoutes) {
			if (tunnelRoute.route(start, end)) {
				tr = tunnelRoute;
				return tr.getNext(at);
			}
		}
		return null;
	}

}