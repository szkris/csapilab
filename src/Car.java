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
    private Train train = new Train();
	
    /**
     * Default constructor
     */
    public Car() {
    	System.out.println("Constructor Car");
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        // TODO implement here
    	System.out.println("Car.isEmpty");
        return false;
    }

    /**
     * @return
     */
    public Color getColor() {
        // TODO implement here
    	System.out.println("Car.getColor");
        return null;
    }

    /**
     * @return
     */
    public void setEmpty() {
        // TODO implement here
    	System.out.println("Car.setEmpty");
    }

}