
import java.util.*;

/**
 * 
 */
public class Tunnel extends Rail {

    /**
     * Default constructor
     */
    public Tunnel() {
    	System.out.println("	Constructor Tunnel");
    }



    /**
     * 
     */
    private Table table;

    /**
     * 
     */
    private TableElement leadsto;


    /**
     * @param TunnelEntrance 
     * @return
     */
    public boolean leadsTo(TunnelEntrance te) {
        // TODO implement here
    	System.out.println("	Tunnel.leadsTo");
        return false;
    }

}