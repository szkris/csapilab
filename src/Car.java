import java.util.*;

/**
 * Car oszt�ly (kocsi), mely a TrainElement lesz�rmazottja
 */
public class Car extends TrainElement {

	/**
     * Kocsi sz�ne
     */
    private Color color;

    /**
     * A kocsin vannak-e utasok
     */
    private boolean empty;
    
    /**
     * Mutat� a kocsit tartalmaz� Train-re
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