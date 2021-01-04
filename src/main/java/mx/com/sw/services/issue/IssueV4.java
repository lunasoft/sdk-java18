package mx.com.sw.services.issue;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.stamp.BaseStampV4;

/**
 * IssueV4 Está clase se utiliza para uso de servicios
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
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public IssueV4(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, "issue", proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public IssueV4(String url, String user, String password, String proxy, int proxyPort) throws ServicesException {
        super(url, user, password, "issue", proxy, proxyPort);
    }
}
