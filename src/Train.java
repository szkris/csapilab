
import java.util.*;

/**
 * 
 */
public class Train {

	/**
	 * Konstruktor, mely beállítja a kezdöpozíciót, kezdö ütemet valamint az azonosítót.
	 * 
	 * @param starttick
	 *            Kezdö ütem
	 * @param startpos
	 *            Kezdö pozíció
	 * @param id 
	 * 			  Vonat azonosítója
	 */
	public Train(int starttick, TableElement startpos, int id) {
		this.startpos = startpos;
		this.starttick = starttick;
		this.id = id;
	}


	/**
	 * A vonat azonosítója.
	 */
	private int id;
	
	/**
	 * A vonat kezdésének üteme.
	 */
	private int starttick;

	/**
	 * A vonat kezdö pozíciója
	 */
	private TableElement startpos;

	/**
	 * A vonatot alkotó elemek.
	 */
	private ArrayList<TrainElement> elements = new ArrayList<TrainElement>();

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