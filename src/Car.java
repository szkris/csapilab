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
    public Car(Train t) {
    	System.out.println("Constructor Car");
    	train = t;
    }

    /**
     * @return
     */
    public boolean isEmpty() {
    	System.out.println("Car.isEmpty");
        return false;
    }

    /**
     * @return
     */
    public Color getColor() {
    	System.out.println("Car.getColor");
        return null;
    }

    /**
     * @return
     */
    public void setEmpty() {
    	System.out.println("Car.setEmpty");
    }

}