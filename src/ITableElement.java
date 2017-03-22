
import java.util.*;

/**
 * 
 */
public interface ITableElement {

    /**
     * @return
     */
    public void stepOff(String tab);

    /**
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