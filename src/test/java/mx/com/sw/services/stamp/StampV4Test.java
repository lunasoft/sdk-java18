package mx.com.sw.services.stamp;

import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* StampTest
* Clase para UT del servicio de timbradoV4.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class StampV4Test {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public StampV4Test() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT timbrado versión 1.
    */
    @Test
    public void testStampV1() {
        StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(true);
        StampResponseV1 response = stamp.timbrarV1(xml, settings.getEmail(), false);
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
        StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(true);
        StampResponseV2 response = stamp.timbrarV2(xml, settings.getEmail(), false);
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
        StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(true);
        StampResponseV3 response = stamp.timbrarV3(xml, settings.getEmail(), false);
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
        StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(true);
        StampResponseV4 response = stamp.timbrarV4(xml, settings.getEmail(), false);
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
        StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(true);
        StampResponseV1 response = stamp.timbrarV1(xml, settings.getEmail(), true);
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
        StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(true);
        StampResponseV2 response = stamp.timbrarV2(xml, settings.getEmail(), true);
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
        StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(true);
        StampResponseV3 response = stamp.timbrarV3(xml, settings.getEmail(), true);
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
        StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(true);
        StampResponseV4 response = stamp.timbrarV4(xml, settings.getEmail(), true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getCFDI());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }
}
