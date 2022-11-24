package mx.com.sw.services.resend.request;

import java.util.List;

public class ResendRequest {
    private String uuid;
    private String to;

    /**
     * Constructor de la clase
     * 
     * @param uuid    uuid del comprobante.
     * @param correos lista de correos.
     */
    public ResendRequest(String uuid, List<String> correos) {
        this.uuid = uuid;
        this.to = String.join(",", correos);
    }

}
