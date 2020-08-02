package mx.com.sw.services.issue;

import mx.com.sw.services.stamp.BaseStampV4;

/**
 * <h1>IssueV4</h1> Está clase se utiliza para uso de servicios
 * issue, los cuales se envia un CFDI (sin sellar) en formato XML.
 * Es necesario contar con certificados vigentes configurados en su cuenta
 * de SW, de esta manera se realiza el sellado del documento generado.
 * <p>
 * <b>Nota:</b> A diferencia de la clase Issue, en está clase al hacer
 * timbrado de un documento se solicita el email de su cliente, el cual
 * estará recibiendo la copia del XML timbrado y el PDF del mismo.
 * Es útil por ejemplo para timbrado de nómina y hacerles llegar el CFDI
 * y PDF a sus trabajadores.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class IssueV4 extends BaseStampV4 {

    /**
     * Constructor de la clase.
     * @param url
     * @param token
     * @param proxy
     * @param proxyPort
     */
    public IssueV4(String url, String token, String proxy, int proxyPort) {
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
    public IssueV4(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, "issue", proxy, proxyPort);
    }
}
