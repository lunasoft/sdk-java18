package mx.com.sw.services.authentication;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralValidations;

/**
 * <h1>AuthenticationValidation</h1> Clase para validaciones en el
 * servicio de authentication.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class AuthenticationValidation extends GeneralValidations {

    /**
     * Constructor de clase.
     * @param url
     * @param user
     * @param password
     * @param token
     * @throws ServicesException
     */
    public AuthenticationValidation(String url, String user, String password, String token) throws ServicesException {
        super(url, user, password, token);
    }

}
