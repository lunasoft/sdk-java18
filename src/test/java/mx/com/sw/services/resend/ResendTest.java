package mx.com.sw.services.resend;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.resend.response.ResendResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;

public class ResendTest {
    private final BuildSettings settings;

    /**
     * Constructor de la clase.
     */
    public ResendTest() {
        this.settings = new BuildSettings();
    }

    @Test
    public void testResendTokenSuccess() {
        try {
            Resend resend = new Resend(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            System.out.println(settings.getTokenSW());
            ResendResponse response = resend.ResendEmail(settings.getUuid(), settings.getCorreo());
            Assertions.assertNotNull(response);
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("email sent ok".equalsIgnoreCase(response.getData()));
            Assertions.assertTrue("OK".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue("OK".equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testResendUserSuccess() {
        try {
            Resend resend = new Resend(settings.getUrlSW(), settings.getUrlServicesSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            ResendResponse response = resend.ResendEmail(settings.getUuid(), settings.getCorreo());
            Assertions.assertNotNull(response);
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("email sent ok".equalsIgnoreCase(response.getData()));
            Assertions.assertTrue("OK".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue("OK".equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testResendInvalidToken() {
        try {
            Resend resend = new Resend(settings.getUrlServicesSW(), "invalid token", null, 0);
            ResendResponse response = resend.ResendEmail(settings.getUuid(), settings.getCorreo());
            Assertions.assertNotNull(response);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("AU4101 - El token proporcionado viene vacio.".equalsIgnoreCase(response.getMessage())
                    || "AU4000 - No fue posible validar el token.".equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    @Test
    public void testResendNullToken() {
        try {
            Resend resend = new Resend(settings.getUrlServicesSW(), null, null, 0);
            ResendResponse response = resend.ResendEmail(settings.getUuid(), settings.getCorreo());
            Assertions.assertNotNull(response);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("AU4101 - El token proporcionado viene vacio.".equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testResendUserError() {
        try {
            Resend resend = new Resend(settings.getUrlSW(), settings.getUrlServicesSW(), "invalid user",
                    "invalid password", null, 0);
            ResendResponse response = resend.ResendEmail(settings.getUuid(), settings.getCorreo());
            Assertions.assertNull(response.getData());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions
                    .assertTrue("AU2000 - El usuario y/o contraseña son inválidos, no se puede autenticar el servicio."
                            .equalsIgnoreCase(response.getMessage()));
            Assertions.assertNotNull(response.getMessageDetail());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testResendNullUiid() {
        try {
            Resend resend = new Resend(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            ResendResponse response = resend.ResendEmail(null, settings.getCorreo());
            Assertions.assertNull(response.getData());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Can not process the message, we need uuid and to parametters".equalsIgnoreCase(response.getMessage()));
            Assertions.assertNotNull(response.getMessageDetail());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    @Test
    public void testResendNullEmail() {
        try {
            Resend resend = new Resend(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            ResendResponse response = resend.ResendEmail(settings.getUuid(), null);
            Assertions.assertNull(response.getData());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("El listado de correos está vacío o contiene más de 5 correos.".equalsIgnoreCase(response.getMessage()));
            Assertions.assertNotNull(response.getMessageDetail());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    @Test
    public void testResendSixEmail() {
        try {
            Resend resend = new Resend(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            ResendResponse response = resend.ResendEmail(settings.getUuid(), settings.getCorreos());
            Assertions.assertNull(response.getData());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("El listado de correos está vacío o contiene más de 5 correos.".equalsIgnoreCase(response.getMessage()));
            Assertions.assertNotNull(response.getMessageDetail());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    @Test
    public void testResendInvalidEmail() {
        try {
            List<String> email = Arrays.asList("invalid email");
            Resend resend = new Resend(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            ResendResponse response = resend.ResendEmail(settings.getUuid(), email);
            Assertions.assertNull(response.getData());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("El listado de correos no contiene un formato válido o alguno de los correos es inválido.".equalsIgnoreCase(response.getMessage()));
            Assertions.assertNotNull(response.getMessageDetail());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }


}
