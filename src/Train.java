
import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Train {

	/**
	 * Alap�rtelmezett konstruktor.
	 */
	public Train() { }

	/**
	 * A vonatot alkot� elemek.
	 */
	@XmlAnyElement
	private ArrayList<TrainElement> elements;
	
	@XmlAttribute(name="starttick")
	private int starttick;
	
	@XmlAttribute(name="startpos")
	@XmlIDREF
	private TableElement startpos;

	/**
	 * Megvizsg�lja, hogy a vonat minden eleme l�that� e. Ha van nem l�that�
	 * elem, akkor alag�tban van (true), ha nincs akkor nincs alag�tban (false)
	 * 
	 * @return Visszat�r, hogy alag�tban van-e a b�rmely r�sze a vonatnak.
	 */
	public boolean isInTunnel() {
		for (TrainElement trainElement : elements) {
			if (!trainElement.isVisible())
				return false;
		}
		return true;
	}

	/**
	 * Vonat mozgat�s�t megval�s�t� f�ggv�ny.
	 */
	public void move() {
		for (TrainElement trainElement : elements) {
			trainElement.move();
		}
	}

	/**
	 * Megvizsg�lja, hogy a param�terk�nt kapott kocsib�l lesz�llhatnak-e az
	 * utasok.
	 * 
	 * @param color
	 *            �llom�s sz�ne
	 * @param car
	 *            Param�terk�nt kapott kocsi
	 */
	public void hopOff(Color color, Car car) {
		if (car.getColor() != color)
			return;
		for (TrainElement trainElement : elements) {
			if (!trainElement.isEmpty()) {
				if (trainElement == car)
					car.changeEmpty();
				return;
			}
		}
	}

	/**
	 * Visszat�r, hogy �res-e a vonat.
	 * 
	 * @return �res-e a vonat.
	 */
	public boolean isEmpty() {
		for (TrainElement trainElement : elements) {
			if (trainElement.isEmpty())
				return true;
		}
		return false;
	}

	/**
	 * Hozz�adja a param�terk�nt kapott elemet a vonat list�j�hoz.
	 * 
	 * @param Hozz�adand�
	 *            elem.
	 */
	public void addElement(TrainElement elem) {
		elements.add(elem);
	}
}