
import java.util.*;

/**
 * A TableElement egy absztrakt osztály, mely a pálya elemeinek õse
 */
public class TableElement implements ITableElement {

	/**
	 * default konstruktor
	 */
	public TableElement() {
		
	}
	/**
	 * TableElement konstruktora.
	 * @param tab tabulátor karakter a hierarchiához
	 */
    public TableElement(String tab) {
    	System.out.println(tab + "Constructor TableElement");
    }

    /**
     * Látható-e a mezõ
     */
    protected boolean occupied;

    /**
     * A mezõn lévõ vonat elem
     */
    private TrainElement trainelement;

    /**
     * beállítja az objektum (grafikai) láthatóságát a kapott értékre
     * @param boolean láthatóság
     * @return
     */
    public void setOccupied(boolean bool, String tab) {
    	System.out.println(tab + "TableElement.setOccupied");
    }

    /**
     * megvalósítja, mi történjen, amikor egy TrainElement elhagyja a mezõt
     * @return
     */
    public void stepOff(String tab ) {
    	System.out.println(tab + "TableElement.stepOff");
    	setOccupied(false, tab+"\t");
    }

    /**
     * megvalósítja, mi történjen, ha a pályán egy mezõre kattintunk
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
     * megvalósítja, mi történjen, amikor egy TrainElement a mezõre lép
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