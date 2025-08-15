package mx.com.sw.services.cancelationretention;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.cancelationretention.responses.CancelationRetentionResponse;

/**
 * CancelationRetentionTest
 * Clase para UT del servicio de CancelationRetention.
 */
public class CancelationRetentionTest {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public CancelationRetentionTest() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT con XML de cancelación de retención.
    */
    @Test
    public void testCancellationXML() {
        try {
            CancelationRetention cancelation = new CancelationRetention(settings.getUrlSW(), settings.getUserSW(),
                settings.getPasswordSW(), null, 0);
            String xmlCancelation = settings.getXmlCancelationRetention();
            CancelationRetentionResponse response = cancelation.cancelar(xmlCancelation);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
} 