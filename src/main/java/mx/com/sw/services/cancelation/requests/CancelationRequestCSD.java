package mx.com.sw.services.cancelation.requests;

/**
 * <h1>CancelationRequestCSD</h1> Clase estructura para request mediante CSD.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationRequestCSD {
    /**
     * UUID del CFDI a cancelar.
     */
    public String uuid;
    /**
     * Password del archivo key.
     */
    public String password;
    /**
     * RFC del emisor del CFDI.
     */
    public String rfc;
    /**
     * String Base64 del archivo CSD.
     */
    public String b64Cer;
    /**
     * String Base64 del archivo KEY.
     */
    public String b64Key;
}
