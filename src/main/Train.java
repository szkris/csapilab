package main;


import java.util.*;

/**
 * Vonatot megval�s�t� oszt�ly
 */
public class Train {

	/**
	 * Konstruktor, mely be�ll�tja a kezd�poz�ci�t, kezd� �temet valamint az
	 * azonos�t�t.
	 * 
	 * @param starttick
	 *            Kezd� �tem
	 * @param startpos
	 *            Kezd� poz�ci�
	 * @param id
	 *            Vonat azonos�t�ja
	 */
	public Train(int starttick, TableElement startpos, int id) {
		this.startpos = startpos;
		this.starttick = starttick;
		this.id = id;
	}

	/**
	 * A vonat azonos�t�ja.
	 */
	private int id;
	
	public int getId(){
		return id;
	}

	/**
	 * A vonat kezd�s�nek �teme.
	 */
	private int starttick;
	/**
	 * Mennyit ment a vonat eddig.
	 */
	private int moved = 0;

	/**
	 * Getter a starttick attrib�tumhoz.
	 * 
	 * @return A vonat indul�s�nak id�pillanata
	 */
	public int getStartTick() {
		return starttick;
	}

	/**
	 * A vonat kezd� poz�ci�ja
	 */
	private TableElement startpos;

	/**
	 * A vonatot alkot� elemek.
	 */
	private ArrayList<TrainElement> elements = new ArrayList<TrainElement>();
	
	public ArrayList<TrainElement> getElements(){
		return elements;
	}

	/**
	 * Megvizsg�lja, hogy a vonat minden eleme l�that� e. Ha van nem l�that�
	 * elem, akkor alag�tban van (true), ha nincs akkor nincs alag�tban (false)
	 * 
	 * @return Visszat�r, hogy alag�tban van-e a b�rmely r�sze a vonatnak.
	 */
	public boolean isInTunnel() {
		for (TrainElement trainElement : elements) {
			if (!trainElement.isVisible())
				return true;
		}
		return false;
	}

	/**
	 * Vonat mozgat�s�t megval�s�t� f�ggv�ny.
	 * 
	 * @param tick
	 *            Az aktu�lis id�pillanat
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
				if (trainElement == car){
					car.changeEmpty();
					Game.mapCompleted();
				}
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
			if (!trainElement.isEmpty())
				return false;
		}
		return true;
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
	
	/**
	 * Visszaadja a vonat ID-j�t
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