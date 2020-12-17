package mx.com.sw.services.account.balance;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;

/**
 * AccountBalanceService - Servicio para implementación de consulta de saldos.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-14
 */
public abstract class AccountBalanceService extends Services {

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected AccountBalanceService(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected AccountBalanceService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Consulta el saldo de la cuenta configurada.
     * @return {@link AccountBalanceResponse}
     * @throws ServicesException exception en caso de error.
     */
    public abstract AccountBalanceResponse getBalance() throws ServicesException;

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * @throws ServicesException exception en caso de error.
     * @return {@link Map}
     */
    protected Map<String, String> getHeaders() throws ServicesException {
        this.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
