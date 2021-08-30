package mx.com.sw.services.pendings;

import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.pendings.response.PendingsResponse;
import mx.com.sw.services.pendings.response.PendingsResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
* Servicio de Consulta facturas pendientes.
* Clase permite consultar facturas pendientes.
* <p>
* Ejemplo de uso:
* <pre>
* Pendings pendings = new Pendings("http://services.test.sw.com.mx", "Bearer .......", null, 0);
* PendingsResponse res = pendings.getPendings("XIA190128J61");
* if("CA1100 - Se recibío la respuesta de la petición de forma exitosa.".equalsIgnoreCase(res.getMessage()){
*   //getUUIDs() Es una lista, la cual puede contener más de un uuid
*   System.out.println(res.getData().getUUIDs().get(0));
* } else{ // ocurrió un error y en los mensajes podría haber información últil acerca del error.
*   System.out.println(res.getMessage());
*   System.out.println(res.getMessageDetail());
* }
* </pre>
* @author  Dan Iñiguez
* @version 0.0.1.0
* @since   2021-08-25
*/

public class Pendings extends PendingsService {
    private PendingsResponseHandler handler;

    /**
     * Constructor de la clase.
     * @param url       url base de la API
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public Pendings(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        handler = new PendingsResponseHandler();
    }

    /**
     * Constructor de la clase.
     * @param url       url base de la API
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public Pendings(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        handler = new PendingsResponseHandler();
    }

    /**
     * Método de PendingsResponse enviando RFC.
     * <p>
     * @param rfc rfc emisor.
     * @return PendingsResponse
     * @see PendingsResponse
     */
    @Override
    public PendingsResponse getPendings(String rfc) throws ServicesException {
        new PendingsValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestUUID(rfc);
        String path = String.format("pendings/%s", rfc);
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        return handler.getHTTP(getUrl(), path, headers, config, PendingsResponse.class);
    }

}
