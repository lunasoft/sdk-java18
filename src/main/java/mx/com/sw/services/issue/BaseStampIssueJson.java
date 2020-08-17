package mx.com.sw.services.issue;

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
 * BaseStampIssueJson Está clase se utiliza como base para los
 * servicios issue JSON.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class BaseStampIssueJson extends IssueJsonService {
    private String formatPath;
    private String operation;

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param operation operacion a realizar.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    protected BaseStampIssueJson(String url, String token, String operation, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
        this.formatPath = "v3/cfdi33/%s/%s";
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
    */
    protected BaseStampIssueJson(String url, String user, String password, String operation, String proxy,
            int proxyPort) {
        super(url, user, password, proxy, proxyPort);
        this.formatPath = "v3/cfdi33/%s/%s";
        this.operation = operation;
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la versión 1 de timbrado.
     * @param json String json.
     * @return StampResponseV1
     * @see StampResponseV1
     */
    public StampResponseV1 timbrarV1(String json) {
        StampResponseHandlerV1 handler = new StampResponseHandlerV1();
        Map<String, String> headers = this.getHeaders();
        return super.timbrar(json, headers, formatPath, operation, "v1", handler, StampResponseV1.class);
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la versión 2 de timbrado.
     * @param json String json.
     * @return StampResponseV2
     * @see StampResponseV2
     */
    public StampResponseV2 timbrarV2(String json) {
        StampResponseHandlerV2 handler = new StampResponseHandlerV2();
        Map<String, String> headers = this.getHeaders();
        return super.timbrar(json, headers, formatPath, operation, "v2", handler, StampResponseV2.class);
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la versión 3 de timbrado.
     * @param json String json.
     * @return StampResponseV3
     * @see StampResponseV3
     */
    public StampResponseV3 timbrarV3(String json) {
        StampResponseHandlerV3 handler = new StampResponseHandlerV3();
        Map<String, String> headers = this.getHeaders();
        return super.timbrar(json, headers, formatPath, operation, "v3", handler, StampResponseV3.class);
    }

    /**
     * Timbra una representacion de CFDI en formato JSON
     * utilizando la versión 4 de timbrado.
     * @param json String json.
     * @return StampResponseV4
     * @see StampResponseV4
     */
    public StampResponseV4 timbrarV4(String json) {
        StampResponseHandlerV4 handler = new StampResponseHandlerV4();
        Map<String, String> headers = this.getHeaders();
        return super.timbrar(json, headers, formatPath, operation, "v4", handler, StampResponseV4.class);
    }

}
