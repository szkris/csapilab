
import java.beans.Visibility;
import java.util.*;

/**
 * Vonatelemeket megval�s�t� abstract �soszt�ly
 */
public abstract class TrainElement {

	/**
	 * Alap�rtelmezett konstrukto.
	 */
	public TrainElement(Color color, boolean empty, Train train) {
		this.empty = empty;
		this.color = color;
		this.train = train;
		this.visible = true;
	}

	/**
	 * Kocsi sz�ne
	 */
	private Color color;
	
	/**
	 * �res-e a kocsi
	 */
	private boolean empty;

	/**
	 * Vonatelem t�pusa
	 */
	protected String type;
	
	/**
	 * Kocsit tartalamz� vonat
	 */
	final protected Train train;

	/**
	 * Visszat�r, hogy �res-e az elem.
	 * 
	 * @return �res-e az elem.
	 */
	public boolean isEmpty() {
		return empty;
	}

	/**
	 * L�that�s�g
	 */
	private boolean visible;

	/**
	 * El�z� poz�ci�n l�v� elem.
	 */
	private TableElement prevTableElement;

	/**
	 * Jelenlegi poz�ci�n l�v� elem.
	 */
	private TableElement currentTableElement;
	
	public TableElement getcurrentTableElement(){
		return currentTableElement;
	}

	/**
	 * Alag�tba ezen bej�raton �rkezett.
	 */
	private TunnelEntrance enteredTunnel;

	/**
	 * Visszat�r a kocsi sz�n�vel.
	 * 
	 * @return A kocsi sz�ne.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Megt�lti vagy ki�r�ti az elemet.
	 */
	public void changeEmpty() {
		empty = !empty;
	}

	/**
	 * Egy TrainElement objektum l�that�s�g�t v�ltoztatja meg ellenkez�j�re.
	 */
	public void changeVisibility() {
		visible = !visible;
	}

	/**
	 * Be�ll�tja a megadott t�blaelemet aktu�lis elemnek.
	 * 
	 * @param te
	 *            Aktu�lis t�blaelem.
	 */
	public void setTableElement(TableElement te) {
		this.currentTableElement = te;
	}

	/**
	 * Visszat�r az el�z� paz�ci�ban l�z� elemmel.
	 * 
	 * @return Az el�z� t�blaelem.
	 */
	public TableElement getPreviousElement() {
		return prevTableElement;
	}

	/**
	 * Visszat�r, hogy alag�tban van-e (l�that�-e) az elem.
	 * 
	 * @return L�that�-e az elem.
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Az elem mozgat�s�t v�gz� f�ggv�ny.
	 */
	public void move() {
		TableElement next = currentTableElement.nextElement(this);
		currentTableElement.stepOff();
		prevTableElement = currentTableElement;
		next.stepOn(this);
	}

	/**
	 * Utasok lesz�ll�s�t megval�s�t� f�ggv�ny.
	 * 
	 * @param color
	 *            Milyen sz�n� utasokat akarunk lesz�ll�tani.
	 */
	public void hopOff(Color color) {
		return;
	}

	/**
	 * Utasok felsz�ll�s�t megval�s�t� f�ggv�ny.
	 * 
	 * @param color
	 *            Milyen sz�n� utasokat akarunk felsz�ll�tani.
	 */
	public void hopOn(Color color) {
		return;
	}

	/**
	 * Be�ll�tja a param�terk�nt kapott TunnelEntrance-ot enteredTunnel-nek.
	 * 
	 * @param te
	 *            Hol �rkezett be az alag�tba.
	 */
	public void setTunnelEntrance(TunnelEntrance te) {
		this.enteredTunnel = te;
	}

	/**
	 * Visszat�r az alag�tba be�rkez�skor be�ll�tott alag�tbej�rattal.
	 * 
	 * @return Ezen az alag�tbej�raton �rkezett az alag�tba.
	 */
	public TunnelEntrance getTunnelEntrance() {
		return enteredTunnel;
	}
	
	/**
	 * Visszaadja a vonatelem t�pus�t
	 * @return vonatelem t�pusa
	 */
	public String getType(){
		return type;
	}
	
}