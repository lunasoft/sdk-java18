package mx.com.sw.services.account.info;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.account.info.responses.AccountInfoActionResponse;
import mx.com.sw.services.account.info.responses.AccountInfoActionResponseHandler;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;
import mx.com.sw.services.account.info.responses.AccountInfoResponseHandler;
import mx.com.sw.services.account.info.responses.AccountListDataResponse;
import mx.com.sw.services.account.info.responses.AccountListDataResponseHandler;

import org.apache.http.client.config.RequestConfig;

import com.google.gson.Gson;

/**
 * Servicio de Consulta de Información de cuenta. Clase que permite obtener el
 * saldo de la
 * cuenta de SW.
 * <p>
 * Ejemplo de uso:
 * 
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
 * 
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-17
 */
public class AccountInfo extends AccountInfoService {
    private final AccountInfoResponseHandler handler;
    private final AccountInfoActionResponseHandler handlerActions;
    private final AccountListDataResponseHandler handlerList;

    /**
     * Constructor de la clase.
     * 
     * @param urlApi       url base de la API
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    public AccountInfo(String url, String urlApi, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
        handler = new AccountInfoResponseHandler();
        handlerActions = new AccountInfoActionResponseHandler();
        handlerList = new AccountListDataResponseHandler();
    }

    /**
     * Constructor de la clase.
     * 
     * @param urlApi    url base de la API
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    
    public AccountInfo(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
        handler = new AccountInfoResponseHandler();
        handlerActions = new AccountInfoActionResponseHandler();
        handlerList = new AccountListDataResponseHandler();
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override

    //Metodos de respuesta con array de todos los datos de usuarios
    public AccountListDataResponse getAllUsers(int page, int pageSize) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        String path = "management/api/users?page=" + page + "&pageSize=" + pageSize;
        return handlerList.getHTTP(getUrlapi() == null ? getUrl() : getUrlapi(), path, headers, config, AccountListDataResponse.class);
    }
    //Metodos de respuestas de que devuelven los datos del user
    public AccountInfoResponse getInfo() throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        return handler.getHTTP(getUrlapi() == null ? getUrl() : getUrlapi(), "management/api/users/info", headers, config, AccountInfoResponse.class);
    }

    public AccountInfoResponse getInfoById(String IdUser) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        String path = "management/api/users/" + IdUser;
        return handler.getHTTP(getUrlapi() == null ? getUrl() : getUrlapi(), path, headers, config, AccountInfoResponse.class);
    }
    //Metodos de respuestas simples

    public AccountInfoActionResponse createUser(String email, String password, String name, String rfc, int profile,
            int stamps, boolean unlimited, boolean active) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        String path = "/management/api/users";
        Map<String, Object> params = new HashMap<>();
        params.put("Email", email);
        params.put("Password", password);
        params.put("Name", name);
        params.put("RFC", rfc);
        params.put("Profile", profile);
        params.put("Stamps", stamps);
        params.put("Unlimited", unlimited);
        params.put("Active", active);
        String jsonBody = new Gson().toJson(params);
        return handlerActions.postHTTPJson(getUrlapi() == null ? getUrl() : getUrlapi(), path, headers, jsonBody,
                config, AccountInfoActionResponse.class);
    }

    public AccountInfoActionResponse getDeleteIdUser(String IdUser) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        String path = "management/api/users/" + IdUser;
        return handlerActions.deleteHTTP(getUrlapi() == null ? getUrl() : getUrlapi(), path, headers, config, AccountInfoActionResponse.class);
    }

    public AccountInfoActionResponse getCreateUser(String email, String password, String name, String rfc, int profile,
            int stamps, boolean unlimited, boolean active) throws ServicesException {
        return createUser(email, password, name, rfc, profile, stamps, unlimited, active);
    }
}