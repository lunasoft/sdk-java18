package mx.com.sw.services.cancelation;

import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.cancelation.responses.CancelationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* <h1>CancelationTest</h1>
* Clase para UT del servicio de Cancelation.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class CancelationTest {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public CancelationTest() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT con datos de CSD.
    */
    @Test
    public void testCancellationCSD() {
        Cancelation cancelation = new Cancelation(settings.getUrlSW(), settings.getTokenSW(), null, 0);
        String csdBase64 = settings.getCSD();
        String keyBase64 = settings.getKey();
        String password = settings.getPasswordCSD();
        String rfc = settings.getRFC();
        String uuid = "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC";
        CancelationResponse response = cancelation.cancelar(csdBase64, keyBase64, rfc, password, uuid);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus())
                || response.getMessage().contains("Intermitencia del SAT"));
    }

    /**
    * Método de UT con datos de PFX.
    */
    @Test
    public void testCancellationPFX() {
        Cancelation cancelation = new Cancelation(settings.getUrlSW(), settings.getUserSW(),
            settings.getPasswordSW(), null, 0);
        String pfxBase64 = settings.getPFX();
        String password = settings.getPasswordCSD();
        String rfc = settings.getRFC();
        String uuid = "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC";
        CancelationResponse response = cancelation.cancelar(pfxBase64, rfc, password, uuid);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus())
                || response.getMessage().contains("Intermitencia del SAT"));
    }

    /**
    * Método de UT con XML.
    */
    @Test
    public void testCancellationXML() {
        Cancelation cancelation = new Cancelation(settings.getUrlSW(), settings.getUserSW(),
            settings.getPasswordSW(), null, 0);
        String xmlCancelation = settings.getXmlCancelation();
        CancelationResponse response = cancelation.cancelar(xmlCancelation);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus())
                || response.getMessage().contains("Intermitencia del SAT"));
    }

    /**
    * Método de UT con datos de RFC y UUID.
    */
    @Test
    public void testCancellationUUID() {
        Cancelation cancelation = new Cancelation(settings.getUrlSW(), settings.getUserSW(),
            settings.getPasswordSW(), null, 0);
        String rfc = settings.getRFC();
        String uuid = "8D93A20F-E9EF-42CA-A2B9-2986A352DCEC";
        CancelationResponse response = cancelation.cancelar(rfc, uuid);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus())
                || response.getMessage().contains("Intermitencia del SAT"));
    }
}
