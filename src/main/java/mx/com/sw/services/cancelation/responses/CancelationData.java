package mx.com.sw.services.cancelation.responses;

import java.util.Map;

/**
 * CancelationData Clase con la informacion de la cancelación.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationData {
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
     * 201 - Cancelado con éxito.
     * 202 - Previamente cancelado.
     * @return Map String String
     */
    public Map<String, String> getUUID() {
        return this.uuid;
    }
}
