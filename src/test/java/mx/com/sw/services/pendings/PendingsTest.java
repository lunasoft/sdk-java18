package mx.com.sw.services.pendings;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.pendings.response.PendingsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
* PendingsTest
* Clase para UT del servicio de Pendings.
* @author  Dan Iñiguez
* @version 0.0.1.0
* @since   2021-08-25
*/
public class PendingsTest {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public PendingsTest() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT con peticiones.
    */
    @Disabled("uuids pendings stay short time")
    @Test
    public void testPendings_Token_success_WithUUIDs() {
        try {
            Pendings pendings = new Pendings(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            PendingsResponse res = pendings.getPendings(settings.getRFC());
            Assertions.assertNotNull(res);
            Assertions.assertTrue("CA1100 - Se recibío la respuesta de la petición de forma exitosa."
                    .equals(res.getMessage()));
            Assertions.assertNotNull(res.getData().getUUIDs().get(0));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT sin peticiones.
    */
    @Disabled("It is likely that the RFC has pending requests at the time of running the test")
    @Test
    public void testPendings_Token_success_EmptyUUIDs() {
        try {
            Pendings pendings = new Pendings(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            PendingsResponse res = pendings.getPendings("XIA190128J61");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("CA1101 - No existen peticiones para el RFC Receptor."
                    .equals(res.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
