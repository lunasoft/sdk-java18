package mx.com.sw.services.issue;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.ResponseHandler;
import mx.com.sw.services.Services;
import org.apache.http.client.config.RequestConfig;

/**
 * IssueJsonService Servicio base para
 * servicios issue JSON.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class IssueJsonService extends Services {

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected IssueJsonService(String url, String user, String password, String proxy,
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
    protected IssueJsonService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Obtiene los headers necesarios para el timbrado.
     * @return HashMap String, String
     * @throws ServicesException exception en caso de error.
     */
    protected Map<String, String> getHeaders() throws ServicesException {
        super.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        headers.put("Content-Type", "application/jsontoxml");
        return headers;
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la configuracion recibida.
     * @param json String json.
     * @param headers headers llave valor.
     * @param formatPath String a parsear.
     * @param operation operacion a realizar.
     * @param version String version.
     * @param handler object handler.
     * @param classType response class.
     * @param <T> type class.
     * @return T
     */
    protected <T> T timbrar(String json, Map<String, String> headers, String formatPath, String operation,
            String version, ResponseHandler<T> handler, Class<T> classType) {
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        String path = String.format(formatPath, operation, version);
        return handler.postHTTPJson(getUrl(), path, headers, json, config, classType);
    }
}
