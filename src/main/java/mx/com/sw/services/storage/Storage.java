package mx.com.sw.services.storage;

import java.util.Map;
import java.util.UUID;

import org.apache.http.client.config.RequestConfig;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;

public class Storage extends StorageService {
    String uuid;
    StorageResponseHandler handler;

    /**
     * Constructor de la clase.
     * 
     * @param url       url base de la API
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @param uuid      uuid del xml a recuperar
     * @throws ServicesException exception en caso de error.
     */

    public Storage(String urlApi, String url, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
        handler = new StorageResponseHandler();
    }

    /**
     * Constructor de la clase.
     * 
     * @param url       url base de la API
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @param uuid      uuid del xml a recuperar
     * @throws ServicesException exception en caso de error.
     */
    public Storage(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
        handler = new StorageResponseHandler();
    }

    public StorageResponse getXml(UUID uuid) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        return handler.getHTTP(getUrl(), "datawarehouse/v1/live/" + uuid, headers, config, StorageResponse.class);
    }

}
