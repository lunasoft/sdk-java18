package mx.com.sw.services.issue;

/**
 * <h1>IssueJsonV4</h1> Está clase se utiliza para uso de servicios
 * issue JSON, los cuales se envia una representación de CFDI (sin sellar)
 * en formato JSON.
 * Es necesario contar con certificados vigentes configurados en su cuenta
 * de SW, de esta manera se realiza el sellado del documento generado.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class IssueJsonV4 extends BaseStampIssueJsonV4 {

    /**
     * Constructor de la clase.
     * @param url      url base de la API
     * @param token     token de SW
     * @param proxy    IP o Host de proxy (null si no se usa)
     * @param proxyPort    número de puerto del servidor proxy (0 si no se usa)
     */
    public IssueJsonV4(String url, String token, String proxy, int proxyPort) {
        super(url, token, "issue/json", proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * @param url      url base de la API
     * @param usuario     usuario de SW
     * @param password     password de la cuenta
     * @param proxy    IP o Host de proxy (null si no se usa)
     * @param proxyPort    número de puerto del servidor proxy (0 si no se usa)
     */
    public IssueJsonV4(String url, String usuario, String password, String proxy, int proxyPort) {
        super(url, usuario, password, "issue/json", proxy, proxyPort);
    }
}
