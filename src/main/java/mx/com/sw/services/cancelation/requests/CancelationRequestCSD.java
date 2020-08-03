package mx.com.sw.services.cancelation.requests;

/**
 * <h1>CancelationRequestCSD</h1> Clase estructura para request mediante CSD.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationRequestCSD {
    private String uuid;
    private String password;
    private String rfc;
    private String b64Cer;
    private String b64Key;

    /**
     * Constructor de la clase.
     * @param uuid
     * @param password
     * @param rfc
     * @param b64Cer
     * @param b64Key
     */
    public CancelationRequestCSD(String uuid, String password, String rfc, String b64Cer, String b64Key) {
        this.uuid = uuid;
        this.password = password;
        this.rfc = rfc;
        this.b64Cer = b64Cer;
        this.b64Key = b64Key;
    }

    /**
     * Obtiene uuid.
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
     * Obtiene Certificado.
     */
    public String getB64Csd() {
        return this.b64Cer;
    }

    /**
     * Obtiene llave privada.
     */
    public String getB64Key() {
        return this.b64Key;
    }
}
