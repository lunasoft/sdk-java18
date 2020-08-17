package mx.com.sw.services.account.info;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.services.Services;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;

/**
 * AccountInfoService - Servicio para implementación de consulta de información.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-14
 */
public abstract class AccountInfoService extends Services {
    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    protected AccountInfoService(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    protected AccountInfoService(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Consulta los datos de la cuenta configurada.
     * @return {@link AccountInfoResponse}
     */
    public abstract AccountInfoResponse getInfo();

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * @return {@link Map}
     */
    protected Map<String, String> getHeaders() {
        this.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
