package mx.com.sw.services.cancelation.requests;

/**
 * <h1>CancelationRequestPFX</h1> Clase estructura para request mediante PFX.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationRequestPFX {
    /**
     * UUID del CFDI a cancelar.
     */
    public String uuid;
    /**
     * Password del archivo PFX.
     */
    public String password;
    /**
     * RFC del emisor del CFDI.
     */
    public String rfc;
    /**
     * String Base64 del archivo PFX.
     */
    public String b64Pfx;
}
