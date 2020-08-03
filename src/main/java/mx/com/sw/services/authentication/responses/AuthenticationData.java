package mx.com.sw.services.authentication.responses;

import com.google.gson.annotations.SerializedName;

/**
 * <h1>AuthenticationData</h1> Clase que contiene información acerca de la
 * authentication cuando la misma ha tenido un status de "success".
 * <p>
 * En el campo "token" está un String de estilo JsonWebToken con el cual se hace
 * uso de los servicio de SW sapien®. El campo "expires_in" contiene la fecha de
 * expiracion en formato "EpochTime" variante en segundos.
 *
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class AuthenticationData {
    private String token;
    @SerializedName("expires_in")
    private long expiresIn;

    /**
     * Constructor de la clase.
     * @param token
     * @param expiresIn
     */
    public AuthenticationData(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }

    /**
     * Obtiene JsonWebToken para uso de los servicios.
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Obtiene EpochTime de vencimiento.
     */
    public long getExpiresIn() {
        return this.expiresIn;
    }
}
