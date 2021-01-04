package mx.com.sw.services.authentication;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;

/**
* AuthenticationService
* Servicio mediante el cual se permite authenticar utilizando usuario y contraseña.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public abstract class AuthenticationService extends Services {

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param user usuario de SW.
     * @param password password de SW.
     * @param proxy url o host a usar de proxy (null en caso de no usar).
     * @param proxyPort puerto a usar de proxy (cualquier valor en caso de no usar).
     * @throws ServicesException exception en caso de error.
     */
    public AuthenticationService(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    /**
     * Método de authentication que se realiza con los datos configurados.
     * @return AuthenticationResponse
     */
    public abstract AuthenticationResponse authenticate();

}
