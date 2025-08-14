package mx.com.sw.services.cancelationretention.responses;

import java.util.Map;

/**
 * Clase con la informacion de la cancelación de retención.
 */
public class CancelationRetentionData {
    private String acuse;
    private Map<String, String> uuid;

    /**
     * Obtiene el acuse de cancelación.
     * @return String
     */
    public String getAcuse() {
        return this.acuse;
    }

    /**
     * Obtiene llave valor de los UUID y su estatus de cancelación.
     */
    public Map<String, String> getUUID() {
        return this.uuid;
    }
} 