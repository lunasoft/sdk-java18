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
    private String motivo;
    private String folioSustitucion;

    /**
     * Constructor de la clase.
     * @param uuid uuid de factura.
     * @param password password de pfx.
     * @param rfc rfc emisor.
     * @param b64Pfx String base64 de pfx.
     * @param motivo motivo de cancelacion.
     * @param folioSustitucion uuid factura que sustituye.
     */
    public CancelationRequestPFX(String uuid, String password, String rfc, String b64Pfx,
        String motivo, String folioSustitucion) {
        this.uuid = uuid;
        this.password = password;
        this.rfc = rfc;
        this.b64Pfx = b64Pfx;
        this.motivo = motivo;
        this.folioSustitucion = folioSustitucion;
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

    /**
     * Obtiene motivo.
     * @return String
     */
    public String motivo() {
        return this.motivo;
    }

    /**
     * Obtiene folioSustitucion.
     * @return String
     */
    public String folioSustitucion() {
        return this.folioSustitucion;
    }
}
