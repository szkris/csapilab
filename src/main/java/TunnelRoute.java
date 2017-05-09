package main.java;

import java.util.ArrayList;

/**
 * Alagut szakaszokat megval�s�t� oszt�ly
 */
public class TunnelRoute {
	/**
	 * Alag�t eleje
	 */
	private TunnelEntrance from;

	/**
	 * Alag�t v�ge
	 */
	private TunnelEntrance to;

	/**
	 * Az alag�tszakaszt alkot� alag�t elemek.
	 */
	private ArrayList<Tunnel> tunnels;
	
	public TunnelRoute(TunnelEntrance from, TunnelEntrance to, ArrayList<Tunnel> tunnels){
		this.from = from;
		this.to= to;
		this.tunnels = tunnels;
	}
	
	/**
	 * Megegyezik-e a param�terekkel megadott alag�tszakasszal.
	 * 
	 * @param start
	 *            Alag�tszakasz kezdete.
	 * @param end
	 *            Alag�tszakasz v�ge.
	 * @return Megegyezik-e az alag�ttal.
	 */
	public boolean route(TunnelEntrance start, TunnelEntrance end) {
		return (start == from && end == to);
	}

	/**
	 * Visszaadja a k�vetkez� elemet az alag�tszakaszon.
	 * 
	 * @param Jelenlegi
	 *            poz�ci�
	 * @return K�vetkez� poz�ci�
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
		Game.gameOver();
		return null;
	}
}
