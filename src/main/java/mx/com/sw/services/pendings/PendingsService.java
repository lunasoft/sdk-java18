package mx.com.sw.services.pendings;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;
import mx.com.sw.services.pendings.response.PendingsResponse;

/**
 * PendingsService - Servicio para consultar facturas pendientes.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-26
 */
public abstract class PendingsService extends Services {

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected PendingsService(String url, String user, String password, String proxy,
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
    protected PendingsService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Consulta facturas pendientes.
     * @return {@link PendingsResponse}
     * @throws ServicesException exception en caso de error.
     */
    public abstract PendingsResponse getPendings(String rfc) throws ServicesException;

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * @throws ServicesException exception en caso de error.
     * @return {@link Map}
     */
    protected Map<String, String> getHeaders() throws ServicesException {
        this.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }
}
