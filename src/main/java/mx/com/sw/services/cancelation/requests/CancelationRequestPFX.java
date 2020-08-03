package mx.com.sw.services.cancelation.requests;

/**
 * <h1>CancelationRequestPFX</h1> Clase estructura para request mediante PFX.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationRequestPFX {
    private String uuid;
    private String password;
    private String rfc;
    private String b64Pfx;

    /**
     * Constructor de la clase.
     * @param uuid
     * @param password
     * @param rfc
     * @param b64Pfx
     */
    public CancelationRequestPFX(String uuid, String password, String rfc, String b64Pfx) {
        this.uuid = uuid;
        this.password = password;
        this.rfc = rfc;
        this.b64Pfx = b64Pfx;
    }

    /**
     * Obtiene UUID.
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Obtiene password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Obtiene RFC.
     */
    public String getRFC() {
        return this.rfc;
    }

    /**
     * Obtiene PFX.
     */
    public String getB64Pfx() {
        return this.b64Pfx;
    }
}
