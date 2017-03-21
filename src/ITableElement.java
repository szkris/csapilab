
import java.util.*;

/**
 * A p�lya objektumainak viselked�s�t le�r� interf�sz
 */
public interface ITableElement {

    /**
     * @return
     */
    public void stepOff();

    /**
     * megval�s�tja, mi t�rt�njen, ha a p�ly�n egy objektumra kattintunk
     * @return
     */
    public void click();

    /**
     * @param TrainElement 
     * @return
     */
    public void nextElement(TrainElement te);

    /**
     * @param TrainElement 
     * @return
     */
    public void stepOn(TrainElement te);

}