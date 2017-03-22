
import java.util.*;

/**
 * 
 */
public class Tunnel extends Rail {

    /**
     * Default constructor
     */
    public Tunnel(String tab) {
    	System.out.println(tab + "Constructor Tunnel");
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
    public boolean leadsTo(TunnelEntrance te, String tab) {
    	System.out.println(tab + "Tunnel.leadsTo");
        return false;
    }

}