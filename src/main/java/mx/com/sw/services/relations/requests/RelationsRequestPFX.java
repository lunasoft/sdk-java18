package mx.com.sw.services.relations.requests;

/**
 * RelationsRequestPFX Clase con estructura
 * para realizar la petición mediante PFX.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-24
 */
public class RelationsRequestPFX {
    private String uuid;
    private String password;
    private String rfc;
    private String b64Pfx;

    /**
     * Constructor de la clase.
     * @param uuid lista uuid a tratar.
     * @param password password pfx.
     * @param rfc rfc emisor.
     * @param b64Pfx certificado pfx emisor.
     */
    public RelationsRequestPFX(String uuid, String password, String rfc, String b64Pfx) {
        this.uuid = uuid;
        this.password = password;
        this.rfc = rfc;
        this.b64Pfx = b64Pfx;
    }

    /**
     * Obtiene el UUID a consultar.
     * @return String
     */
    public String getUUID() {
        return this.uuid;
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
