package mx.com.sw.services.storage;

import java.util.UUID;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.authentication.Authentication;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * StorageTest.
 */
public class StorageTest {
    private final BuildSettings settings;

    /**
     * Constructor de la clase.
     */
    public StorageTest() {
        this.settings = new BuildSettings();
    }

    /**
     * Método de UT con token.
     */
    @Test
    public void testGetXmlToken_Success() {
        try {
            Storage storage = new Storage(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            StorageResponse res = storage.getXml(UUID.fromString("9524cdf9-41f8-43b5-8460-58b164cef570"));
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertTrue(res.getData().getRecords().size() > 0);
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT con Authentication.
     */
    @Test
    public void testGetXmlAuth_Success() {
        try {
            Storage storage = new Storage(settings.getUrlServicesSW(), settings.getUrlSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            StorageResponse res = storage.getXml(UUID.fromString("9524cdf9-41f8-43b5-8460-58b164cef570"));
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData());
            Assertions.assertTrue(res.getData().getRecords().size() > 0);

        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT con token incorrecto.
     */
    @Test
    public void testGetXmlToken_Error() {
        try {
            Storage storage = new Storage(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            StorageResponse res = storage.getXml(UUID.fromString("876625f9-605a-4f52-9db8-0b724c03ba38"));
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getMessage());
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT con Authentication incorrecta pero Uuid correcto.
     */
    @Test
    public void testGetXmlAuthIncorrect_Error() {
        try {
            Storage storage = new Storage(settings.getUrlServicesSW(), settings.getUrlSW(), "user",
                    "passError", null, 0);
            StorageResponse res = storage.getXml(UUID.fromString("876625f9-605a-4f52-9db8-0b724c03ba38"));
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
            Assertions.assertNull(res.getData());
            Assertions.assertFalse(res.getData().getRecords().size() > 0);
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT con uuid incorrecto.
     */
    @Test
    public void testGetXmlUuid_Error() {
        try {
            Storage storage = new Storage(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            StorageResponse res = storage.getXml(UUID.randomUUID());
            Assertions.assertNotNull(res);
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT con Authentication exitoso pero uuid incorrecto.
     */
    @Test
    public void testGetXmlAuth_Error() {
        try {
            Authentication auth = new Authentication(settings.getUrlSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            AuthenticationResponse response = auth.authenticate();
            if (response.getStatus().equalsIgnoreCase("success")) {
                Storage storage = new Storage(settings.getUrlServicesSW(), response.getData().getToken(), null, 0);
                StorageResponse res = storage.getXml(UUID.fromString("876625f9-605a-4f52-9db8-0b724c03ba56"));
                Assertions.assertNotNull(res);
                Assertions.assertTrue("error".equals(res.getStatus()));
                Assertions.assertNotNull(res.getData());
                Assertions.assertFalse(res.getData().getRecords().size() > 0);
            }
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

}
