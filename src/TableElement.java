
import java.util.*;

/**
 * A TableElement egy absztrakt oszt�ly, mely a p�lya elemeinek �se
 */
public class TableElement implements ITableElement {

	/**
	 * default konstruktor
	 */
	public TableElement() {
		
	}
	/**
	 * TableElement konstruktora.
	 * @param tab tabul�tor karakter a hierarchi�hoz
	 */
    public TableElement(String tab) {
    	System.out.println(tab + "Constructor TableElement");
    }

    /**
     * L�that�-e a mez�
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
    public void setOccupied(boolean bool, String tab) {
    	System.out.println(tab + "TableElement.setOccupied");
    }

    /**
     * megval�s�tja, mi t�rt�njen, amikor egy TrainElement elhagyja a mez�t
     * @return
     */
    public void stepOff(String tab ) {
    	System.out.println(tab + "TableElement.stepOff");
    	setOccupied(false, tab+"\t");
    }

    /**
     * megval�s�tja, mi t�rt�njen, ha a p�ly�n egy mez�re kattintunk
     * @return
     */
    public void click(String tab) {
    	System.out.println(tab + "TableElement.click");
    }

    /**
     * 
     * @param TrainElement 
     * @return
     */
    public void nextElement(TrainElement te, String tab) {
    	System.out.println(tab + "TableElement.nextElement");
    }

    /**
     * megval�s�tja, mi t�rt�njen, amikor egy TrainElement a mez�re l�p
     * @param TrainElement vonatelem
     * @return
     */
    public void stepOn(TrainElement te, String tab) {
    	System.out.println(tab + "TableElement.stepOn");
    	if(occupied) {
    		Game.gameOver(tab+"\t");
    		return;
    	}
    	setOccupied(true, tab+"\t");
    	te.setTableElement(this, tab+"\t");
    }

}