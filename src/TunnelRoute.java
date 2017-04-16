import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlList;

@XmlAccessorType(XmlAccessType.FIELD)
public class TunnelRoute {
	/**
	 * Alag�t eleje
	 */
	@XmlAttribute(name="start")
	@XmlIDREF
	private TunnelEntrance from;

	/**
	 * Alag�t v�ge
	 */
	@XmlAttribute(name="end")
	@XmlIDREF
	private TunnelEntrance to;

	/**
	 * Az alag�tszakaszt alkot� alag�t elemek.
	 */
	@XmlElement(name="nextelem")
	@XmlIDREF	
	private ArrayList<Tunnel> tunnels;

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
		return null;
	}
}
