package mx.com.sw.services.account.info;

import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;
import mx.com.sw.services.account.info.responses.AccountInfoResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
 * Servicio de Consulta de Información de cuenta. Clase que permite obtener el saldo de la
 * cuenta de SW.
 * <p>
 * Ejemplo de uso:
 * <pre>
 * AccountInfo account = new AccountInfo("https://api.test.sw.com.mx", "token SW", null, 0);
 * AccountInfoResponse res = account.getInfo();
 * if("success".equalsIgnoreCase(res.getStatus()){
 *    System.out.println(res.getData().getStamps());
 *    System.out.println(res.getData().getIdUsuario());
 *    System.out.println(res.getData().getIdCliente());
 *    System.out.println(res.getData().isUnlimited());
 *    System.out.println(res.getData().getNombre());
 *    System.out.println(res.getData().getRfc());
 *    System.out.println(res.getData().getUsername());
 *    System.out.println(res.getData().getEmail());
 *    System.out.println(res.getData().isActivo());
 *    System.out.println(res.getData().getRegisteredDate());
 *    System.out.println(res.getData().getTokenAccess());
 * } else{ // ocurrió un error y en los mensajes podría haber información últil acerca del error.
 *   System.out.println(res.getMessage());
 *   System.out.println(res.getMessageDetail());
 * }
 * </pre>
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-17
 */
public class AccountInfo extends AccountInfoService {
    private AccountInfoResponseHandler handler;

    /**
     * Constructor de la clase.
     * @param url       url base de la API
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    private AccountInfo(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        handler = new AccountInfoResponseHandler();
    }

    /**
     * Constructor de la clase.
     * @param url       url base de la API
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public AccountInfo(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        handler = new AccountInfoResponseHandler();
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public AccountInfoResponse getInfo() throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        return handler.getHTTP(getUrl(), "management/api/users/info", headers, config, AccountInfoResponse.class);
    }
}
