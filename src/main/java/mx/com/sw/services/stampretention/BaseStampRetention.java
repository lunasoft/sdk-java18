package mx.com.sw.services.stampretention;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.stampretention.responses.StampRetentionResponseHandlerV3;
import mx.com.sw.services.stampretention.responses.StampRetentionResponseV3;

/**
 * BaseStampRetention Está clase se utiliza como base para los
 * servicios de timbrado XML de retenciones.
 */
public abstract class BaseStampRetention extends StampRetentionService {
    private String operation;
    private String formatPath;

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param operation operacion a realizar.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected BaseStampRetention(String url, String token, String operation, String proxy,
        int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        this.operation = operation;
        this.formatPath = "retencion/%s/%s";
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
    protected BaseStampRetention(String url, String user, String password, String operation, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        this.operation = operation;
        this.formatPath = "retencion/%s/%s";
    }


    /**
     * Timbra un documento de retención versión XML
     * utilizando la versión 3 de timbrado.
     * @param xml String xml.
     * @return StampRetentionResponseV3
     * @see StampRetentionResponseV3
     * @throws ServicesException exception en caso de error.
     */
    public StampRetentionResponseV3 timbrarV3(String xml) throws ServicesException {
        StampRetentionResponseHandlerV3 handler = new StampRetentionResponseHandlerV3();
        String path = String.format(formatPath, operation, "v3");
        return super.timbrar(xml, path, getHeaders(), handler, StampRetentionResponseV3.class);
    }

} 