package mx.com.sw.services.cancelation.responses;

import java.util.Map;

/**
 * <h1>CancelationData</h1> Clase con la informacion de la cancelación.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationData {
    /**
     * Acuse de cancelación.
     */
    public String acuse;
    /**
     * Llave valor de los UUID y su estatus de cancelación.
     * 201 - Cancelado con éxito.
     * 202 - Previamente cancelado.
     */
    public Map<String, String> uuid;
}
