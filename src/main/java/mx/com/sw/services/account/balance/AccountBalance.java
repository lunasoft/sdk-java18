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
 * Servicio para consultar y administrar el saldo.
 */
public class AccountBalance extends AccountBalanceService {
    
    // Rutas de API para operaciones de saldo.
    private static final String MANAGEMENT_API_BALANCE_PATH = "management/v2/api/dealers/users/";
    private static final String SERVICE_BALANCE_PATH = "management/v2/api/users/balance";

    // Manejadores de respuesta para consultas y acciones.
    private final AccountBalanceResponseHandler handler;
    private final AccountBalanceActionResponseHandler handlerActions;

    /**
     * Constructor que inicializa el servicio con usuario y proxy.
     */
    public AccountBalance(String url, String user, String password, String proxy, int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
        handler = new AccountBalanceResponseHandler();
        handlerActions = new AccountBalanceActionResponseHandler();
    }

    /**
     * Constructor que inicializa el servicio con API específica y proxy.
     */
    public AccountBalance(String url, String urlApi, String user, String password, String proxy, int proxyPort) throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
        handler = new AccountBalanceResponseHandler();
        handlerActions = new AccountBalanceActionResponseHandler();
    }

    /**
     * Constructor que inicializa el servicio con token y proxy.
     */
    public AccountBalance(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
        handler = new AccountBalanceResponseHandler();
        handlerActions = new AccountBalanceActionResponseHandler();
    }

    /**
     * Distribuye timbres entre usuarios según la acción dada.
     */
    protected AccountBalanceActionResponse distributionStamps(UUID idUser, int stamps, EnumAccountBalance action, String comment) throws ServicesException {
        Map<String, String> headers = getHeaders();  // Obtener encabezados.
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());  // Configurar proxy.
        String jsonBody = this.requestAccount(stamps, comment);  // Preparar cuerpo JSON.
        String path = MANAGEMENT_API_BALANCE_PATH + idUser.toString() + "/stamps";  // Construir ruta.

        // Ejecutar acción según el tipo.
        if (action == EnumAccountBalance.Add) {
            return handlerActions.postHTTPJson(
                    getUrlapi() == null ? getUrl() : getUrlapi(),
                    path, headers, jsonBody, config,
                    AccountBalanceActionResponse.class);
        } else if (action == EnumAccountBalance.Remove) {
            return handlerActions.deleteHTTPJson(
                    getUrlapi() == null ? getUrl() : getUrlapi(),
                    path, headers, jsonBody, config,
                    AccountBalanceActionResponse.class);
        } else {
            throw new IllegalArgumentException("Acción no soportada: " + action);
        }
    }

    /**
     * Agrega timbres para un usuario.
     */
    public AccountBalanceActionResponse addStamps(UUID idUser, int stamps, String comment) throws ServicesException {
        return distributionStamps(idUser, stamps, EnumAccountBalance.Add, comment);
    }

    /**
     * Elimina timbres para un usuario.
     */
    public AccountBalanceActionResponse removeStamps(UUID idUser, int stamps, String comment) throws ServicesException {
        return distributionStamps(idUser, stamps, EnumAccountBalance.Remove, comment);
    }

    /**
     * Obtiene el saldo de un usuario por ID.
     */
    public AccountBalanceResponse getBalanceById(UUID idUser) throws ServicesException {
        Map<String, String> headers = getHeaders();  // Obtener encabezados.
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());  // Configurar proxy.
        String path = String.format(MANAGEMENT_API_BALANCE_PATH, idUser.toString());  // Ruta del usuario.

        // Consultar saldo.
        return handler.getHTTP(getUrlapi() == null ? getUrl() : getUrlapi(), path, headers, config, AccountBalanceResponse.class);
    }

    /**
     * Obtiene el saldo asociado al token.
     */
    @Override
    public AccountBalanceResponse getBalance() throws ServicesException {
        Map<String, String> headers = getHeaders();  // Obtener encabezados.
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());  // Configurar proxy.

        // Consultar saldo general.
        return handler.getHTTP(getUrlapi() == null ? getUrl() : getUrlapi(), SERVICE_BALANCE_PATH, headers, config, AccountBalanceResponse.class);
    }
}
