package mx.com.sw.services.acceptreject.requests;

import java.util.LinkedList;
import java.util.List;

/**
 * AcceptRejectRequestPFX Clase con estructura
 * para realizar la petición mediante PFX.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class AcceptRejectRequestPFX {
    private List<AcceptRejectItem> uuids;
    private String password;
    private String rfc;
    private String b64Pfx;

    /**
     * Constructor de la clase.
     * @param uuids lista uuid a tratar.
     * @param password password pfx.
     * @param rfc rfc emisor.
     * @param b64Pfx certificado pfx emisor.
     */
    public AcceptRejectRequestPFX(List<AcceptRejectItem> uuids, String password, String rfc, String b64Pfx) {
        this.uuids = uuids;
        this.password = password;
        this.rfc = rfc;
        this.b64Pfx = b64Pfx;
    }

    /**
     * Obtiene la lista de folios.
     * Esté método funciona como setter tambien utilizando
     * de la siguiente manera:
     * <pre>obj.getUUIDs().add(AcceptRejectItem);</pre>
     * @return List AcceptRejectItem
     */
    public List<AcceptRejectItem> getUUIDs() {
        if (this.uuids == null) {
            this.uuids = new LinkedList<AcceptRejectItem>();
        }
        return this.uuids;
    }

    /**
     * Obtiene el password.
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Obtiene el rfc.
     * @return String
     */
    public String getRfc() {
        return this.rfc;
    }

    /**
     * Obtiene el b64Pfx.
     * @return String
     */
    public String getB64Pfx() {
        return this.b64Pfx;
    }
}
