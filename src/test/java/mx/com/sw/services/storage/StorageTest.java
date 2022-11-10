package mx.com.sw.services.storage;

import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;

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
            StorageResponse res = storage.getXml(UUID.fromString("876625f9-605a-4f52-9db8-0b724c03ba38"));
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getXml());
            //Assertions.assertNotNull(res.);
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
            StorageResponse res = storage.getXml(UUID.randomUUID());
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getMessage());
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetXmlEmpty_Error() {
        try {
            Storage storage = new Storage(settings.getUrlServicesSW(), "empty.token.sw", null, 0);
            StorageResponse res = storage.getXml(UUID.fromString("876625f9-605a-4f52-9db8-0b764c03ba38"));
            Assertions.assertNotNull(res);
            Assertions.assertNotNull(res.getMessage());
            Assertions.assertFalse("success".equals(res.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

   
}
