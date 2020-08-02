package mx.com.sw.services.authentication;

import mx.com.sw.services.Services;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;

/**
* <h1>AuthenticationService</h1>
* Servicio mediante el cual se permite authenticar utilizando usuario y contraseña.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public abstract class AuthenticationService extends Services {

    /**
     * Constructor de la clase.
     * @param url
     * @param user
     * @param password
     * @param proxy
     * @param proxyPort
     */
    public AuthenticationService(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
    }

    /**
     * Método de authentication que se realiza con los datos configurados.
     */
    public abstract AuthenticationResponse authenticate();

}
