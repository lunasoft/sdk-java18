package mx.com.sw.services.issue;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.ResponseHandler;
import mx.com.sw.services.Services;
import org.apache.http.client.config.RequestConfig;

/**
 * <h1>IssueJsonService</h1> Servicio base para
 * servicios issue JSON.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class IssueJsonService extends Services {

    /**
     * Constructor de la clase.
     * @param url
     * @param user
     * @param password
     * @param proxy
     * @param proxyPort
     */
    protected IssueJsonService(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * @param url
     * @param token
     * @param proxy
     * @param proxyPort
     */
    protected IssueJsonService(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Obtiene los headers necesarios para el timbrado.
     * @return HashMap<String, String>
     */
    protected Map<String, String> getHeaders() {
        super.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        headers.put("Content-Type", "application/jsontoxml");
        return headers;
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la configuracion recibida.
     * @param json
     * @param headers
     * @param formatPath
     * @param operation
     * @param version
     * @param handler
     * @param classType
     * @return T
     */
    protected <T> T timbrar(String json, Map<String, String> headers, String formatPath, String operation,
            String version, ResponseHandler<T> handler, Class<T> classType) {
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        String path = String.format(formatPath, operation, version);
        return handler.postHTTPJson(getUrl(), path, headers, json, config, classType);
    }
}
