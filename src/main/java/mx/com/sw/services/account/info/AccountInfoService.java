package mx.com.sw.services.account.info;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;
import mx.com.sw.services.account.info.responses.AccountInfoActionResponse;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;
import mx.com.sw.services.account.info.responses.AccountListDataResponse;

/**
 * Servicio para consulta y gestión de información de cuentas.
 * 
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-17
 */
public abstract class AccountInfoService extends Services {

    // Constructor con autenticación por usuario y contraseña
    protected AccountInfoService(String url, String urlApi, String user, String password, String proxy, int proxyPort)
            throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
    }

    // Constructor con autenticación por token
    protected AccountInfoService(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
    }

    // Consulta información de un usuario por ID
    public abstract AccountListDataResponse getUserById(String idUser) throws ServicesException;

    // Consulta información de un usuario por email
    public abstract AccountListDataResponse getUsersByEmail(String email) throws ServicesException;

    // Consulta información de un usuario por RFC
    public abstract AccountListDataResponse getUsersByRfc(String rfc) throws ServicesException;

    // Consulta usuarios activos o inactivos
    public abstract AccountListDataResponse getUsersActivate(boolean activate) throws ServicesException;

    // Consulta todos los usuarios
    public abstract AccountListDataResponse getAllUsers() throws ServicesException;

    // Crea un nuevo usuario con la información proporcionada
    public abstract AccountInfoResponse createUser(String email, String password, String name, String rfc, int stamps,
            boolean unlimited, String notificationEmail, String phone) throws ServicesException;

    // Actualiza información de un usuario específico
    public abstract AccountInfoActionResponse updateUser(UUID iduser, String name, String rfc, String notificationEmail,
            String phone, boolean isUnlimited) throws ServicesException;

    // Elimina un usuario por ID
    public abstract AccountInfoActionResponse deleteIdUser(String idUser) throws ServicesException;

    // Configura y retorna los headers necesarios para la solicitud
    protected Map<String, String> getHeaders() throws ServicesException {
        this.setupRequest();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "bearer " + this.getToken());
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
