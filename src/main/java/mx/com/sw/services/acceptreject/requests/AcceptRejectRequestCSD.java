package mx.com.sw.services.acceptreject.requests;

import java.util.LinkedList;
import java.util.List;

/**
 * AcceptRejectRequestCSD Clase con estructura
 * para realizar la petición mediante CSD.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class AcceptRejectRequestCSD {
    private List<AcceptRejectItem> uuids;
    private String password;
    private String rfc;
    private String b64Cer;
    private String b64Key;

    /**
     * Constructor de la clase.
     * @param uuids lista uuids a tratar.
     * @param password password llave privada.
     * @param rfc rfc emisor.
     * @param b64Cer String base64 certificado.
     * @param b64Key String base64 llave privada.
     */
    public AcceptRejectRequestCSD(List<AcceptRejectItem> uuids, String password, String rfc, String b64Cer,
        String b64Key) {
        this.uuids = uuids;
        this.password = password;
        this.rfc = rfc;
        this.b64Cer = b64Cer;
        this.b64Key = b64Key;
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
     * Obtiene el b64Cer.
     * @return String
     */
    public String getB64Cer() {
        return this.b64Cer;
    }

    /**
     * Obtiene el b64Key.
     * @return String
     */
    public String getB64Key() {
        return this.b64Key;
    }
}
