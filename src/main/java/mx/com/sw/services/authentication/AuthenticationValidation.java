package mx.com.sw.services.authentication;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralValidations;

public class AuthenticationValidation extends GeneralValidations {

    public AuthenticationValidation(String url, String user, String password, String token) throws ServicesException {
        super(url, user, password, token);
    }
    
}