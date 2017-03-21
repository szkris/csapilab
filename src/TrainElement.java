
import java.util.*;

/**
 * Absztrakt oszt�ly, amely a vonat elemeinek (mozdony �s kocsik) viselked�s�t val�s�tja meg
 */
public abstract class TrainElement {

    /**
     * Default constructor
     */
    public TrainElement() {
    	System.out.println("Constructor TrainElement");
    }

    /**
     * t�rolja, hogy az adott objektum l�that�-e a grafikus fel�leten
     */
    private boolean visible;

    /**
     * az el�z� elem amin a vonat �llt
     */
    private TableElement prevTableElement;

    /**
     * a jelenlegi elem amin a vonat �ll
     */
    private TableElement currentTableElement;

    /**
     * az az alag�t, amiben a vonat halad
     */
    private TableElement enteredTunnel;

    /**
     * megv�ltoztatja az objektum (grafikai) l�that�s�g�t
     * @return
     */
    public void changeVisibility() {
    	System.out.println("TrainElement.changeVisibility");
    }

    /**
     * be�ll�tja param�terk�nt kapott TableElement-et arra, amin a vonat �ll
     * @param TableElement itt �ll a vonat
     * @return
     */
    public void setTableElement(TableElement te) {
        System.out.println("TrainElement.setTableElement");
    }

    /**
     * visszaadja azt a mez�t, amin a vonat �ll
     * @return TableElement amin a vonat �ll
     */
    public TableElement getPreviousElement() {
        System.out.println("TrainElement.getPreviousElement");
        return null;
    }

    /**
     * megh�vja minden vonatelem nextElement() f�ggv�ny�t, ezzel l�ptetve a vonatot
     * @return
     */
    public void move() {
        System.out.println("TrainElement.move");
    }

    /**
     * lesz�ll�tja az utasokat, ha az objektum sz�ne megegyezik az �tvett sz�nnel
     * @param Color a kapott sz�n
     * @return
     */
    public void hopOff(Color color) {
    	System.out.println("TrainElement.hopOff");
    }

    /**
     * be�ll�tja az enteredTunnel-t arra az alag�tra, amiben a vonat halad
     * @param TableElement 
     * @return
     */
    public void setTunnelEntrance(TableElement te) {
    	System.out.println("TrainElement.setTunnelEntrance");
    }
}