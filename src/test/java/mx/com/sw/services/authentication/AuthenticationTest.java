package mx.com.sw.services.authentication;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* AuthenticationTest
* Clase para UT del servicio de Authentication.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class AuthenticationTest {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public AuthenticationTest() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT con usuario y password.
    */
    @Test
    public void testAuthenticate() {
        try {
            Authentication auth = new Authentication(settings.getUrlSW(), settings.getUserSW(),
                settings.getPasswordSW(), null, 0);
            AuthenticationResponse res = auth.authenticate();
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getData());
            Assertions.assertNotNull(res.getData().getToken());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT con credenciales incorrectas.
    */
    @Test
    public void testBadAuth() {
        try {
            Authentication auth = new Authentication(settings.getUrlSW(), settings.getUserSW(), "badpwd", null, 0);
            AuthenticationResponse res = auth.authenticate();
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getMessage());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
