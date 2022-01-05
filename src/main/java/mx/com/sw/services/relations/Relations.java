package mx.com.sw.services.relations;

import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.relations.response.RelationsResponse;
import mx.com.sw.services.relations.response.RelationsResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
* Servicio de Relacionados.
* Clase que permite obtener los UUID Relacionados a una factura.
* <p>
* Ejemplo de uso:
* <pre>
* Relations relations = new Relations("http://services.test.sw.com.mx", "Bearer token...", null, 0);
* AcceptRejectResponse res = Relations.getRelations("EKU9003173C9",
*   "fd74d156-b9b0-44a5-9906-e08182e8363e");
* if("Se encontraron CFDI relacionados. ".equalsIgnoreCase(res.getMessage()){
*    // getUUIDsRelacionadosHijos() y getUUIDsRelacionadosPadres() son una lista
*    // de tipo RelationsUUIDs que pueden contener más de un elemento
*    System.out.println(res.getData().getUUIDsRelacionadosHijos().get(0).getUUID());
*    System.out.println(res.getData().getUUIDsRelacionadosPadres().get(0).getUUID());
*    System.out.println(res.getMessage());
* } else{ // ocurrió un error y en los mensajes podría haber información últil acerca del error.
*   System.out.println(res.getMessage());
*   System.out.println(res.getMessageDetail());
* }
* </pre>
* @author  Dan Iñiguez
* @version 0.0.1.0
* @since   2021-08-17
*/
public class Relations extends RelationsService {
    private RelationsResponseHandler handler;

    /**
     * Constructor de la clase.
     * @param url url base de la API
     * @param token token infinito de SW.
     * @param proxy ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    protected Relations(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        handler = new RelationsResponseHandler();
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
    public Relations(String url, String user, String password, String proxy, int proxyPort)
            throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        handler = new RelationsResponseHandler();
    }

    /**
     * Método de getRelations enviando datos de CSD.
     * @param cer String base64 del certificado.
     * @param key String base64 de llave privada.
     * @param rfc rfc emisor.
     * @param password password de llave privada.
     * @param uuid uuid a consultar.
     * @return RelationsResponse
     * @see RelationsResponse
     */
    @Override
    RelationsResponse getRelations(String cer, String key, String rfc, String password, String uuid) {
        try {
            new RelationsValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestUUID(rfc, uuid);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestRelations(cer, key, rfc, password, uuid);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), "relations/csd", headers, jsonBody,
                    config, RelationsResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de getRelations enviando un XML de Relations sellado.
     * <b>Nota:</b> El XML de Relations no es igual a un CFDI.
     * @param xmlRelations String xml.
     * @return RelationsResponse
     */
    @Override
    RelationsResponse getRelations(String xmlRelations) {
        try {
            new RelationsValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestXML(xmlRelations);
            Map<String, String> headers = getHeaders();
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPMultipart(getUrl(), "relations/xml", headers, xmlRelations, config,
                    RelationsResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de getRelations enviando datos de PFX.
     * @param pfx String base64 del pfx.
     * @param rfc rfc emisor.
     * @param password password del pfx.
     * @param uuid uuid a consultar.
     * @return RelationsResponse
     * @see RelationsResponse
     */
    @Override
    RelationsResponse getRelations(String pfx, String rfc, String password, String uuid) {
        try {
            new RelationsValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestUUID(rfc, uuid);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestRelations(pfx, rfc, password, uuid);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), "relations/pfx", headers, jsonBody,
                    config, RelationsResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de getRelations enviando RFC emisor y UUID.
     * <p>
     * <b>Nota:</b> Es necesario tener configurado un Certificado
     * para el RFC emisor en su cuenta de SW.
     * @param rfc rfc emisor.
     * @param uuid uuid factura.
     * @return RelationsResponse
     * @see RelationsResponse
     */
    @Override
    RelationsResponse getRelations(String rfc, String uuid) {
        try {
            String path = String.format("relations/%s/%s", rfc, uuid);
            new RelationsValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestUUID(rfc, uuid);
            Map<String, String> headers = getHeaders();
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), path, headers, null, config,
                    RelationsResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
}
