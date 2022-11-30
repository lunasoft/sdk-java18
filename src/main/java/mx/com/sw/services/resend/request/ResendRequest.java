package mx.com.sw.services.resend.request;

import java.util.List;
import java.util.UUID;

public class ResendRequest {
    private UUID uuid;
    private String to;

    /**
     * Constructor de la clase
     * 
     * @param uuid    uuid del comprobante.
     * @param correos lista de correos.
     */
    public ResendRequest(UUID uuid, List<String> correos) {
        this.uuid = uuid;
        this.to = String.join(",", correos);
    }

}
