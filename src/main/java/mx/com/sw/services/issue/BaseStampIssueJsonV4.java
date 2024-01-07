package mx.com.sw.services.issue;

import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV1;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV2;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV3;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

/**
 * BaseStampIssueJsonV4 Está clase se utiliza como base para los
 * servicios issue JSON versión 4.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class BaseStampIssueJsonV4 extends IssueJsonService {
    private String formatPath;
    private String operation;

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param operation operacion a realizar.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected BaseStampIssueJsonV4(String url, String token, String operation, String proxy,
        int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        this.formatPath = "v4/cfdi33/%s/%s";
        this.operation = operation;
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param operation operacion a realizar.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected BaseStampIssueJsonV4(String url, String user, String password, String operation, String proxy,
            int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        this.formatPath = "v4/cfdi33/%s/%s";
        this.operation = operation;
    }

    /**
     * Obtiene los headers para su funcionamiento.
     * @param emails String emails receptor(max 5).
     * @param customId String identificador único asignado al comprobante.
     * @param extra boolean confirma la generación de un PDF.
     * @return Map String, String
     * @throws ServicesException exception en caso de error.
     */
    protected Map<String, String> getHeaders(String emails, String customId, boolean extra) throws ServicesException {
        Map<String, String> headers = this.getHeaders();

        headers.put("Authorization", "bearer " + this.getToken());
        if (emails != null && validateEmails(emails)) {
            headers.put("email", emails);
        }
        if (customId != null) {
            validateCustomId(customId);
            headers.put("customid", customId);
        }
        if(extra){
            headers.put("extra", "pdf");
        }
        return headers;
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la versión 1 de timbrado.
     * @param json String json.
     * @param emails String emails receptor.(max 5).
     * @param customId String identificador único asignado al comprobante.
     * @param extra boolean confirma la generación de un PDF.
     * @return StampResponseV1
     * @see StampResponseV1
     * @throws ServicesException exception en caso de error.
     */
    public StampResponseV1 timbrarV1(String json, String emails, String customId, boolean extra) throws ServicesException {
        StampResponseHandlerV1 handler = new StampResponseHandlerV1();
        try{
            Map<String, String> headers = this.getHeaders(emails, customId, extra);
            return super.timbrar(json, headers, formatPath, operation, "v1", handler, StampResponseV1.class);
        }catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la versión 2 de timbrado.
     * @param json String json.
     * @param emails String emails receptor.(max 5).
     * @param customId String identificador único asignado al comprobante.
     * @param extra boolean confirma la generación de un PDF.
     * @return StampResponseV2
     * @see StampResponseV2
     * @throws ServicesException exception en caso de error.
     */
    public StampResponseV2 timbrarV2(String json, String emails, String customId, boolean extra) throws ServicesException {
        StampResponseHandlerV2 handler = new StampResponseHandlerV2();
        try{
            Map<String, String> headers = this.getHeaders(emails, customId, extra);
            return super.timbrar(json, headers, formatPath, operation, "v2", handler, StampResponseV2.class);
        }catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la versión 3 de timbrado.
     * @param json String json.
     * @param emails String emails receptor.(max 5).
     * @param customId String identificador único asignado al comprobante.
     * @param extra boolean confirma la generación de un PDF.
     * @return StampResponseV3
     * @see StampResponseV3
     * @throws ServicesException exception en caso de error.
     */
    public StampResponseV3 timbrarV3(String json, String emails, String customId, boolean extra) throws ServicesException {
        StampResponseHandlerV3 handler = new StampResponseHandlerV3();
        try{
            Map<String, String> headers = this.getHeaders(emails, customId, extra);
            return super.timbrar(json, headers, formatPath, operation, "v3", handler, StampResponseV3.class);
        }catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la versión 4 de timbrado.
     * @param json String json.
     * @param emails String emails receptor.(max 5).
     * @param customId String identificador único asignado al comprobante.
     * @param extra boolean confirma la generación de un PDF.
     * @return StampResponseV4
     * @see StampResponseV4
     * @throws ServicesException exception en caso de error.
     */
    public StampResponseV4 timbrarV4(String json, String emails, String customId, boolean extra) throws ServicesException {
        StampResponseHandlerV4 handler = new StampResponseHandlerV4();
        try{
            Map<String, String> headers = this.getHeaders(emails, customId, extra);
            return super.timbrar(json, headers, formatPath, operation, "v4", handler, StampResponseV4.class);
        }catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
}
