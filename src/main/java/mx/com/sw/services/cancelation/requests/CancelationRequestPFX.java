package mx.com.sw.services.cancelation.requests;

/**
 * CancelationRequestPFX Clase estructura para request mediante PFX.
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
     * @param uuid uuid de factura.
     * @param password password de pfx.
     * @param rfc rfc emisor.
     * @param b64Pfx String base64 de pfx.
     */
    public CancelationRequestPFX(String uuid, String password, String rfc, String b64Pfx) {
        this.uuid = uuid;
        this.password = password;
        this.rfc = rfc;
        this.b64Pfx = b64Pfx;
    }

    /**
     * Obtiene UUID.
     * @return String
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Obtiene password.
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Obtiene RFC.
     * @return String
     */
    public String getRFC() {
        return this.rfc;
    }

    /**
     * Obtiene PFX.
     * @return String
     */
    public String getB64Pfx() {
        return this.b64Pfx;
    }
}
