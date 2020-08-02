package mx.com.sw.services.issue;

import mx.com.sw.services.stamp.BaseStampV2;

/**
 * <h1>IssueV2</h1> Está clase se utiliza para uso de servicios
 * issue, los cuales se envia un CFDI (sin sellar) en formato XML.
 * Es necesario contar con certificados vigentes configurados en su cuenta
 * de SW, de esta manera se realiza el sellado del documento generado.
 * <p>
 * <b>Nota:</b> A diferencia de la clase Issue, en está clase al hacer
 * timbrado de un documento repetido, este será incluído en la respuesta y
 * no solo obtendrá el error "307. Timbre duplicado.".
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class IssueV2 extends BaseStampV2 {

    /**
     * Constructor de la clase.
     * @param url
     * @param token
     * @param proxy
     * @param proxyPort
     */
    public IssueV2(String url, String token, String proxy, int proxyPort) {
        super(url, token, "issue", proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * @param url
     * @param user
     * @param password
     * @param proxy
     * @param proxyPort
     */
    public IssueV2(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, "issue", proxy, proxyPort);
    }
}
