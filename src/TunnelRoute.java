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
	 * Alagút eleje
	 */
	@XmlAttribute(name="start")
	@XmlIDREF
	private TunnelEntrance from;

	/**
	 * Alagút vége
	 */
	@XmlAttribute(name="end")
	@XmlIDREF
	private TunnelEntrance to;

	/**
	 * Az alagútszakaszt alkotó alagút elemek.
	 */
	@XmlElement(name="nextelem")
	@XmlIDREF	
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
