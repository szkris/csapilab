
import java.util.*;

/**
 * V�lt�t megval�s�t� oszt�ly
 */
public class Switch extends TableElement {

	/**
	 * Konstruktor mely param�terk�nt megkapja a t�blaelem ID-j�t.
	 * 
	 * @param id
	 *            Az elem ID-ja.
	 */
	public Switch(int id) {
		super(id);
		type = "switch";
	}

	/**
	 * Ez a t�blaelem minden pillanatban akt�v be/kimenetel.
	 */
	private TableElement fix;

	/**
	 * Ez a m�sik jelenleg akt�v be/kimenetel.
	 */
	private TableElement active;

	/**
	 * A jelenleg inakt�v be/kimenetel.
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