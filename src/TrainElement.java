
import java.util.*;

/**
 * Absztrakt osztály, amely a vonat elemeinek (mozdony és kocsik) viselkedését valósítja meg
 */
public abstract class TrainElement {

    /**
     * Default constructor
     */
	public TrainElement(){}
	
    public TrainElement(String tab) {
    	System.out.println(tab + "Constructor TrainElement");
    }

    /**
     * tárolja, hogy az adott objektum látható-e a grafikus felületen
     */
    private boolean visible;

    /**
     * az elõzõ elem amin a vonat állt
     */
    private TableElement prevTableElement;

    /**
     * a jelenlegi elem amin a vonat áll
     */
    private TableElement currentTableElement;

    /**
     * az az alagút, amiben a vonat halad
     */
    private TableElement enteredTunnel;

    /**
     * megváltoztatja az objektum (grafikai) láthatóságát
     * @return
     */
    public void changeVisibility(String tab) {
    	System.out.println(tab + "TrainElement.changeVisibility");
    }

    /**
     * beállítja paraméterként kapott TableElement-et arra, amin a vonat áll
     * @param TableElement itt áll a vonat
     * @return
     */
    public void setTableElement(TableElement te, String tab) {
        System.out.println(tab + "TrainElement.setTableElement");
    }

    /**
     * visszaadja azt a mezõt, amin a vonat áll
     * @return TableElement amin a vonat áll
     */
    public TableElement getPreviousElement(String tab) {
        System.out.println(tab + "TrainElement.getPreviousElement");
        return null;
    }

    /**
     * meghívja minden vonatelem nextElement() függvényét, ezzel léptetve a vonatot
     * @return
     */
    public void move(String tab) {
        System.out.println(tab + "TrainElement.move");
    }

    /**
     * leszállítja az utasokat, ha az objektum színe megegyezik az átvett színnel
     * @param Color a kapott szín
     * @return
     */
    public void hopOff(Color color, String tab) {
    	System.out.println(tab + "TrainElement.hopOff");
    }

    /**
     * beállítja az enteredTunnel-t arra az alagútra, amiben a vonat halad
     * @param TableElement 
     * @return
     */
    public void setTunnelEntrance(TableElement te, String tab) {
    	System.out.println(tab + "TrainElement.setTunnelEntrance");
    }
}