package mx.com.sw.services.relations.requests;

/**
 * RelationsRequestCSD Clase con estructura
 * para realizar la petición mediante CSD.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-24
 */
public class RelationsRequestCSD {
    private String uuid;
    private String password;
    private String rfc;
    private String b64Cer;
    private String b64Key;

    /**
     * Constructor de la clase.
     * @param uuid lista uuids a tratar.
     * @param password password llave privada.
     * @param rfc rfc emisor.
     * @param b64Cer String base64 certificado.
     * @param b64Key String base64 llave privada.
     */
    public RelationsRequestCSD(String uuid, String password, String rfc, String b64Cer,
        String b64Key) {
        this.uuid = uuid;
        this.password = password;
        this.rfc = rfc;
        this.b64Cer = b64Cer;
        this.b64Key = b64Key;
    }

    /**
     * Obtiene el UUID a consultar.
     * @return string
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
