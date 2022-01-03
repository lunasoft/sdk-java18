package mx.com.sw.services.acceptreject;

import java.util.List;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.acceptreject.requests.AcceptRejectItem;
import mx.com.sw.services.acceptreject.requests.EnumAcceptReject;
import mx.com.sw.services.acceptreject.responses.AcceptRejectResponse;
import mx.com.sw.services.acceptreject.responses.AcceptRejectResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
* Servicio de Aceptar o rechazar solicitud.
* Clase que permite Aceptar o rechazar solicitud de una solicitud de cancelacion.
* <p>
* Ejemplo de uso:
* <pre>
* AcceptReject acceptReject = new AcceptReject("http://services.test.sw.com.mx", "Bearer token...", null, 0);
* AcceptRejectResponse res = acceptReject.setAction("EKU9003173C9",
*   "fd74d156-b9b0-44a5-9906-e08182e8363e", EnumAcceptReject.Aceptacion);
* if("success".equalsIgnoreCase(res.getStatus()){
*    //res.getData().getFolios() es un arreglo este puedes contener mas de un objeto y peudes iterarlo
*    System.out.println(res.getData().getFolios().get(0).getEstatusUUID());
*    System.out.println(res.getData().getFolios().get(0).getUUID());
*    System.out.println(res.getData().getFolios().get(0).getRespuesta());
*    System.out.println(res.getData().getAcuse());
* } else{ // ocurrió un error y en los mensajes podría haber información últil acerca del error.
*   System.out.println(res.getMessage());
*   System.out.println(res.getMessageDetail());
* }
* </pre>
* @author  Dan Iñiguez
* @version 0.0.1.0
* @since   2021-08-17
*/
public class AcceptReject extends AcceptRejectService {
    private AcceptRejectResponseHandler handler;

    /**
     * Constructor de la clase.
     * @param url url base de la API
     * @param token token infinito de SW.
     * @param proxy ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    protected AcceptReject(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        handler = new AcceptRejectResponseHandler();
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
    public AcceptReject(String url, String user, String password, String proxy, int proxyPort)
            throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        handler = new AcceptRejectResponseHandler();
    }

    /**
     * Método de acceptRejec enviando datos de CSD.
     * @param cer String base64 del certificado.
     * @param key String base64 de llave privada.
     * @param rfc rfc emisor.
     * @param password password de llave privada.
     * @param uuids AcceptRejectItem.
     * @return AcceptRejectResponse
     * @see AcceptRejectResponse
     */
    @Override
    AcceptRejectResponse setAction(String cer, String key, String rfc, String password,
            List<AcceptRejectItem> uuids) {
        try {
            new AcceptRejectValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestUUID(rfc, uuids);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestAcceptReject(cer, key, rfc, password, uuids);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), "acceptreject/csd", headers, jsonBody,
                    config, AcceptRejectResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de AcceptReject enviando un XML de acceptReject sellado.
     * <b>Nota:</b> El XML de acceptReject no es igual a un CFDI.
     * @param xmlAcceptReject String xml.
     * @return AcceptRejectResponse
     */
    @Override
    AcceptRejectResponse setAction(String xmlAcceptReject) {
        try {
            new AcceptRejectValidation(getUrl(), getUser(), getPassword(), getToken())
                    .validateRequestXML(xmlAcceptReject);
            Map<String, String> headers = getHeaders();
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPMultipart(getUrl(), "acceptreject/xml", headers, xmlAcceptReject, config,
                    AcceptRejectResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de AcceptReject enviando datos de PFX.
     * @param pfx String base64 del pfx.
     * @param rfc rfc emisor.
     * @param password password del pfx.
     * @param uuids AcceptRejectItem.
     * @return AcceptRejectResponse
     * @see AcceptRejectResponse
     */
    @Override
    AcceptRejectResponse setAction(String pfx, String rfc, String password, List<AcceptRejectItem> uuids) {
        try {
            new AcceptRejectValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestUUID(rfc, uuids);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestAcceptReject(pfx, rfc, password, uuids);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), "acceptreject/pfx", headers, jsonBody,
                    config, AcceptRejectResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de AcceptReject enviando RFC emisor y UUID.
     * <p>
     * <b>Nota:</b> Es necesario tener configurado un Certificado
     * para el RFC emisor en su cuenta de SW.
     * @param rfc rfc emisor.
     * @param uuid uuid factura.
     * @return AcceptRejectResponse
     * @see AcceptRejectResponse
     */
    @Override
    AcceptRejectResponse setAction(String rfc, String uuid, EnumAcceptReject action) {
        try {
            String path = String.format("acceptreject/%s/%s/%s", rfc, uuid, action.toString());
            new AcceptRejectValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestUUID(rfc, uuid);
            Map<String, String> headers = getHeaders();
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), path, headers, null, config, AcceptRejectResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
}
