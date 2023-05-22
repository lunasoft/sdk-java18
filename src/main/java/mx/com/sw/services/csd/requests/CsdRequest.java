package mx.com.sw.services.csd.requests;

public class CsdRequest {
    private String b64Cer;
    private String b64Key;
    private String password;
    private String type;
    private Boolean is_active;

     /**
     * Constructor de la clase.
     * @param b64Cer String base64 certificado.
     * @param b64Key String base64 llave privada.
     * @param password password llave privada.
     */
    public CsdRequest(String b64Cer, String b64Key, String password) {
        this.b64Cer = b64Cer;
        this.b64Key = b64Key;
        this.password = password;
        this.type = "stamp";
        this.is_active = true;
    }

    /**
     * Obtiene el certificado en base 64.
     * @return string
     */
    public String getB64Cer() {
        return this.b64Cer;
    }

    /**
     * Obtiene la llave privada en base 64.
     * @return string
     */
    public String getB64Key() {
        return this.b64Key;
    }

    /**
     * Obtiene la contraseña del certificado.
     * @return string
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Obtiene el tipo de certificado
     * @return string
     */
    public String getType() {
        return this.type;
    }

    /**
     * Obtiene el estado del certificado
     * @return string
     */
    public Boolean getIs_active() {
        return this.is_active;
    }
}
