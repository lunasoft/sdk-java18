package mx.com.sw.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.authentication.Authentication;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;

/**
* <h1>Services</h1>
* Clase que mantiene lógica de propiedades inicializadoras de servicios.
* Con el método de setupRequest() automáticamente se renueva el token cada que es necesario.
* Se recomienza hacer uso de setupRequest() antes de getToken()
* <p>
* Los demás servicios hacen uso interno de esta clase.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class Services {
    private static final long INFINITE_TOKEN_DURATION = 7300;
    private String token;
    private String url;
    private String user;
    private String password;
    private String proxy;
    private int proxyPort;
    private Instant expirationDate;

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    protected Services(String url, String token, String proxy, int proxyPort) {
        this.url = GeneralHelpers.noralizeUrl(url);
        this.token = token;
        this.expirationDate = Instant.now().plus(INFINITE_TOKEN_DURATION, ChronoUnit.DAYS);
        this.proxy = proxy;
        this.proxyPort = proxyPort;
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    protected Services(String url, String user, String password, String proxy, int proxyPort) {
        this.url = GeneralHelpers.noralizeUrl(url);
        this.user = user;
        this.password = password;
        this.proxy = proxy;
        this.proxyPort = proxyPort;
    }

    /**
    * Método para obtener propiedad Token.
    * @return String
    */
    protected String getToken() {
        return this.token;
    }

    /**
    * Método para obtener propiedad url.
    * @return String
    */
    protected String getUrl() {
        return this.url;
    }

    /**
    * Método para obtener propiedad user.
    * @return String
    */
    protected String getUser() {
        return this.user;
    }

    /**
    * Método para obtener propiedad password.
    * @return String
    */
    protected String getPassword() {
        return this.password;
    }

    /**
    * Método para obtener propiedad proxy.
    * @return String
    */
    protected String getProxy() {
        return this.proxy;
    }

    /**
    * Método para obtener propiedad proxyPort.
    * @return String
    */
    protected int getProxyPort() {
        return this.proxyPort;
    }

    /**
    * Método para obtener fecha de expiración del token.
    * @return String
    */
    protected Instant getExpirationDate() {
        return this.expirationDate;
    }

    /**
    * Método para verificar y renovar el token.
    * @return String
    */
    protected Services setupRequest() {
        if (GeneralHelpers.stringEmptyOrNull(token) || Instant.now().isAfter(expirationDate)) {
            Authentication auth = new Authentication(url, user, password, proxy, proxyPort);
            AuthenticationResponse response = auth.authenticate();
            if (response.getStatus().equalsIgnoreCase("success")) {
                this.token = response.getData().getToken();
                this.expirationDate = Instant.ofEpochSecond(response.getData().getExpiresIn());
            }
        }
        return this;
    }
}
