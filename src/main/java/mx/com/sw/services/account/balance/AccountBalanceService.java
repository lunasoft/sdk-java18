package mx.com.sw.services.account.balance;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.EnumAccountBalance;
import mx.com.sw.services.Services;
import mx.com.sw.services.account.balance.responses.AccountBalanceActionResponse;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servicio para consultar y administrar saldos de usuarios.
 * Extiende la clase base Services.
 */
public abstract class AccountBalanceService extends Services {

    // Constructor con parámetros de URL, usuario y proxy
    protected AccountBalanceService(String url, String urlApi, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, urlApi, user, password, proxy, proxyPort);
    }

    // Constructor con URL de API, token y proxy
    protected AccountBalanceService(String urlApi, String token, String proxy, int proxyPort) throws ServicesException {
        super(urlApi, token, proxy, proxyPort);
    }

    // Constructor con URL, usuario, contraseña y proxy
    protected AccountBalanceService(String url, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    // Método para consultar saldo por ID de usuario
    public abstract AccountBalanceResponse getBalanceById(UUID idUser) throws ServicesException;

    // Método para consultar saldo usando el token del usuario
    public abstract AccountBalanceResponse getBalance() throws ServicesException;

    // Método para distribuir timbres a un usuario
    protected abstract AccountBalanceActionResponse distributionStamps(
            UUID idUser, int stamps, EnumAccountBalance action,
            @Nullable String comment) throws ServicesException;

    // Método para agregar timbres a un usuario
    public abstract AccountBalanceActionResponse addStamps(UUID idUser,
            int stamps, @Nullable String comment) throws ServicesException;

    // Método para eliminar timbres de un usuario
    public abstract AccountBalanceActionResponse removeStamps(UUID idUser, int stamps, @Nullable String comment)
            throws ServicesException;

    // Método para obtener los headers necesarios para el servicio
    protected Map<String, String> getHeaders() throws ServicesException {
        this.setupRequest();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "bearer " + this.getToken());
        headers.put("Content-Type", "application/json");
        return headers;
    }

    // Método para convertir un comentario a formato JSON
    protected String requestAccount(int stamp, String comment) {
        AccountBalanceRequest objectRequest = new AccountBalanceRequest(stamp, comment);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }
}
