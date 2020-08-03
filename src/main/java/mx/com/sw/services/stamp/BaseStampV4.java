package mx.com.sw.services.stamp;

import java.util.Map;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV1;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV2;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV3;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

/**
 * <h1>BaseStampV4</h1> Está clase se utiliza como base para los
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
     * @param url
     * @param user
     * @param password
     * @param operation
     * @param proxy
     * @param proxyPort
     */
    protected BaseStampV4(String url, String user, String password, String operation, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
        this.operation = operation;
        this.formatPath = "v4/cfdi33/%s/%s/%s";
    }

    /**
     * Constructor de la clase.
     * @param url
     * @param token
     * @param operation
     * @param proxy
     * @param proxyPort
     */
    protected BaseStampV4(String url, String token, String operation, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
        this.operation = operation;
        this.formatPath = "v4/cfdi33/%s/%s/%s";
    }

    /**
     * Timbra un documento CFDI versión XML
     * utilizando la versión 1 de timbrado.
     * @param xml
     * @param isBase64
     * @return StampResponseV1
     * @see StampResponseV1
     */
    public StampResponseV1 timbrarV1(String xml, String email, boolean isBase64) {
        StampResponseHandlerV1 handler = new StampResponseHandlerV1();
        Map<String, String> headers = getHeaders();
        headers.put("email", email);
        String format = isBase64 ? "b64" : "";
        String path = String.format(formatPath, operation, "v1", format);
        return super.timbrar(xml, path, headers, handler, StampResponseV1.class);
    }

    /**
     * Timbra un documento CFDI versión XML
     * utilizando la versión 2 de timbrado.
     * @param xml
     * @param isBase64
     * @return StampResponseV2
     * @see StampResponseV2
     */
    public StampResponseV2 timbrarV2(String xml, String email, boolean isBase64) {
        StampResponseHandlerV2 handler = new StampResponseHandlerV2();
        Map<String, String> headers = getHeaders();
        headers.put("email", email);
        String format = isBase64 ? "b64" : "";
        String path = String.format(formatPath, operation, "v2", format);
        return super.timbrar(xml, path, headers, handler, StampResponseV2.class);
    }

    /**
     * Timbra un documento CFDI versión XML
     * utilizando la versión 3 de timbrado.
     * @param xml
     * @param isBase64
     * @return StampResponseV3
     * @see StampResponseV3
     */
    public StampResponseV3 timbrarV3(String xml, String email, boolean isBase64) {
        StampResponseHandlerV3 handler = new StampResponseHandlerV3();
        Map<String, String> headers = getHeaders();
        headers.put("email", email);
        String format = isBase64 ? "b64" : "";
        String path = String.format(formatPath, operation, "v3", format);
        return super.timbrar(xml, path, headers, handler, StampResponseV3.class);
    }

    /**
     * Timbra un documento CFDI versión XML
     * utilizando la versión 4 de timbrado.
     * @param xml
     * @param isBase64
     * @return StampResponseV4
     * @see StampResponseV4
     */
    public StampResponseV4 timbrarV4(String xml, String email, boolean isBase64) {
        StampResponseHandlerV4 handler = new StampResponseHandlerV4();
        Map<String, String> headers = getHeaders();
        headers.put("email", email);
        String format = isBase64 ? "b64" : "";
        String path = String.format(formatPath, operation, "v4", format);
        return super.timbrar(xml, path, headers, handler, StampResponseV4.class);
    }
}
