package mx.com.sw.services.cancelationretention;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;
import mx.com.sw.services.cancelationretention.responses.CancelationRetentionResponse;

/**
 * CancelationRetentionService Servicio para implementación de cancelación de retenciones.
 * @since 2025-008-12
 */
public abstract class CancelationRetentionService extends Services {

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected CancelationRetentionService(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected CancelationRetentionService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Método abstracto para cancelar retención mediante XML.
     * @param xmlCancelation String xml de cancelación.
     * @return CancelationRetentionResponse
     */
    abstract CancelationRetentionResponse cancelar(String xmlCancelation);

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * @return Map String, String
     * @throws ServicesException exception en caso de error.
     */
    protected Map<String, String> getHeaders() throws ServicesException {
        this.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }
} 