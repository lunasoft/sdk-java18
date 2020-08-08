package mx.com.sw.services.issue;

import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* IssueTest
* Clase para UT del servicio de timbrado Issue.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class IssueTest {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public IssueTest() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT timbrado versión 1.
    */
    @Test
    public void testStampV1() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV1 response = stamp.timbrarV1(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 2.
    */
    @Test
    public void testStampV2() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV2 response = stamp.timbrarV2(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 3.
    */
    @Test
    public void testStampV3() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV3 response = stamp.timbrarV3(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 4.
    */
    @Test
    public void testStampV4() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV4 response = stamp.timbrarV4(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 1 (con token).
    */
    public void testStampV1Token() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getTokenSW(), null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV1 response = stamp.timbrarV1(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 2 (con token).
    */
    @Test
    public void testStampV2Token() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getTokenSW(), null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV2 response = stamp.timbrarV2(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 3 (con token).
    */
    @Test
    public void testStampV3Token() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getTokenSW(), null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV3 response = stamp.timbrarV3(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 4 (con token).
    */
    @Test
    public void testStampV4Token() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getTokenSW(), null, 0);
        String xml = settings.getCFDI(false);
        StampResponseV4 response = stamp.timbrarV4(xml, false);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 1 (base64 xml).
    */
    @Test
    public void testStampV1B64() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(false);
        StampResponseV1 response = stamp.timbrarV1(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 2 (base64 xml).
    */
    @Test
    public void testStampV2B64() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(false);
        StampResponseV2 response = stamp.timbrarV2(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 3 (base64 xml).
    */
    @Test
    public void testStampV3B64() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(false);
        StampResponseV3 response = stamp.timbrarV3(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }

    /**
    * Método de UT timbrado versión 4 (base64 xml).
    */
    @Test
    public void testStampV4B64() {
        Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        String xml = settings.getCFDIB64(false);
        StampResponseV4 response = stamp.timbrarV4(xml, true);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
    }
}
