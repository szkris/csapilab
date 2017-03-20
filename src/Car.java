import java.util.*;

/**
 * 
 */
public class Car extends Train {

    /**
     * Default constructor
     */
    public Car() {
    	System.out.println("Constructor Car");
    }

    /**
     * 
     */
    private Color color;

    /**
     * 
     */
    private boolean empty;




    /**
     * 
     */
    private Train train;



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