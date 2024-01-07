package mx.com.sw.services.issue;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

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
        try {
            Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV1 response = stamp.timbrarV1(xml, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 2.
    */
    @Test
    public void testStampV2() {
        try {
            Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV2 response = stamp.timbrarV2(xml, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 3.
    */
    @Test
    public void testStampV3() {
        try {
            Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV3 response = stamp.timbrarV3(xml, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 4.
    */
    @Test
    public void testStampV4() {
        try {
            Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV4 response = stamp.timbrarV4(xml, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 1 y envio de email.
    */
    @Test
    public void testStampV1_email() {
        try {
            IssueV4 stamp = new IssueV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV1 response = stamp.timbrarV1(xml, settings.getEmail(), null, false, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 1 y envio de email erroneo.
    */
    @Test
    public void testStampV1_errorEmail() {
        try {
            IssueV4 stamp = new IssueV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV1 response = stamp.timbrarV1(xml, "correotest.com.mx", null, false, false);
            String messageExpect = "El listado de correos no contiene un formato válido o alguno de los correos es inválido.";
            Assertions.assertNotNull(response);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue(messageExpect .equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 1 y envio de 6 emails.
    */
    @Test
    public void testStampV1_maxEmail() {
        try {
            IssueV4 stamp = new IssueV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            String emails = "correo@test.com.mx, correo@test2.com.mx, correo@test3.com.mx, correo@test4.com.mx, correo@test5.com.mx, correo@test6.com.mx";
            StampResponseV1 response = stamp.timbrarV1(xml, emails, null, false, false);
            String messageExpect = "El listado de correos está vacío o contiene más de 5 correos.";
            Assertions.assertNotNull(response);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue(messageExpect .equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 1 con envio de parametro customId.
    */
    @Test
    public void testStampV1_customId() {
        try {
            IssueV4 stamp = new IssueV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(xml, null, customId, false, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 1 con envio de parametro customId duplicado.
    */
    @Test
    public void testStampV1_duplicateCustomId() {
        try {
            IssueV4 stamp = new IssueV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(xml, null, customId, false, false);
            Assertions.assertNotNull(response);
            xml = settings.getCFDI(false);
            response = stamp.timbrarV1(xml, null, customId, false, false);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("CFDI3307 - Timbre duplicado. El customId proporcionado está duplicado.".equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 1 con envio de parametro customId inválido.
    */
    @Test
    public void testStampV1_invalidCustomId() {
        try {
            IssueV4 stamp = new IssueV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            String customId = UUID.randomUUID().toString();
            customId = Collections.nCopies(10, customId).stream().collect(Collectors.joining());
            StampResponseV1 response = stamp.timbrarV1(xml, null, customId, false, false);
            String messageExpect = "El CustomId no es válido o viene vacío.";
            Assertions.assertNotNull(response);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue(messageExpect .equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 1 con envio de parametro PDF.
    */
    @Test
    public void testStampV1_pdf() {
        try {
            IssueV4 stamp = new IssueV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV1 response = stamp.timbrarV1(xml, null, null, true, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
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
            Issue stamp = new Issue(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV1 response = stamp.timbrarV1(xml, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
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
            Issue stamp = new Issue(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV2 response = stamp.timbrarV2(xml, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
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
            Issue stamp = new Issue(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV3 response = stamp.timbrarV3(xml, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
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
            Issue stamp = new Issue(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String xml = settings.getCFDI(false);
            StampResponseV4 response = stamp.timbrarV4(xml, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 1 (base64 xml).
    */
    @Test
    public void testStampV1B64() {
        try {
            Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDIB64(false);
            StampResponseV1 response = stamp.timbrarV1(xml, true);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 2 (base64 xml).
    */
    @Test
    public void testStampV2B64() {
        try {
            Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDIB64(false);
            StampResponseV2 response = stamp.timbrarV2(xml, true);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 3 (base64 xml).
    */
    @Test
    public void testStampV3B64() {
        try {
            Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDIB64(false);
            StampResponseV3 response = stamp.timbrarV3(xml, true);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 4 (base64 xml).
    */
    @Test
    public void testStampV4B64() {
        try {
            Issue stamp = new Issue(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDIB64(false);
            StampResponseV4 response = stamp.timbrarV4(xml, true);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
