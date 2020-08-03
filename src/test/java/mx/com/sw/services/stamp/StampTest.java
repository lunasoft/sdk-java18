package mx.com.sw.services.stamp;

import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* <h1>StampTest</h1>
* Clase para UT del servicio de timbrado.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class StampTest {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public StampTest() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT timbrado versión 1.
    */
    @Test
    public void testStampV1() {
        Stamp stamp = new Stamp(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(true);
        StampResponseV1 response = stamp.timbrarV1(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getTFD());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 2.
    */
    @Test
    public void testStampV2() {
        Stamp stamp = new Stamp(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(true);
        StampResponseV2 response = stamp.timbrarV2(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getCFDI());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 3.
    */
    @Test
    public void testStampV3() {
        Stamp stamp = new Stamp(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(true);
        StampResponseV3 response = stamp.timbrarV3(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getCFDI());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 4.
    */
    @Test
    public void testStampV4() {
        Stamp stamp = new Stamp(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(true);
        StampResponseV4 response = stamp.timbrarV4(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getCFDI());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 1 base64.
    */
    @Test
    public void testStampV1B64() {
        Stamp stamp = new Stamp(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(true);
        StampResponseV1 response = stamp.timbrarV1(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getTFD());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 2 base64.
    */
    @Test
    public void testStampV2B64() {
        Stamp stamp = new Stamp(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(true);
        StampResponseV2 response = stamp.timbrarV2(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getCFDI());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 3 base64.
    */
    @Test
    public void testStampV3B64() {
        Stamp stamp = new Stamp(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(true);
        StampResponseV3 response = stamp.timbrarV3(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getCFDI());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 4 base64.
    */
    @Test
    public void testStampV4B64() {
        Stamp stamp = new Stamp(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(true);
        StampResponseV4 response = stamp.timbrarV4(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getCFDI());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }
}
