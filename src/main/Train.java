package main;


import java.util.*;

/**
 * Vonatot megvalósító osztály
 */
public class Train {

	/**
	 * Konstruktor, mely beállítja a kezdöpozíciót, kezdö ütemet valamint az
	 * azonosítót.
	 * 
	 * @param starttick
	 *            Kezdö ütem
	 * @param startpos
	 *            Kezdö pozíció
	 * @param id
	 *            Vonat azonosítója
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
	
	public int getId(){
		return id;
	}

	/**
	 * A vonat kezdésének üteme.
	 */
	private int starttick;
	/**
	 * Mennyit ment a vonat eddig.
	 */
	private int moved = 0;

	/**
	 * Getter a starttick attribútumhoz.
	 * 
	 * @return A vonat indulásának idöpillanata
	 */
	public int getStartTick() {
		return starttick;
	}

	/**
	 * A vonat kezdö pozíciója
	 */
	private TableElement startpos;

	/**
	 * A vonatot alkotó elemek.
	 */
	private ArrayList<TrainElement> elements = new ArrayList<TrainElement>();
	
	public ArrayList<TrainElement> getElements(){
		return elements;
	}

	/**
	 * Megvizsgálja, hogy a vonat minden eleme látható e. Ha van nem látható
	 * elem, akkor alagútban van (true), ha nincs akkor nincs alagútban (false)
	 * 
	 * @return Visszatér, hogy alagútban van-e a bármely része a vonatnak.
	 */
	public boolean isInTunnel() {
		for (TrainElement trainElement : elements) {
			if (!trainElement.isVisible())
				return true;
		}
		return false;
	}

	/**
	 * Vonat mozgatását megvalósító függvény.
	 * 
	 * @param tick
	 *            Az aktuális idöpillanat
	 */
	public void move(int tick) {
		if (tick >= starttick) {
			if (moved < elements.size()) {
				for (int i = 0; i < moved; i++)
					elements.get(i).move();
				elements.get(moved).setTableElement(startpos);
				moved++;
			} else {
				for (TrainElement trainElement : elements) {
					trainElement.move();
				}
				moved++;
			}
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
				if (trainElement == car){
					car.changeEmpty();
					Game.mapCompleted();
				}
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
			if (!trainElement.isEmpty())
				return false;
		}
		return true;
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
	
	/**
	 * Visszaadja a vonat ID-ját
	 * 
	 * @return vonat ID-ja
	 */
	public int getID(){
		return id;
	}
	
	// TODO comments
	/**
	 * 
	 * @return
	 */
	public ArrayList<TrainElement> getTrainElements(){
		return elements;
	}
}