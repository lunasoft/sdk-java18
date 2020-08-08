package mx.com.sw.services.authentication;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralValidations;

/**
 * AuthenticationValidation Clase para validaciones en el
 * servicio de authentication.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class AuthenticationValidation extends GeneralValidations {

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param user usuario de SW.
     * @param password password de SW.
     * @param token token de SW.
     * @throws ServicesException exception en caso de error.
     */
    public AuthenticationValidation(String url, String user, String password, String token) throws ServicesException {
        super(url, user, password, token);
    }

}
