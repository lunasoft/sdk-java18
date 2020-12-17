package mx.com.sw.services.pdf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.Services;
import mx.com.sw.services.pdf.requests.PdfRequest;
import mx.com.sw.services.pdf.responses.PdfResponse;
import mx.com.sw.services.pdf.responses.PdfResponseHandler;

/**
 * PdfService servicio de generacion PDF.
 * @author Manuel Castillo
 * @version 0.0.0.1
 * @since 2020-12-15
 */
public abstract class PdfService extends Services {

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
    protected PdfService(String url, String urlapi, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, urlapi, user, password, proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected PdfService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Obtiene los headers minímos para su funcionamiento.
     * @return Map String, String
     * @throws ServicesException exception en caso de error.
     */
    protected Map<String, String> getHeaders() throws ServicesException {
        super.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }

    /**
     * Solicita el documento impreso dada la configuracion.
     * @param templateid String id del template de PDF.
     * @param xmlcontent String CFDI formato XML.
     * @param logo String logo de emisor en b64.
     * @param extras Map String String con los parametros extras a mostrar en PDF.
     * @param handler PdfResponseHandler Object handler.
     * @return String con formato json para la solicitud al ws
     */
    protected String requestPDF(String templateid, String xmlcontent, String logo,
        Map<String, String> extras, PdfResponseHandler handler) {
        PdfRequest objectRequest = new PdfRequest(xmlcontent);
        if (!GeneralHelpers.stringEmptyOrNull(logo)) {
            objectRequest.setLogo(logo);
        }
        if (!GeneralHelpers.stringEmptyOrNull(templateid)) {
            objectRequest.setTemplateId(templateid);
        }
        if (extras != null && extras.size() > 0) {
            objectRequest.setExtras(extras);
        }
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(objectRequest);
    }

    abstract PdfResponse getPdf(String xmlcontent);

    abstract PdfResponse getPdf(String templateid, String xmlcontent);

    abstract PdfResponse getPdf(String xmlcontent, Map<String, String> extras);

    abstract PdfResponse getPdf(String templateid, String xmlcontent, String logo);

    abstract PdfResponse getPdf(String templateid, String xmlcontent, Map<String, String> extras);

    abstract PdfResponse getPdf(String templateid, String xmlcontent, String logo, Map<String, String> extras);

}
