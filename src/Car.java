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
    private Train train;
	
    /**
     * Default constructor
     */
    public Car(Train t, String tab) {
    	System.out.println(tab  + "Constructor Car");
    	train = t;
    }

    /**
     * visszaadja az empty v�ltoz� �rt�k�t
     * @return
     */
    public boolean isEmpty(String tab) {
    	System.out.println(tab + "Car.isEmpty");
        return false;
    }

    /**
     * visszaadja a kocsi sz�n�t
     * @return
     */
    public Color getColor(String tab) {
    	System.out.println(tab + "Car.getColor");
        return null;
    }

    /**
     * ki�r�ti a kocsit (igazz� teszi az empty v�ltoz�t)
     * @return
     */
    public void setEmpty(String tab) {
    	System.out.println(tab + "Car.setEmpty");
    }

}