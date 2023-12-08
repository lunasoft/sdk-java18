package mx.com.sw.services.csd;

import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.csd.responses.CsdResponse;
import mx.com.sw.services.csd.responses.CsdDataResponse;
import mx.com.sw.services.csd.responses.CsdListDataResponse;
import mx.com.sw.services.csd.responses.CsdListDataResponseHandler;
import mx.com.sw.services.csd.responses.CsdDataResponseHandler;
import mx.com.sw.services.csd.responses.CsdResponseHandler;
import org.apache.http.client.config.RequestConfig;

public class CsdUtils extends CsdService{

    /**
     * Constructor de la clase.
     * 
     * @param url       url Services
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public CsdUtils(String url, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * 
     * @param url       url Services
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public CsdUtils(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Servicio que realiza la carga de un CSD.
     * 
     * @param b64Cer Certificado CSD en formato B64.
     * @param b64Key Certificado Key en formato B64.
     * @param password Contraseña del certificado.
     * @return CsdResponse.
     * @throws ServicesException
     */
    public CsdResponse UploadCsd(String b64Cer, String b64Key, String password) throws ServicesException {
        CsdResponseHandler handler = new CsdResponseHandler();
        try {
            new CsdValidation().validateRequestCsd(b64Cer, b64Key, password);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestCsd(b64Cer, b64Key, password);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.postHTTPJson( getUrl(), "certificates/save",
                    headers, jsonBody,
                    config, CsdResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

     /**
     * Servicio que realiza la eliminación de un certificado.
     * 
     * @param noCertificado Número de certificado.
     * @return CsdResponse.
     * @throws ServicesException
     */
    public CsdResponse DeleteCsd(String noCertificado)throws ServicesException {
        CsdResponseHandler handler = new CsdResponseHandler();
        try {
            String path = String.format("certificates/%s", noCertificado);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.deleteHTTP(getUrl(), path,
                    headers,
                    config, CsdResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

     /**
     * Servicio que realiza la obtención de todos los certificados cargados.
     * 
     * @return CsdResponse.
     * @throws ServicesException
     */
    public CsdListDataResponse GetAllCsd()throws ServicesException {
        CsdListDataResponseHandler handler = new CsdListDataResponseHandler();
        try {
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.getHTTP(getUrl(), "certificates", 
                    headers, 
                    config, CsdListDataResponse.class);    
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
    /**
     * Servicio que realiza la obtención de un certificado por número de certificado
     * 
     * @param noCertificado Número de certificado.
     * @return CsdResponse.
     * @throws ServicesException
     */
    public CsdDataResponse GetCsd(String noCertificado)throws ServicesException {
        CsdDataResponseHandler handler = new CsdDataResponseHandler();
        try {
            String path = String.format("certificates/%s", noCertificado);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.getHTTP(getUrl(), path, 
                        headers, 
                        config, CsdDataResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
    /**
     * Servicio que realiza la obtención de un certificado por RFC
     * 
     * @param rfc RFC del certificado.
     * @return CsdResponse.
     * @throws ServicesException
     */
    public CsdListDataResponse GetCsdByRfc(String rfc)throws ServicesException {
        CsdListDataResponseHandler handler = new CsdListDataResponseHandler();
        try {
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.getHTTP(getUrl(), String.format("certificates/rfc/%s", rfc), 
                        headers, 
                        config, CsdListDataResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
}
