package mx.com.sw.services.cancelationretention;

import java.util.Map;
import java.util.UUID;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.cancelation.CancelationValidation;
import mx.com.sw.services.cancelation.responses.CancelationResponse;
import mx.com.sw.services.cancelation.responses.CancelationResponseHandler;

/**
 * Servicios de cancelación de retenciones.
 */
public class CancelationRetention extends CancelationRetentionService {
    private CancelationResponseHandler handler;

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public CancelationRetention(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        handler = new CancelationResponseHandler();
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public CancelationRetention(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        handler = new CancelationResponseHandler();
    }

    /**
     * Método de cancelación de retención enviando un XML de cancelación sellado.
     * <b>Nota:</b> El XML de cancelación no es igual a un CFDI de retención.
     * @param xmlCancelation String xml de cancelación.
     * @return CancelationRetResponse
     */
    @Override
    public CancelationResponse cancelar(String xmlCancelation) {
        try {
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken())
                    .validateRequestXML(xmlCancelation);
            Map<String, String> headers = getHeaders();
            String boundary = UUID.randomUUID().toString();
            String xml = String.format(
                    "--%s\r\nContent-Disposition: form-data; name=xml;"
                    + "filename=xml\r\nContent-Type: text/xml\r\nContent-Transfer-Encoding: binary\r\n\r\n%s\r\n--%s--",
                    boundary, xmlCancelation, boundary);
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPMultipart(getUrl(), "retencion/cancel/xml", headers, xml, config,
                    CancelationResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
    /**
     * Método de cancelación enviando datos de CSD.
     * @param cer String base64 del certificado.
     * @param key String base64 de llave privada.
     * @param rfc rfc emisor.
     * @param password password de llave privada.
     * @param uuid uuid factura.
     * @param motivo motivo de cancelacion.
     * @param folioSustitucion uuid factura que sustituye.
     * @return CancelationRetResponse
     * @see CancelationRetResponse
     */
    @Override
    public CancelationResponse cancelar(String cer, String key, String rfc, String password, String uuid,
        String motivo, String folioSustitucion) {
        try {
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestCSD(cer, key,
                    password, uuid);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestCancelar(cer, key, rfc, password, uuid, motivo, folioSustitucion);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), "retencion/cancel/csd", headers, jsonBody, config,
                    CancelationResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de cancelación enviando datos de PFX.
     * @param pfx String base64 del pfx.
     * @param rfc rfc emisor.
     * @param password password del pfx.
     * @param uuid uuid factura.
     * @param motivo motivo de cancelacion.
     * @param folioSustitucion uuid factura que sustituye.
     * @return CancelationRetResponse
     * @see CancelationRetResponse
     */
    @Override
    public CancelationResponse cancelar(String pfx, String rfc, String password, String uuid,
        String motivo, String folioSustitucion) {
        try {
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestPFX(pfx, password,
                    uuid);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestCancelar(pfx, rfc, password, uuid, motivo, folioSustitucion);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), "retencion/cancel/pfx", headers, jsonBody, config,
                    CancelationResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
} 