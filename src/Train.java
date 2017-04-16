
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
	 * Alapértelmezett konstruktor.
	 */
	public Train() { }

	/**
	 * A vonatot alkotó elemek.
	 */
	@XmlAnyElement
	private ArrayList<TrainElement> elements;
	
	@XmlAttribute(name="starttick")
	private int starttick;
	
	@XmlAttribute(name="startpos")
	@XmlIDREF
	private TableElement startpos;

	/**
	 * Megvizsgálja, hogy a vonat minden eleme látható e. Ha van nem látható
	 * elem, akkor alagútban van (true), ha nincs akkor nincs alagútban (false)
	 * 
	 * @return Visszatér, hogy alagútban van-e a bármely része a vonatnak.
	 */
	public boolean isInTunnel() {
		for (TrainElement trainElement : elements) {
			if (!trainElement.isVisible())
				return false;
		}
		return true;
	}

	/**
	 * Vonat mozgatását megvalósító függvény.
	 */
	public void move() {
		for (TrainElement trainElement : elements) {
			trainElement.move();
		}
	}

	/**
	 * Megvizsgálja, hogy a paraméterként kapott kocsiból leszállhatnak-e az
	 * utasok.
	 * 
	 * @param color
	 *            Állomás színe
	 * @param car
	 *            Paraméterként kapott kocsi
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
	 * Visszatér, hogy üres-e a vonat.
	 * 
	 * @return Üres-e a vonat.
	 */
	public boolean isEmpty() {
		for (TrainElement trainElement : elements) {
			if (trainElement.isEmpty())
				return true;
		}
		return false;
	}

	/**
	 * Hozzáadja a paraméterként kapott elemet a vonat listájához.
	 * 
	 * @param Hozzáadandó
	 *            elem.
	 */
	public void addElement(TrainElement elem) {
		elements.add(elem);
	}
}