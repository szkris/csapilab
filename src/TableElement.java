
import java.util.*;

/**
 * A TableElement egy absztrakt osztály, mely a pálya elemeinek õse
 */
public class TableElement implements ITableElement {

    /**
     * Default constructor
     */
    public TableElement() {
    	System.out.println("Constructor TableElement");
    }

    /**
     * látható-e a mezõ
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
    public void setOccupied(boolean bool) {
    	System.out.println("TableElement.setOccupied");
    }

    /**
     * megvalósítja, mi történjen, amikor egy TrainElement elhagyja a mezõt
     * @return
     */
    public void stepOff() {
    	System.out.println("TableElement.stepOff");
    	setOccupied(false);
    }

    /**
     * megvalósítja, mi történjen, ha a pályán egy mezõre kattintunk
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
     * megvalósítja, mi történjen, amikor egy TrainElement a mezõre lép
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