package mx.com.sw.services.cancelation;

import java.util.Map;
import java.util.UUID;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.cancelation.responses.CancelationResponse;
import mx.com.sw.services.cancelation.responses.CancelationResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
 * <h1>Cancelation</h1> Servicio para servicios de cancelación.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class Cancelation extends CancelationService {
    private CancelationResponseHandler handler;

    /**
     * Constructor de la clase.
     * @param url
     * @param user
     * @param password
     * @param proxy
     * @param proxyPort
     */
    public Cancelation(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
        handler = new CancelationResponseHandler();
    }

    /**
     * Constructor de la clase.
     * @param url
     * @param token
     * @param proxy
     * @param proxyPort
     */
    public Cancelation(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
        handler = new CancelationResponseHandler();
    }

    /**
     * Método de cancelación enviando datos de CSD.
     * @param cer
     * @param key
     * @param rfc
     * @param password
     * @param uuid
     * @return CancelationResponse
     * @see CancelationResponse
     */
    @Override
    CancelationResponse cancelar(String cer, String key, String rfc, String password, String uuid) {
        try {
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestCSD(cer, key,
                    password, uuid);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestCancelar(cer, key, rfc, password, uuid);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), "cfdi33/cancel/csd", headers, jsonBody, config,
                    CancelationResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de cancelación enviando datos de PFX.
     * @param pfx
     * @param rfc
     * @param password
     * @param uuid
     * @return CancelationResponse
     * @see CancelationResponse
     */
    @Override
    CancelationResponse cancelar(String pfx, String rfc, String password, String uuid) {
        try {
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestPFX(pfx, password,
                    uuid);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestCancelar(pfx, rfc, password, uuid);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), "cfdi33/cancel/pfx", headers, jsonBody, config,
                    CancelationResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de cancelación enviando RFC emisor y UUID.
     * <p>
     * <b>Nota:</b> Es necesario tener configurado un Certificado
     * para el RFC emisor en su cuenta de SW.
     * @param rfc
     * @param uuid
     * @return CancelationResponse
     * @see CancelationResponse
     */
    @Override
    CancelationResponse cancelar(String rfc, String uuid) {
        try {
            String path = String.format("cfdi33/cancel/%s/%s", rfc, uuid);
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken()).validateRequestUUID(rfc, uuid);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrl(), path, headers, null, config, CancelationResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Método de cancelación enviando un XML de cancelación sellado.
     * <b>Nota:</b> El XML de cancelación no es igual a un CFDI.
     * @param xmlCancelation
     * @return CancelationResponse
     */
    @Override
    CancelationResponse cancelar(String xmlCancelation) {
        try {
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken())
                    .validateRequestXML(xmlCancelation);
            Map<String, String> headers = getHeaders();
            String boundary = UUID.randomUUID().toString();
            String xml = String.format(
                    "--%s\r\nContent-Disposition: form-data; name=xml;"
                    + "filename=xml\r\nContent-Type: application/xml\r\n\r\n%s\r\n--%s--",
                    boundary, xmlCancelation, boundary);
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPMultipart(getUrl(), "cfdi33/cancel/xml", headers, xml, config,
                    CancelationResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

}
