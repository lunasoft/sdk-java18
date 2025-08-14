package mx.com.sw.services.cancelationretention;

import java.util.Map;
import java.util.UUID;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.cancelationretention.responses.CancelationRetentionResponse;
import mx.com.sw.services.cancelationretention.responses.CancelationRetentionResponseHandler;

/**
 * Servicios de cancelación de retenciones.
 */
public class CancelationRetention extends CancelationRetentionService {
    private CancelationRetentionResponseHandler handler;

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
        handler = new CancelationRetentionResponseHandler();
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
        handler = new CancelationRetentionResponseHandler();
    }

    /**
     * Método de cancelación de retención enviando un XML de cancelación sellado.
     * <b>Nota:</b> El XML de cancelación no es igual a un CFDI de retención.
     * @param xmlCancelation String xml de cancelación.
     * @return CancelationRetentionResponse
     */
    @Override
    public CancelationRetentionResponse cancelar(String xmlCancelation) {
        try {
            new CancelationRetentionValidation(getUrl(), getUser(), getPassword(), getToken())
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
                    CancelationRetentionResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
} 