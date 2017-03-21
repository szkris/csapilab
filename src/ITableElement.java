
import java.util.*;

/**
 * A pálya objektumainak viselkedését leíró interfész
 */
public interface ITableElement {

    /**
     * @return
     */
    public void stepOff();

    /**
     * megvalósítja, mi történjen, ha a pályán egy objektumra kattintunk
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