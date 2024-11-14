package mx.com.sw.services.account.balance;

import java.util.Map;
import java.util.UUID;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.EnumAccountBalance;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.account.balance.responses.AccountBalanceActionResponse;
import mx.com.sw.services.account.balance.responses.AccountBalanceActionResponseHandler;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
 * Servicio de Consulta y Administración de Saldo.
 * Proporciona métodos para consultar y administrar el saldo de usuarios.
 * Extiende la clase base AccountBalanceService.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-14
 */
public class AccountBalance extends AccountBalanceService {
    private static final String MANAGEMENT_API_BALANCE_PATH = "management/api/balance/";
    private static final String SERVICE_BALANCE_PATH = "account/balance";
    private final AccountBalanceResponseHandler handler;
    private final AccountBalanceActionResponseHandler handlerActions;

    /**
     * Constructor de la clase.
     * @param url       URL base del servicio.
     * @param user      Correo o usuario de SW.
     * @param password  Contraseña de SW.
     * @param proxy     IP o dominio de proxy (null si no se utiliza).
     * @param proxyPort Número de puerto de proxy (cualquier valor si proxy es null).
     * @throws ServicesException Excepción en caso de error.
     **/
    public AccountBalance(String url, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        handler = new AccountBalanceResponseHandler();
        handlerActions = new AccountBalanceActionResponseHandler();
    }

    /**
     * Constructor de la clase.
     * @param url       URL base del servicio.
     * @param urlApi    URL específica de la API.
     * @param user      Correo o usuario de SW.
     * @param password  Contraseña de SW.
     * @param proxy     IP o dominio de proxy (null si no se utiliza).
     * @param proxyPort Número de puerto de proxy (cualquier valor si proxy es null).
     * @throws ServicesException Excepción en caso de error.
     **/
    public AccountBalance(String url, String urlApi, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
        handler = new AccountBalanceResponseHandler();
        handlerActions = new AccountBalanceActionResponseHandler();
    }

    /**
     * Constructor de la clase.
     * @param urlApi    URL base de la API o servicio
     * @param token     Token infinito de SW.
     * @param proxy     IP o dominio de proxy (null si no se utiliza).
     * @param proxyPort Número de puerto de proxy (cualquier valor si proxy es null).
     * @throws ServicesException Excepción en caso de error.
     **/
    public AccountBalance(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
        handler = new AccountBalanceResponseHandler();
        handlerActions = new AccountBalanceActionResponseHandler();
    }

    /**
     * Realiza la distribución de timbres para un usuario específico.
     * @param idUser   ID del usuario.
     * @param stamps   Cantidad de timbres a distribuir.
     * @param action   Acción a realizar (EnumAccountBalance.Add o EnumAccountBalance.Remove).
     * @param comment  Comentario asociado a la operación.
     * @return Objeto AccountActionsData con la respuesta de la API.
     * @throws ServicesException Excepción en caso de error.
     */

    protected AccountBalanceActionResponse distributionStamps(UUID idUser, int stamps, EnumAccountBalance action,
            String comment) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        String jsonBody = this.requestAccount(comment);
        String path = MANAGEMENT_API_BALANCE_PATH + idUser.toString() + "/" + action.toString().toLowerCase() + "/"
                + stamps;
        return handlerActions.postHTTPJson(getUrlapi() == null ? getUrl() : getUrlapi(), path, headers, jsonBody,
                config,
                AccountBalanceActionResponse.class);
    }

    /**
     * Agrega timbres para un usuario específico.
     * @param idUser  ID del usuario.
     * @param stamps  Cantidad de timbres a agregar.
     * @param comment Comentario asociado a la operación.
     * @return Objeto AccountActionsData con la respuesta de la API.
     * @throws ServicesException Excepción en caso de error.
     */
    public AccountBalanceActionResponse addStamps(UUID idUser, int stamps, String comment) throws ServicesException {
        return distributionStamps(idUser, stamps, EnumAccountBalance.Add, comment);
    }

    /**
     * Elimina timbres para un usuario específico.
     * @param idUser  ID del usuario.
     * @param stamps  Cantidad de timbres a eliminar.
     * @param comment Comentario asociado a la operación.
     * @return Objeto AccountActionsData con la respuesta de la API.
     * @throws ServicesException Excepción en caso de error.
     */
    public AccountBalanceActionResponse removeStamps(UUID idUser, int stamps, String comment) throws ServicesException {
        return distributionStamps(idUser, stamps, EnumAccountBalance.Remove, comment);
    }

    /**
     * Obtiene el saldo de un usuario por ID.
     * @param idUser ID del usuario.
     * @return Objeto AccountBalanceResponse con la respuesta de la API.
     * @throws ServicesException Excepción en caso de error.
     */
    public AccountBalanceResponse getBalanceById(UUID idUser) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());

        String path = String.format(MANAGEMENT_API_BALANCE_PATH, idUser.toString());
        return handler.getHTTP(getUrlapi() == null ? getUrl() : getUrlapi(), path, headers, config,
                AccountBalanceResponse.class);
    }

    /**
     * Obtiene el saldo de un usuario asociado al token usado para la consulta.
     * @return Objeto AccountBalanceResponse con la respuesta del servicio
     * @throws ServicesException Excepción en caso de error.
     */

    @Override
    public AccountBalanceResponse getBalance() throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        return handler.getHTTP(getUrl(), SERVICE_BALANCE_PATH, headers, config, AccountBalanceResponse.class);
    }
}
