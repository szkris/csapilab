
import java.util.*;

/**
 * A pálya objektumainak viselkedését leíró interfész
 */
public interface ITableElement {

    /**
     * @return
     */
    public void stepOff(String tab);

    /**
     * megvalósítja, mi történjen, ha a pályán egy objektumra kattintunk
     * @return
     */
    public void click(String tab);

    /**
     * @param TrainElement 
     * @return
     */
    public void nextElement(TrainElement te, String tab);

    /**
     * @param TrainElement 
     * @return
     */
    public void stepOn(TrainElement te, String tab);

}