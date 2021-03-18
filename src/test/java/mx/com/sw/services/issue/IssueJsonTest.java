package mx.com.sw.services.issue;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* IssueJsonTest
* Clase para UT del servicio de timbrado Issue Json.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class IssueJsonTest {
    private BuildSettings settings;

    /**
     * Constructor de la clase.
     */
    public IssueJsonTest() {
        this.settings = new BuildSettings();
    }

    /**
     * Método de UT timbrado versión 1 (con usuario y password).
     */
    @Test
    public void testStampV1() {
        try {
            IssueJson stamp = new IssueJson(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(),
                null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV1 response = stamp.timbrarV1(json);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 2 (con usuario y password).
     */
    @Test
    public void testStampV2() {
        try {
            IssueJson stamp = new IssueJson(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(),
                null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV2 response = stamp.timbrarV2(json);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 3 (con usuario y password).
     */
    @Test
    public void testStampV3() {
        try {
            IssueJson stamp = new IssueJson(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(),
                null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV3 response = stamp.timbrarV3(json);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 4 (con usuario y password).
     */
    @Test
    public void testStampV4() {
        try {
            IssueJson stamp = new IssueJson(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(),
                null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV4 response = stamp.timbrarV4(json);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getUUID());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 1 (con token).
     */
    public void testStampV1Token() {
        try {
            IssueJson stamp = new IssueJson(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV1 response = stamp.timbrarV1(json);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 2 (con token).
     */
    @Test
    public void testStampV2Token() {
        try {
            IssueJson stamp = new IssueJson(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV2 response = stamp.timbrarV2(json);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 3 (con token).
     */
    @Test
    public void testStampV3Token() {
        try {
            IssueJson stamp = new IssueJson(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV3 response = stamp.timbrarV3(json);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 4 (con token).
     */
    @Test
    public void testStampV4Token() {
        try {
            IssueJson stamp = new IssueJson(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV4 response = stamp.timbrarV4(json);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getUUID());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 1 (con usuario y password y envio de email).
     */
    @Test
    public void testV4StampV1() {
        try {
            IssueJsonV4 stamp = new IssueJsonV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(),
                null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV1 response = stamp.timbrarV1(json, settings.getEmail());
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 2 (con usuario y password y envio de email).
     */
    @Test
    public void testV4StampV2() {
        try {
            IssueJsonV4 stamp = new IssueJsonV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(),
                null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV2 response = stamp.timbrarV2(json, settings.getEmail());
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 3 (con token y envio de email).
     */
    @Test
    public void testV4StampV3() {
        try {
            IssueJsonV4 stamp = new IssueJsonV4(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV3 response = stamp.timbrarV3(json, settings.getEmail());
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT timbrado versión 4 (con token y envio de email).
     */
    @Test
    public void testV4StampV4() {
        try {
            IssueJsonV4 stamp = new IssueJsonV4(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String json = settings.getJsonCFDI();
            StampResponseV4 response = stamp.timbrarV4(json, settings.getEmail());
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getUUID());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    
    /**
     * Método de UT timbrado versión 3 bigFile
     */
    @Test
    public void testStampBigFileV3() {
        try {
            IssueJson stamp = new IssueJson(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(),
                null, 0);
            String json = settings.getJsonCFDIBig();
            StampResponseV3 response = stamp.timbrarV3(json);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
