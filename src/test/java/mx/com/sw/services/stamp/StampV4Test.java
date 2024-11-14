package mx.com.sw.services.stamp;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    * Método de UT timbrado versión 1 y envio de email.
    */
    @Test
    public void testStampV1Email() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV1 response = stamp.timbrarV1(xml, settings.getCorreo(), null,false, false);
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
    * Método de UT timbrado versión 2 y envio de email.
    */
    @Test
    public void testStampV2Email() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV2 response = stamp.timbrarV2(xml, settings.getCorreo(), null,false, false);
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
    * Método de UT timbrado versión 3 y envio de email.
    */
    @Test
    public void testStampV3Email() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV3 response = stamp.timbrarV3(xml, settings.getCorreo(), null,false, false);
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
    * Método de UT timbrado versión 4 y envio de email.
    */
    @Test
    public void testStampV4Email() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV1 response = stamp.timbrarV1(xml, settings.getCorreo(), null,false, false);
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
    * Método de UT timbrado versión 1 y envio de email erroneo.
    */
    @Test
    public void testV4StampV1_errorEmail() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            List<String> email = Arrays.asList("invalid email");
            StampResponseV1 response = stamp.timbrarV1(xml, email, null,false, false);
            String messageExpect = "El listado de correos no contiene un formato válido o alguno de los correos es inválido.";
            Assertions.assertNotNull(response);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue(messageExpect .equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT timbrado versión 3 y envio de 6 emails.
    */
    @Test
    public void testV4StampV3_maxEmail() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV3 response = stamp.timbrarV3(xml, settings.getCorreos(), null,false, false);
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
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            String customId = UUID.randomUUID().toString();
            StampResponseV1 response = stamp.timbrarV1(xml, null, customId, false, false);
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
    * Método de UT timbrado versión 2 con envio de parametro CustomId.
    */
    @Test
    public void testStampV2_customId() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            String customId = UUID.randomUUID().toString();
            StampResponseV2 response = stamp.timbrarV2(xml, null, customId, false, false);
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
    * Método de UT timbrado versión 3 con envio de parametro CustomId.
    */
    @Test
    public void testStampV3_customId() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            String customId = UUID.randomUUID().toString();
            StampResponseV3 response = stamp.timbrarV3(xml, null, customId, false, false);
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
 * Método de UT timbrado versión 3 con envio de parametro CustomId.
 */
 @Test
 public void testStampV4_customId() {
     try {
         StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
         String xml = settings.getCFDI(true);
         String customId = UUID.randomUUID().toString();
         StampResponseV4 response = stamp.timbrarV4(xml, null, customId, false, false);
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
    * Método de UT timbrado versión 1 con envio de parametro customId duplicado.
    */
    @Test
    public void testStampV1_duplicateCustomId() {
        try {
            String customId = UUID.randomUUID().toString();
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV1 response = stamp.timbrarV1(xml, null, customId, false, false);
            Assertions.assertNotNull(response);
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            xml = settings.getCFDI(true);
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
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
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
    * Método de UT timbrado versión 2 con envio de parametro customId duplicado.
    */
    @Test
    public void testStampV2_duplicateCustomId() {
        try {
            String customId = UUID.randomUUID().toString();
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV2 response = stamp.timbrarV2(xml, null, customId, false, false);
            Assertions.assertNotNull(response);
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            xml = settings.getCFDI(true);
            response = stamp.timbrarV2(xml, null, customId, false, false);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("CFDI3307 - Timbre duplicado. El customId proporcionado está duplicado.".equalsIgnoreCase(response.getMessage()));
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
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV1 response = stamp.timbrarV1(xml, null, null,true, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
        /**
    * Método de UT timbrado versión 2 con envio de parametro PDF.
    */
    @Test
    public void testStampV2_pdf() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV2 response = stamp.timbrarV2(xml, null, null,true, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
        /**
    * Método de UT timbrado versión 3 con envio de parametro PDF.
    */
    @Test
    public void testStampV3_pdf() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV3 response = stamp.timbrarV3(xml, null, null,true, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
            /**
    * Método de UT timbrado versión 4 con envio de parametro PDF.
    */
    @Test
    public void testStampV4_pdf() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDI(true);
            StampResponseV4 response = stamp.timbrarV4(xml, null, null,true, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    /**
    * Método de UT timbrado versión 1 base64.
    */
    @Test
    public void testStampV1B64() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDIB64(true);
            StampResponseV1 response = stamp.timbrarV1(xml, settings.getCorreo(), null,false, true);
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
    * Método de UT timbrado versión 2 base64.
    */
    @Test
    public void testStampV2B64() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDIB64(true);
            StampResponseV2 response = stamp.timbrarV2(xml, settings.getCorreo(),null, false, true);
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
    * Método de UT timbrado versión 3 base64.
    */
    @Test
    public void testStampV3B64() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDIB64(true);
            StampResponseV3 response = stamp.timbrarV3(xml, settings.getCorreo(),null, false, true);
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
    * Método de UT timbrado versión 4 base64.
    */
    @Test
    public void testStampV4B64() {
        try {
            StampV4 stamp = new StampV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = settings.getCFDIB64(true);
            StampResponseV4 response = stamp.timbrarV4(xml, settings.getCorreo(),null, false, true);
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
