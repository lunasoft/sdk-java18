package mx.com.sw.services.storage;

import java.util.Map;
import java.util.UUID;

import org.apache.http.client.config.RequestConfig;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;

public class Storage extends StorageService {
    StorageResponseHandler handler;

    /**
     * Constructor de la clase.
     * 
     * @param urlApi       url base de la API
     * @param url url base
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
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
     * @param urlApi       url base de la API
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public Storage(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
        handler = new StorageResponseHandler();
    }

    /**
     * Servicio para recuperar un XML previamente timbrado.
     * @param uuid UUID del comprobante.
     * @return StorageResponse
     * @throws ServicesException
     */

    public StorageResponse getXml(UUID uuid) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        StorageResponse response = handler.getHTTP(getUrlapi()==null ? getUrl() : getUrlapi(),
                "datawarehouse/v1/live/" + uuid, headers, config,
                StorageResponse.class);
        if (response.getData() == null || response.getData().getRecords().size() <= 0) {
            response.setStatus("error");
        }
        return response;
    }

}
