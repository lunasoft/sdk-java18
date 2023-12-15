package mx.com.sw.services.storage;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;

/**
 * StorageService.
 */
public abstract class StorageService extends Services {
    /**
     * Constructor de la clase.
     * @param url       url base de la API
     * @param urlApi    url base
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
    */
    protected StorageService(String url, String urlApi, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * @param url       url base de la API
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
    */
    protected StorageService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * @throws ServicesException exception en caso de error.
     * @return {@link Map}
    */
    protected Map<String, String> getHeaders() throws ServicesException {
        this.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer " + this.getToken());
        return headers;
    }
}
