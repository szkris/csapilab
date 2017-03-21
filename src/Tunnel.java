
/**
 * Az alagutat megvalósító osztály
 */
public class Tunnel extends Rail {

    /**
     * Default constructor
     */
    public Tunnel() {
    	System.out.println("Constructor Tunnel");
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
    public boolean leadsTo(TunnelEntrance te) {
        // TODO implement here
    	System.out.println("Tunnel.leadsTo");
        return false;
    }

}