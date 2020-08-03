package mx.com.sw.services.stamp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.ResponseHandler;
import mx.com.sw.services.Services;
import org.apache.http.client.config.RequestConfig;

/**
 * <h1>StampService</h1> Servicio de timbrado genérico para XML.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public abstract class StampService extends Services {

    /**
     * Constructor de la clase.
     * @param url
     * @param token
     * @param proxy
     * @param proxyPort
     */
    protected StampService(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * @param url
     * @param usuario
     * @param password
     * @param proxy
     * @param proxyPort
     */
    protected StampService(String url, String usuario, String password, String proxy, int proxyPort) {
        super(url, usuario, password, proxy, proxyPort);
    }

    /**
     * Obtiene el cuerpo de la solicitud.
     * @param xmlString
     * @param boundary
     * @return String
     */
    protected String getMultipartBody(String xmlString, String boundary) {
        return String.format(
                "--%s\r\nContent-Disposition: form-data; name=xml; "
                + "filename=xml\r\nContent-Type: application/xml\r\n\r\n%s\r\n--%s--",
                boundary, xmlString, boundary);
    }

    /**
     * Obtiene los headers minímos para su funcionamiento.
     * @return Map<String, String>
     */
    protected Map<String, String> getHeaders() {
        super.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }

    /**
     * Realiza el timbrado de un documento dada la configuracion.
     * @param <T> generic response type
     * @param xml
     * @param path
     * @param headers
     * @param handler
     * @param classType
     * @return T
     */
    protected <T> T timbrar(String xml, String path, Map<String, String> headers,
        ResponseHandler<T> handler, Class<T> classType) {
        String boundary = UUID.randomUUID().toString();
        headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
        String xmlBody = this.getMultipartBody(xml, boundary);
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        return handler.postHTTPMultipart(getUrl(), path, headers, xmlBody, config, classType);
    }
}
