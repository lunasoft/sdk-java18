package mx.com.sw.services.Validate;
import java.util.Map;
import java.util.UUID;

import org.apache.http.client.config.RequestConfig;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.Validate.responses.ValidateResponse;
import mx.com.sw.services.Validate.responses.ValidateResponseHandler;

public class Validate extends ValidateService{
    private ValidateResponseHandler handler;

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public Validate(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        handler = new ValidateResponseHandler();
    }

    /** Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public Validate(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        handler = new ValidateResponseHandler();
    }

    /**
     * Método de validacion enviando un XML.
     * @param xmlcontent String xml.
     * @return ValidateResponse
     */
    public ValidateResponse ValidateXML(String xmlcontent){
        try {
            Map<String, String> headers = getHeaders();
            String boundary = UUID.randomUUID().toString();
            String xml = String.format(
                    "--%s\r\nContent-Disposition: form-data; name=xml;"
                    + "filename=xml\r\nContent-Type: application/xml\r\n\r\n%s\r\n--%s--",
                    boundary, xmlcontent, boundary);
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPMultipart(getUrl(), "validate/cfdi33/", headers, xml, config,
                    ValidateResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
}
