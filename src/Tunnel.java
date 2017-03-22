
import java.util.*;

/**
 * Az alagutat megvalósító osztály
 */
public class Tunnel extends Rail {

    /**
     * Default constructor
     */
    public Tunnel(String tab) {
    	System.out.println(tab + "Constructor Tunnel");
    }

    /**
     * mutató a pályára
     */
    private Table table;

    /**
     * tárolja hogy hova vezet az alagút
     */
    private TableElement leadsto;


    /**
     * megmondja hogy az adott alagútrész vezet e a kapott kijárathoz
     * @param TunnelEntrance 
     * @return
     */
    public boolean leadsTo(TunnelEntrance te, String tab) {
    	System.out.println(tab + "Tunnel.leadsTo");
        return false;
    }

}