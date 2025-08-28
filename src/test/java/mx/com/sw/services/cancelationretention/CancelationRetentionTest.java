package mx.com.sw.services.cancelationretention;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.cancelationretention.responses.CancelationRetResponse;

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
            CancelationRetResponse response = cancelation.cancelar(xmlCancelation);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    /**
    * Método de UT con datos de CSD.
    */
    @Test
    public void testCancellationCSD() {
        try {
            CancelationRetention cancelation = new CancelationRetention(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String csdBase64 = settings.getCSD();
            String keyBase64 = settings.getKey();
            String password = settings.getPasswordCSD();
            String rfc = settings.getRFC();
            String uuid = "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC";
            CancelationRetResponse response = cancelation.cancelar(csdBase64, keyBase64, rfc, password, uuid, "02", null);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus())
                    || response.getMessage().contains("Intermitencia del SAT"));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
     /**
    * Método de UT con datos de PFX.
    */
    @Test
    public void testCancellationPFX() {
        try {
            CancelationRetention cancelation = new CancelationRetention(settings.getUrlSW(), settings.getUserSW(),
                settings.getPasswordSW(), null, 0);
            String pfxBase64 = settings.getPFX();
            String password = settings.getPasswordPFX();
            String rfc = settings.getRFC();
            String uuid = "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC";
            CancelationRetResponse response = cancelation.cancelar(pfxBase64, rfc, password, uuid, "02", null);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus())
                    || response.getMessage().contains("Intermitencia del SAT"));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

} 