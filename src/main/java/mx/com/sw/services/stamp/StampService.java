package mx.com.sw.services.stamp;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.ResponseHandler;
import mx.com.sw.services.Services;
import org.apache.http.client.config.RequestConfig;

/**
 * StampService Servicio de timbrado genérico para XML.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public abstract class StampService extends Services {

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected StampService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected StampService(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    /**
     * Obtiene los headers minímos para su funcionamiento.
     * @return Map String, String
     * @throws ServicesException exception en caso de error.
     */
    protected Map<String, String> getHeaders() throws ServicesException {
        super.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }

    /**
     * Realiza el timbrado de un documento dada la configuracion.
     * @param <T> generic response type
     * @param xml String xml.
     * @param path String path.
     * @param headers Key value con headers.
     * @param handler Object handler.
     * @param classType Class response.
     * @return T
     */
    protected <T> T timbrar(String xml, String path, Map<String, String> headers,
        ResponseHandler<T> handler, Class<T> classType) {
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        return handler.postHTTPMultipart(getUrl(), path, headers, xml, config, classType);
    }
}
