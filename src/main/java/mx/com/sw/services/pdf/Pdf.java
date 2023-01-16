package mx.com.sw.services.pdf;

import java.util.Map;
import java.util.UUID;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.pdf.responses.PdfResponse;
import mx.com.sw.services.pdf.responses.PdfResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
 * Pdf Clase para consumir servicio de generacion PDF.
 * @author Manuel Castillo
 * @version 0.0.0.1
 * @since 2020-12-15
 */
public class Pdf extends PdfService {
    private PdfResponseHandler handler;

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param urlapi url base de la API servicios
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public Pdf(String url, String urlapi, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, urlapi, user, password, proxy, proxyPort);
        handler = new PdfResponseHandler();
    }

    /*
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public Pdf(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        handler = new PdfResponseHandler();
    }

    /**
     * Solicita formato impreso.
     * @param xmlcontent String CFDI formato XML.
     * @return PdfResponse
     * @see PdfResponse
     */
    @Override
    public PdfResponse getPdf(String xmlcontent) {
        return getPdf(null, xmlcontent, null, null);
    }

    /**
     * Solicita formato impreso, con CFDI + templateid.
     * @param templateid String id del template de PDF.
     * @param xmlcontent String CFDI formato XML.
     * @return PdfResponse
     * @see PdfResponse
     */
    @Override
    public PdfResponse getPdf(String templateid, String xmlcontent) {
        return getPdf(templateid, xmlcontent, null, null);
    }

    /**
     * Solicita formato impreso, con CFDI + datos extra.
     * @param xmlcontent String CFDI formato XML.
     * @param extras Map String String con los parametros extras a mostrar en PDF.
     * @return PdfResponse
     * @see PdfResponse
     */
    @Override
    public PdfResponse getPdf(String xmlcontent, Map<String, String> extras) {
        return getPdf(null, xmlcontent, null, extras);
    }

    /**
     * Solicita formato impreso, con CFDI + templateid + logo.
     * @param templateid String id del template de PDF.
     * @param xmlcontent String CFDI formato XML.
     * @param logo String logo de emisor en b64.
     * @return PdfResponse
     * @see PdfResponse
     */
    @Override
    public PdfResponse getPdf(String templateid, String xmlcontent, String logo) {
        return getPdf(templateid, xmlcontent, logo, null);
    }

    /**
     * Solicita formato impreso, con CFDI + templateid + datos extra.
     * @param templateid String id del template de PDF.
     * @param xmlcontent String CFDI formato XML.
     * @param extras Map String String con los parametros extras a mostrar en PDF.
     * @return PdfResponse
     * @see PdfResponse
     */
    @Override
    public PdfResponse getPdf(String templateid, String xmlcontent, Map<String, String> extras) {
        return getPdf(templateid, xmlcontent, null, extras);
    }

    /**
     * Solicita formato impreso, todos los parametros posibles.
     * @param templateid String id del template de PDF.
     * @param xmlcontent String CFDI formato XML.
     * @param logo String logo de emisor en b64.
     * @param extras Map String String con los parametros extras a mostrar en PDF.
     * @return PdfResponse
     * @see PdfResponse
     */
    @Override
    public PdfResponse getPdf(String templateid, String xmlcontent, String logo, Map<String, String> extras) {
        try {
            new PdfValidation().validateRequestPdf(xmlcontent, logo);
            Map<String, String> headers = getHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.requestPDF(templateid, xmlcontent, logo, extras, handler);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            String urlService = GeneralHelpers.stringEmptyOrNull(getUrlapi()) ? getUrl() : getUrlapi();
            return handler.postHTTPJson(urlService, "pdf/v1/api/GeneratePdf", headers, jsonBody, config,
                PdfResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
    /**
     * Metodo para el consumo de la regeneracion de PDF 
     * @param uuid String uuid.
     * @return PdfResponse
     * @see PdfResponse
     */
    public PdfResponse regeneratePdf(UUID uuid){
        try {
            Map<String, String> headers = getHeaders();
            String path = String.format("pdf/v1/api/RegeneratePdf/%s",uuid);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            String urlService = GeneralHelpers.stringEmptyOrNull(getUrlapi()) ? getUrl() : getUrlapi();
            PdfResponse response = handler.postHTTPJson(urlService, path ,headers, null, config,
            PdfResponse.class);
            if(response.getMessage().equals("Solicitud se proceso correctamente.")){
                response.setStatus("Success");
            }
            else{
                response.setStatus("Error");
            }
            return response;
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
}
