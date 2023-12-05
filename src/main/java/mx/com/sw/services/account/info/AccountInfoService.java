package mx.com.sw.services.account.info;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;
import mx.com.sw.services.account.info.responses.AccountInfoActionResponse;
import mx.com.sw.services.account.info.responses.AccountInfoResponse;
import mx.com.sw.services.account.info.responses.AccountListDataResponse;

/**
 * AccountInfoService - Servicio para implementación de consulta de información.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-17
 */
public abstract class AccountInfoService extends Services {
    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected AccountInfoService(String url, String urlApi, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected AccountInfoService(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
    }

    /**
     * Consulta los datos de la cuenta configurada.
     * @return {@link AccountInfoResponse}
     * @throws ServicesException exception en caso de error.
     */
    public abstract AccountInfoResponse getInfo() throws ServicesException;

    /**
     * Obtiene la información de la cuenta para un usuario específico por su Id.
     * @param IdUser    Identificador del usuario.
     * @return          Respuesta de la solicitud de información de la cuenta.
     * @throws ServicesException exception en caso de error.
     */
    public abstract AccountInfoResponse getInfoById(String IdUser) throws ServicesException;

    /**
     * Obtiene la información de todos los usuarios con paginación.
     * @param page      Número de la página.
     * @param pageSize  Tamaño de la página.
     * @return          Respuesta de la solicitud de información de los usuarios.
     * @throws ServicesException exception en caso de error.
     */
    public abstract AccountListDataResponse getInfoAllUsers(int page, int pageSize) throws ServicesException;

    /**
     * Obtiene la información de todos los usuarios con paginación.
     * @param email     Correo para el usuario.
     * @param password  Contraseña para el usuario.
     * @param name      Nombre para el usuario.
     * @param rfc       RFC del usuario.
     * @param profile   Perfil del cliente (por defecto 3).
     * @param stamps    Número de timbres al crear la cuenta.
     * @param unlimited Booleano que determina si la cuenta es ilimitada o no.
     * @param active    Booleano que determina si la cuenta se genera como activa o inactiva.
     * @return          Respuesta de la solicitud de información de los usuarios.
     * @throws ServicesException exception en caso de error.
     */
    public abstract AccountInfoActionResponse getInfoCreateUser(String email, String password, String name, String rfc, int profile, int stamps, boolean unlimited, boolean active) throws ServicesException;

    /**
     * Elimina la cuenta para un usuario específico por su Id.
     * @param IdUser    Identificador del usuario.
     * @return          Respuesta de la solicitud de información de la cuenta.
     * @throws ServicesException exception en caso de error.
     */
    public abstract AccountInfoActionResponse getInfoDeleteIdUser(String IdUser) throws ServicesException;

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
