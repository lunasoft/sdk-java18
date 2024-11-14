package mx.com.sw.services.stamp;

import java.util.List;
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
 * BaseStampV4 Está clase se utiliza como base para los
 * servicios de timbrado XML (Version 4).
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public abstract class BaseStampV4 extends StampService {
    private String operation;
    private String formatPath;

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
    protected BaseStampV4(String url, String user, String password, String operation, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        this.operation = operation;
        this.formatPath = "v4/cfdi33/%s/%s/%s";
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param operation operacion a realizar.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected BaseStampV4(String url, String token, String operation, String proxy,
        int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        this.operation = operation;
        this.formatPath = "v4/cfdi33/%s/%s/%s";
    }

    /**
     * Timbra un documento CFDI versión XML
     * utilizando la versión 1 de timbrado.
     * @param xml String xml.
     * @param isBase64 indica si es base64.
     * @param emails List<String> emails receptor(max 5).
     * @param customId String identificador único asignado al comprobante.
     * @param isPdf boolean confirma la generación de un PDF.
     * @return StampResponseV1
     * @see StampResponseV1
     * @throws ServicesException exception en caso de error.
     */
    public StampResponseV1 timbrarV1(String xml, List<String> emails, String customId, boolean isPdf, boolean isBase64) throws ServicesException {
        StampResponseHandlerV1 handler = new StampResponseHandlerV1();
        try{
            Map<String, String> headers = getHeaders(emails,customId, isPdf);
            String format = isBase64 ? "b64" : "";
            String path = String.format(formatPath, operation, "v1", format);
            return super.timbrar(xml, path, headers, handler, StampResponseV1.class);
        }catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Timbra un documento CFDI versión XML
     * utilizando la versión 2 de timbrado.
     * @param xml String xml.
     * @param isBase64 indica si es base64.
     * @param emails List<String> emails receptor(max 5).
     * @param customId String identificador único asignado al comprobante.
     * @param isPdf boolean confirma la generación de un PDF.
     * @return StampResponseV2
     * @see StampResponseV2
     * @throws ServicesException exception en caso de error.
     */
    public StampResponseV2 timbrarV2(String xml, List<String> emails, String customId,boolean isPdf, boolean isBase64) throws ServicesException {
        StampResponseHandlerV2 handler = new StampResponseHandlerV2();
        try{
            Map<String, String> headers = getHeaders(emails,customId, isPdf);
            String format = isBase64 ? "b64" : "";
            String path = String.format(formatPath, operation, "v2", format);
            return super.timbrar(xml, path, headers, handler, StampResponseV2.class);
        }catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Timbra un documento CFDI versión XML
     * utilizando la versión 3 de timbrado.
     * @param xml String xml.
     * @param isBase64 indica si es base64.
     * @param emails List<String> emails receptor(max 5).
     * @param customId String identificador único asignado al comprobante.
     * @param isPdf boolean confirma la generación de un PDF.
     * @return StampResponseV3
     * @see StampResponseV3
     * @throws ServicesException exception en caso de error.
     */
    public StampResponseV3 timbrarV3(String xml, List<String> emails, String customId, boolean isPdf, boolean isBase64) throws ServicesException {
        StampResponseHandlerV3 handler = new StampResponseHandlerV3();
        try{
            Map<String, String> headers = getHeaders(emails,customId, isPdf);
            String format = isBase64 ? "b64" : "";
            String path = String.format(formatPath, operation, "v3", format);
            return super.timbrar(xml, path, headers, handler, StampResponseV3.class);
        }catch (ServicesException e) {
            return handler.handleException(e);
        }
    }

    /**
     * Timbra un documento CFDI versión XML
     * utilizando la versión 4 de timbrado.
     * @param xml String xml.
     * @param isBase64 indica si es base64.
     * @param emails List<String> emails receptor(max 5).
     * @param customId String identificador único asignado al comprobante.
     * @param isPdf boolean confirma la generación de un PDF.
     * @return StampResponseV4
     * @see StampResponseV4
     * @throws ServicesException exception en caso de error.
     */
    public StampResponseV4 timbrarV4(String xml, List<String> emails, String customId, boolean isPdf, boolean isBase64) throws ServicesException {
        StampResponseHandlerV4 handler = new StampResponseHandlerV4();
        try{
            Map<String, String> headers = getHeaders(emails,customId, isPdf);
            String format = isBase64 ? "b64" : "";
            String path = String.format(formatPath, operation, "v4", format);
            return super.timbrar(xml, path, headers, handler, StampResponseV4.class);
        }catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
}
