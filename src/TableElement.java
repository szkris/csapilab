
import java.util.*;

/**
 * A TableElement egy absztrakt oszt�ly, mely a p�lya elemeinek �se
 */
public class TableElement implements ITableElement {

    /**
     * Default constructor
     */
    public TableElement() {
    	System.out.println("Constructor TableElement");
    }

    /**
     * l�that�-e a mez�
     */
    protected boolean occupied;

    /**
     * A mez�n l�v� vonat elem
     */
    private TrainElement trainelement;

    /**
     * be�ll�tja az objektum (grafikai) l�that�s�g�t a kapott �rt�kre
     * @param boolean l�that�s�g
     * @return
     */
    public void setOccupied(boolean bool) {
    	System.out.println("TableElement.setOccupied");
    }

    /**
     * megval�s�tja, mi t�rt�njen, amikor egy TrainElement elhagyja a mez�t
     * @return
     */
    public void stepOff() {
    	System.out.println("TableElement.stepOff");
    	setOccupied(false);
    }

    /**
     * megval�s�tja, mi t�rt�njen, ha a p�ly�n egy mez�re kattintunk
     * @return
     */
    public void click() {
    	System.out.println("TableElement.click");
    }

    /**
     * 
     * @param TrainElement 
     * @return
     */
    public void nextElement(TrainElement te) {
    	System.out.println("TableElement.nextElement");
    }

    /**
     * megval�s�tja, mi t�rt�njen, amikor egy TrainElement a mez�re l�p
     * @param TrainElement vonatelem
     * @return
     */
    public void stepOn(TrainElement te) {
    	System.out.println("TableElement.stepOn");
    	if(occupied) Game.gameOver();
    	setOccupied(true);
    	te.setTableElement(this);
    }

}