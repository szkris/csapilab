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
     * visszaadja az empty változó értékét
     * @return
     */
    public boolean isEmpty(String tab) {
    	System.out.println(tab + "Car.isEmpty");
        return false;
    }

    /**
     * visszaadja a kocsi színét
     * @return
     */
    public Color getColor(String tab) {
    	System.out.println(tab + "Car.getColor");
        return null;
    }

    /**
     * kiüríti a kocsit (igazzá teszi az empty változót)
     * @return
     */
    public void setEmpty(String tab) {
    	System.out.println(tab + "Car.setEmpty");
    }

}