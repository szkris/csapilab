
import java.util.*;

/**
 * Az alagutat megval�s�t� oszt�ly
 */
public class Tunnel extends Rail {

    /**
     * Default constructor
     */
    public Tunnel(String tab) {
    	System.out.println(tab + "Constructor Tunnel");
    }

    /**
     * mutat� a p�ly�ra
     */
    private Table table;

    /**
     * t�rolja hogy hova vezet az alag�t
     */
    private TableElement leadsto;


    /**
     * megmondja hogy az adott alag�tr�sz vezet e a kapott kij�rathoz
     * @param TunnelEntrance 
     * @return
     */
    public boolean leadsTo(TunnelEntrance te, String tab) {
    	System.out.println(tab + "Tunnel.leadsTo");
        return false;
    }

}