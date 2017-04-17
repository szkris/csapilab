
import java.util.*;

/**
 * Váltót megvalósító osztály
 */
public class Switch extends TableElement {

	/**
	 * Konstruktor mely paraméterként megkapja a táblaelem ID-ját.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public Switch(int id) {
		super(id);
		type = "switch";
	}

	/**
	 * Ez a táblaelem minden pillanatban aktív be/kimenetel.
	 */
	private TableElement fix;

	/**
	 * Ez a másik jelenleg aktív be/kimenetel.
	 */
	private TableElement active;

	/**
	 * A jelenleg inaktív be/kimenetel.
	 */
	private TableElement inactive;

	@Override
	public void click() {
		if(occupied) return;
		TableElement temp = active;
		active = inactive;
		inactive = temp;
	}

	@Override
	public TableElement nextElement(TrainElement te) {
		TableElement prev = te.getPreviousElement();
		if(prev == fix)
			return active;
		if(prev == active)
			return fix;
		else
			Game.gameOver();
		return null;
	}

	@Override
	public void setUpConnections(ArrayList<TableElement> list) {
		fix = list.get(0);
		active = list.get(1);
		inactive = list.get(2);
	}
}