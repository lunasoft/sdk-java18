package mx.com.sw.services.account.balance;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.EnumAccountBalance;
import mx.com.sw.services.Services;
import mx.com.sw.services.account.balance.responses.AccountBalanceActionResponse;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;

/**
 * AccountBalanceService - Servicio para implementación de consulta de saldos.
 * Proporciona métodos abstractos para consultar y administrar el saldo de usuarios.
 * Extiende la clase base Services.
 * 
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-14
 */
public abstract class AccountBalanceService extends Services {

    /**
     * Constructor de la clase.
     * 
     * @param url       URL base de SW
     * @param urlApi    URL base de la API
     * @param user      Correo o usuario de SW
     * @param password  Contraseña de SW.
     * @param proxy     IP o dominio de proxy (null si no se utiliza)
     * @param proxyPort Número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException Excepción en caso de error.
     */
    protected AccountBalanceService(String url, String urlApi, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * 
     * @param urlApi    URL base de la API o URL base de Servicios
     * @param token     Token infinito de SW.
     * @param proxy     IP o dominio de proxy (null si no se utiliza)
     * @param proxyPort Número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException Excepción en caso de error.
     */
    protected AccountBalanceService(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * 
     * @param url       URL base de SW
     * @param user      Correo o usuario de SW
     * @param password  Contraseña de SW.
     * @param proxy     IP o dominio de proxy (null si no se utiliza)
     * @param proxyPort Número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException Excepción en caso de error.
     */
    protected AccountBalanceService(String url, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    /**
     * Consulta el saldo de la cuenta configurada para un usuario específico.
     * 
     * @param idUser ID del usuario.
     * @return Objeto {@link AccountBalanceResponse} con la respuesta de la API.
     * @throws ServicesException Excepción en caso de error.
     */
    public abstract AccountBalanceResponse getBalanceById(UUID idUser) throws ServicesException;

    /**
     * Consulta el saldo de la cuenta configurada para el usuario asociado al token proporcionado
     * 
     * @return Objeto {@link AccountBalanceResponse} con la respuesta de la API.
     * @throws ServicesException Excepción en caso de error.
     */
    public abstract AccountBalanceResponse getBalance() throws ServicesException;

    /**
     * Realiza la distribución de timbres para un usuario específico.
     * 
     * @param idUser   ID del usuario.
     * @param stamps   Cantidad de timbres a distribuir.
     * @param action   Acción a realizar (EnumAccountBalance.Add o EnumAccountBalance.Remove).
     * @param comment  Comentario asociado a la operación.
     * @return Objeto {@link AccountBalanceActionResponse} con la respuesta de la API.
     * @throws ServicesException Excepción en caso de error.
     */
    protected abstract AccountBalanceActionResponse distributionStamps(UUID idUser, int stamps, EnumAccountBalance action,
            @Nullable String comment) throws ServicesException;

    /**
     * Agrega timbres para un usuario específico.
     * 
     * @param idUser  ID del usuario.
     * @param stamps  Cantidad de timbres a agregar.
     * @param comment Comentario asociado a la operación.
     * @return Objeto {@link AccountBalanceActionResponse} con la respuesta de la API.
     * @throws ServicesException Excepción en caso de error.
     */
    public abstract AccountBalanceActionResponse addStamps(UUID idUser, int stamps, @Nullable String comment) throws ServicesException;

    /**
     * Elimina timbres para un usuario específico.
     * 
     * @param idUser  ID del usuario.
     * @param stamps  Cantidad de timbres a eliminar.
     * @param comment Comentario asociado a la operación.
     * @return Objeto {@link AccountBalanceActionResponse} con la respuesta de la API.
     * @throws ServicesException Excepción en caso de error.
     */
    public abstract AccountBalanceActionResponse removeStamps(UUID idUser, int stamps, @Nullable String comment)
            throws ServicesException;

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * 
     * @throws ServicesException Excepción en caso de error.
     * @return Mapa con los headers.
     */
    protected Map<String, String> getHeaders() throws ServicesException {
        this.setupRequest();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "bearer " + this.getToken());
        headers.put("Content-Type", "application/json");
        return headers;
    }

    /**
     * Convierte el comentario a JSON utilizando la clase {@link AccountBalanceRequest}.
     * 
     * @param comment Comentario a convertir.
     * @return JSON representando el comentario.
     */
    protected String requestAccount(String comment) {
        AccountBalanceRequest objectRequest = new AccountBalanceRequest(comment);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }
}
