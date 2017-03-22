import java.util.*;

/**
 * Car osztály (kocsi), mely a TrainElement leszármazottja
 */
public class Car extends TrainElement {

	/**
     * Kocsi színe
     */
    private Color color;

    /**
     * A kocsin vannak-e utasok
     */
    private boolean empty;
    
    /**
     * Mutató a kocsit tartalmazó Train-re
     */
    private Train train;
	
    /**
     * Default constructor
     */
    public Car(Train t, String tab) {
    	System.out.println(tab  + "Constructor Car");
    	train = t;
    }

    /**
     * @return
     */
    public boolean isEmpty(String tab) {
    	System.out.println(tab + "Car.isEmpty");
        return false;
    }

    /**
     * @return
     */
    public Color getColor(String tab) {
    	System.out.println(tab + "Car.getColor");
        return null;
    }

    /**
     * @return
     */
    public void setEmpty(String tab) {
    	System.out.println(tab + "Car.setEmpty");
    }

}