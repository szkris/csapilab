
import java.util.*;

/**
 * 
 */
public interface ITableElement {

    /**
     * @return
     */
    public void stepOff();

    /**
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