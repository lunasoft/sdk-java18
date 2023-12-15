package mx.com.sw.services.resend;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.resend.response.ResendResponse;
import mx.com.sw.services.resend.response.ResendResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
 * Servicio que contiene un metodo para realizar el reenvio de correo de un comprobante timbrado.
 */
public class Resend extends ResendService {
    private ResendResponseHandler handler;

    /**
     * Constructor de la clase.
     * @param url       url base de la API
     * @param urlapi    url base de la API servicios
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public Resend(String url, String urlapi, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, urlapi, user, password, proxy, proxyPort);
        handler = new ResendResponseHandler();
    }

    /**
     * Constructor de la clase.
     * @param urlapi    url base de la API
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public Resend(String urlapi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlapi, token, proxy, proxyPort);
        handler = new ResendResponseHandler();
    }

    /**
     * Servicio que realiza el envio o reenvio de un xml a uno o más correos(max 5).
     * @param uuid    UUID del comprobante.
     * @param correo  Lista de correos.
     * @return ResendResponse.
     * @throws ServicesException
     */
    public ResendResponse ResendEmail(UUID uuid, List<String> correo) throws ServicesException {
        try {
            new ResendValidation(correo);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestResend(uuid, correo);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson(getUrlapi() == null ? getUrl() : getUrlapi(), "comprobante/resendemail",
                    headers, jsonBody,
                    config, ResendResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
}
