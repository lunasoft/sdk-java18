package mx.com.sw.services.cancelation.requests;

/**
 * CancelationRequestCSD Clase estructura para request mediante CSD.
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
    private String motivo;
    private String folioSustitucion;

    /**
     * Constructor de la clase.
     * @param uuid uuid factura.
     * @param password password llave privada.
     * @param rfc rfc emisor.
     * @param b64Cer String base64 de certificado.
     * @param b64Key String base64 de llave privada.
     * @param motivo motivo de cancelación.
     * @param folioSustitucion uuid factura que sustituye.
     */
    public CancelationRequestCSD(String uuid, String password, String rfc, String b64Cer, String b64Key,
        String motivo, String folioSustitucion) {
        this.uuid = uuid;
        this.password = password;
        this.rfc = rfc;
        this.b64Cer = b64Cer;
        this.b64Key = b64Key;
        this.motivo = motivo;
        this.folioSustitucion = folioSustitucion;
    }

    /**
     * Obtiene uuid.
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
     * Obtiene Certificado.
     * @return String
     */
    public String getB64Csd() {
        return this.b64Cer;
    }

    /**
     * Obtiene llave privada.
     * @return String
     */
    public String getB64Key() {
        return this.b64Key;
    }

    /**
     * Obtiene motivo.
     * @return String
     */
    public String getMotivo() {
        return this.motivo;
    }

    /**
     * Obtiene folioSustitucion.
     * @return String
     */
    public String getFolioSustitucion() {
        return this.folioSustitucion;
    }
}
