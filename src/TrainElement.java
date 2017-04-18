
import java.beans.Visibility;
import java.util.*;

/**
 * Vonatelemeket megvalósító abstract ösosztály
 */
public abstract class TrainElement {

	/**
	 * Alapértelmezett konstrukto.
	 */
	public TrainElement(Color color, boolean empty, Train train) {
		this.empty = empty;
		this.color = color;
		this.train = train;
		this.visible = true;
	}

	/**
	 * Kocsi színe
	 */
	private Color color;
	
	/**
	 * Üres-e a kocsi
	 */
	private boolean empty;

	/**
	 * Vonatelem típusa
	 */
	protected String type;
	
	/**
	 * Kocsit tartalamzó vonat
	 */
	final protected Train train;

	/**
	 * Visszatér, hogy üres-e az elem.
	 * 
	 * @return Üres-e az elem.
	 */
	public boolean isEmpty() {
		return empty;
	}

	/**
	 * Láthatóság
	 */
	private boolean visible;

	/**
	 * Elözö pozíción lévö elem.
	 */
	private TableElement prevTableElement;

	/**
	 * Jelenlegi pozíción lévö elem.
	 */
	private TableElement currentTableElement;
	
	public TableElement getcurrentTableElement(){
		return currentTableElement;
	}

	/**
	 * Alagútba ezen bejáraton érkezett.
	 */
	private TunnelEntrance enteredTunnel;

	/**
	 * Visszatér a kocsi színével.
	 * 
	 * @return A kocsi színe.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Megtölti vagy kiüríti az elemet.
	 */
	public void changeEmpty() {
		empty = !empty;
	}

	/**
	 * Egy TrainElement objektum láthatóságát változtatja meg ellenkezõjére.
	 */
	public void changeVisibility() {
		visible = !visible;
	}

	/**
	 * Beállítja a megadott táblaelemet aktuális elemnek.
	 * 
	 * @param te
	 *            Aktuális táblaelem.
	 */
	public void setTableElement(TableElement te) {
		this.currentTableElement = te;
	}

	/**
	 * Visszatér az elözö pazícióban lézö elemmel.
	 * 
	 * @return Az elözö táblaelem.
	 */
	public TableElement getPreviousElement() {
		return prevTableElement;
	}

	/**
	 * Visszatér, hogy alagútban van-e (látható-e) az elem.
	 * 
	 * @return Látható-e az elem.
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Az elem mozgatását végzö függvény.
	 */
	public void move() {
		TableElement next = currentTableElement.nextElement(this);
		currentTableElement.stepOff();
		prevTableElement = currentTableElement;
		next.stepOn(this);
	}

	/**
	 * Utasok leszállását megvalósító függvény.
	 * 
	 * @param color
	 *            Milyen színü utasokat akarunk leszállítani.
	 */
	public void hopOff(Color color) {
		return;
	}

	/**
	 * Utasok felszállását megvalósító függvény.
	 * 
	 * @param color
	 *            Milyen színü utasokat akarunk felszállítani.
	 */
	public void hopOn(Color color) {
		return;
	}

	/**
	 * Beállítja a paraméterként kapott TunnelEntrance-ot enteredTunnel-nek.
	 * 
	 * @param te
	 *            Hol érkezett be az alagútba.
	 */
	public void setTunnelEntrance(TunnelEntrance te) {
		this.enteredTunnel = te;
	}

	/**
	 * Visszatér az alagútba beérkezéskor beállított alagútbejárattal.
	 * 
	 * @return Ezen az alagútbejáraton érkezett az alagútba.
	 */
	public TunnelEntrance getTunnelEntrance() {
		return enteredTunnel;
	}
	
	/**
	 * Visszaadja a vonatelem típusát
	 * @return vonatelem típusa
	 */
	public String getType(){
		return type;
	}
	
}