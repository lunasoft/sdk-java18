package mx.com.sw.services.issue;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.stamp.BaseStampV2;

/**
 * IssueV2 Está clase se utiliza para uso de servicios
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
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public IssueV2(String url, String token, String proxy, int proxyPort) throws ServicesException {
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
    public IssueV2(String url, String user, String password, String proxy, int proxyPort) throws ServicesException {
        super(url, user, password, "issue", proxy, proxyPort);
    }
}
