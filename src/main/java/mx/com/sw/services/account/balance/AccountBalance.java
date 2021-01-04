package mx.com.sw.services.account.balance;

import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
* Servicio de Consulta de Saldo.
* Clase que permite obtener el saldo de la cuenta de SW.
* <p>
* Ejemplo de uso:
* <pre>
* AccountBalance account = new AccountBalance("http://services.test.sw.com.mx", "demo", "123456789", null, 0);
* AccountBalanceResponse res = account.getBalance();
* if("success".equalsIgnoreCase(res.getStatus()){
*    System.out.println(res.getData().getSaldoTimbres());
*    System.out.println(res.getData().getTimbresAsignados());
*    System.out.println(res.getData().getTimbresUtilizados());
*    System.out.println(res.getData().isUnlimited());
* } else{ // ocurrió un error y en los mensajes podría haber información últil acerca del error.
*   System.out.println(res.getMessage());
*   System.out.println(res.getMessageDetail());
* }
* </pre>
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-14
*/
public class AccountBalance extends AccountBalanceService {
    private AccountBalanceResponseHandler handler;

    /**
     * Constructor de la clase.
     * @param url       url base de la API
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public AccountBalance(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        handler = new AccountBalanceResponseHandler();
    }

    /**
     * Constructor de la clase.
     * @param url       url base de la API
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public AccountBalance(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
        handler = new AccountBalanceResponseHandler();
    }

    /**
     * @throws ServicesException exception en caso de error.
     * @return AccountBalanceResponse
     */
    @Override
    public AccountBalanceResponse getBalance() throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        return handler.getHTTP(getUrl(), "account/balance", headers, config, AccountBalanceResponse.class);
    }

}
