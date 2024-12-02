package mx.com.sw.services.account.info; // Paquete que contiene la clase AccountInfo

// Importación de clases necesarias para manejo de solicitudes HTTP, UUID, y JSON
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.client.config.RequestConfig;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.EnumAccountFilters;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.account.info.responses.*;
import com.google.gson.Gson;

/**
 * Clase para consultar información de cuentas en el sistema SW.
 */
public class AccountInfo extends AccountInfoService {

    // Manejadores de respuesta para diferentes tipos de solicitudes
    private final AccountInfoResponseHandler handler;
    private final AccountInfoActionResponseHandler handlerActions;
    private final AccountListDataResponseHandler handlerList;
    private static final String API_USER_PATH = "management/v2/api/dealers/users";

    /**
     * Constructor con autenticación por usuario y contraseña.
     */
    public AccountInfo(String url, String urlApi, String user, String password, String proxy, int proxyPort)
            throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
        handler = new AccountInfoResponseHandler();
        handlerActions = new AccountInfoActionResponseHandler();
        handlerList = new AccountListDataResponseHandler();
    }

    /**
     * Constructor con autenticación por token.
     */
    public AccountInfo(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
        handler = new AccountInfoResponseHandler();
        handlerActions = new AccountInfoActionResponseHandler();
        handlerList = new AccountListDataResponseHandler();
    }

    /**
     * Crea un usuario con la información proporcionada.
     */
    public AccountInfoResponse createUser(String email, String password, String name, String rfc, int stamps,
            boolean unlimited, String notificationEmail, String phone) throws ServicesException {
        return createMapUser(email, password, name, rfc, stamps, unlimited, notificationEmail, phone);
    }

    /**
     * Actualiza los datos de un usuario existente.
     */
    public AccountInfoActionResponse updateUser(UUID iduser, String name, String rfc, String notificationEmail,
            String phone, boolean isUnlimited) throws ServicesException {
        return updateMapUser(iduser, name, rfc, notificationEmail, phone, isUnlimited);
    }

    // Métodos privados para mapear datos y enviar solicitudes a la API

    /**
     * Crea un nuevo usuario en el sistema.
     */
    private AccountInfoResponse createMapUser(String email, String password, String name, String rfc, int stamps,
            boolean unlimited, String notificationEmail, String phone) throws ServicesException {
        Map<String, String> headers = getHeaders(); // Genera encabezados para la solicitud
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());

        // Mapeo de parámetros para el cuerpo de la solicitud
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("taxId", rfc);
        params.put("email", email);
        params.put("stamps", stamps);
        params.put("isUnlimited", unlimited);
        params.put("password", password);
        params.put("notificationEmail", notificationEmail);
        params.put("phone", phone);

        // Conversión del cuerpo de la solicitud a JSON
        String jsonBody = new Gson().toJson(params);
        return handler.postHTTPJson(getUrlapi() == null ? getUrl() : getUrlapi(), API_USER_PATH, headers, jsonBody, config,
                AccountInfoResponse.class);
    }

    /**
     * Actualiza un usuario existente en el sistema.
     */
    private AccountInfoActionResponse updateMapUser(UUID iduser, String name, String rfc, String notificationEmail,
            String phone, boolean isUnlimited) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());

        // Mapeo de parámetros para la solicitud
        Map<String, Object> params = new HashMap<>();
        params.put("iduser", iduser);
        params.put("name", name);
        params.put("taxId", rfc);
        params.put("isUnlimited", isUnlimited);
        params.put("notificationEmail", notificationEmail);
        params.put("phone", phone);

        // Envío de la solicitud PUT con los datos
        String jsonBody = new Gson().toJson(params);
        return handlerActions.putHTTPJson(getUrlapi() == null ? getUrl() : getUrlapi(), API_USER_PATH+"/" + iduser, headers, jsonBody, config,
                AccountInfoActionResponse.class);
    }

    // Métodos para obtener usuarios con diferentes filtros

    /**
     * Obtiene todos los usuarios del sistema.
     */
    public AccountListDataResponse getAllUsers() throws ServicesException {
        return getUserFiltersRequest(new HashMap<>());
    }

    /**
     * Obtiene un usuario por su ID.
     */
    public AccountListDataResponse getUserById(String idUser) throws ServicesException {
        Map<EnumAccountFilters, String> filters = new HashMap<>();
        filters.put(EnumAccountFilters.ID_USER, idUser);
        return getUserFiltersRequest(filters);
    }

    /**
     * Obtiene usuarios por su correo electrónico.
     */
    public AccountListDataResponse getUsersByEmail(String email) throws ServicesException {
        Map<EnumAccountFilters, String> filters = new HashMap<>();
        filters.put(EnumAccountFilters.EMAIL, email);
        return getUserFiltersRequest(filters);
    }

    /**
     * Obtiene usuarios por su RFC.
     */
    public AccountListDataResponse getUsersByRfc(String rfc) throws ServicesException {
        Map<EnumAccountFilters, String> filters = new HashMap<>();
        filters.put(EnumAccountFilters.TAX_ID, rfc);
        return getUserFiltersRequest(filters);
    }

    /**
     * Obtiene usuarios activos o inactivos según el parámetro.
     */
    public AccountListDataResponse getUsersActivate(boolean activate) throws ServicesException {
        Map<EnumAccountFilters, String> filters = new HashMap<>();
        filters.put(EnumAccountFilters.IS_ACTIVE, String.valueOf(activate));
        return getUserFiltersRequest(filters);
    }

    /**
     * Elimina un usuario por su ID.
     */
    public AccountInfoActionResponse deleteIdUser(String idUser) throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        return handlerActions.deleteHTTP(getUrlapi() == null ? getUrl() : getUrlapi(), API_USER_PATH+"/" + idUser, headers, config,
                AccountInfoActionResponse.class);
    }

    /**
     * Realiza una solicitud GET con filtros.
     */
    public AccountListDataResponse getUserFiltersRequest(Map<EnumAccountFilters, String> filters)
            throws ServicesException {
        Map<String, String> headers = getHeaders();
        RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
        String uriWithFilters = buildUriWithFilter(API_USER_PATH, filters);
        return handlerList.getHTTP(getUrlapi() == null ? getUrl() : getUrlapi(), uriWithFilters, headers, config,
                AccountListDataResponse.class);
    }

    /**
     * Construye una URI con parámetros de filtro.
     */
    private String buildUriWithFilter(String baseUri, Map<EnumAccountFilters, String> filters) {
        StringBuilder uriBuilder = new StringBuilder(baseUri);
        boolean hasQueryParams = false;

        for (Map.Entry<EnumAccountFilters, String> filter : filters.entrySet()) {
            if (filter.getValue() != null && !filter.getValue().isEmpty()) {
                uriBuilder.append(hasQueryParams ? "&" : "?")
                        .append(filter.getKey().getQueryKey())
                        .append("=")
                        .append(filter.getValue());
                hasQueryParams = true;
            }
        }
        return uriBuilder.toString();
    }
}
