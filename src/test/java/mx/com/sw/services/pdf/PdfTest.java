package mx.com.sw.services.pdf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.pdf.responses.PdfResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * PdfTest Clase para UT del servicio de solicitud PDF.
 * @author Manuel Castillo
 * @version 0.0.0.1
 * @since 2020-12-15
 */
public class PdfTest {
    private final BuildSettings settings;

    /**
     * Constructor de la clase.
     */
    public PdfTest() {
        this.settings = new BuildSettings();
    }

    /**
     * Método de UT consume servicio genera PDF con token.
     */
    @Test
    public void testGetPdfToken() {
        try {
            Pdf pdf = new Pdf(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            String xmlcontent = settings.getXmlTimbrado();
            PdfResponse response = pdf.getPdf(settings.getTemplateId(), xmlcontent, settings.getObservaciones());
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getContentB64());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            writePDF(response.getData().getContentB64());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT consume servicio genera PDF.
     */
    @Test
    public void testGetPdf() {
        try {
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            String xmlcontent = settings.getXmlTimbrado();
            PdfResponse response = pdf.getPdf(settings.getTemplateId(), xmlcontent, settings.getObservaciones());
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getContentB64());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            writePDF(response.getData().getContentB64());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT consume servicio genera PDF.
     */
    @Test
    public void testGetPdfUT1() {
        try {
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            String xmlcontent = settings.getXmlTimbrado();
            PdfResponse response = pdf.getPdf(xmlcontent);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getContentB64());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            writePDF(response.getData().getContentB64());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT consume servicio genera PDF, con CFDI + template.
     */
    @Test
    public void testGetPdfUT2() {
        try {
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            String xmlcontent = settings.getXmlTimbrado();
            PdfResponse response = pdf.getPdf(settings.getTemplateId(), xmlcontent);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getContentB64());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            writePDF(response.getData().getContentB64());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT consume servicio genera PDF, con CFDI + datos extra.
     */
    @Test
    public void testGetPdfUT3() {
        try {
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            String xmlcontent = settings.getXmlTimbrado();
            PdfResponse response = pdf.getPdf(xmlcontent, settings.getObservaciones());
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getContentB64());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            writePDF(response.getData().getContentB64());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT consume servicio genera PDF, valida URL nulo.
     */
    @Test
    public void testGetPdfUT4() {
        try {
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            PdfResponse response = pdf.getPdf(null);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT consume servicio genera PDF, valida URL nulo.
     */
    @Test
    public void testGetPdfUT5() {
        try {
            new Pdf(null, settings.getUrlServicesSW(), settings.getUserSW(),
                settings.getPasswordSW(), null, 0);
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
            Assertions.assertTrue("Falta Capturar URL".equalsIgnoreCase(ex.getMessage()));
        }
    }

    /**
     * Método de UT consume servicio genera PDF, valida URL nulo.
     */
    @Test
    public void testGetPdfUT6() {
        try {
            new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), null,
                settings.getPasswordSW(), null, 0);
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
            Assertions.assertTrue("Falta Capturar Usuario".equalsIgnoreCase(ex.getMessage()), ex.getMessage());
        }
    }

    /**
     * Método de UT consume servicio genera PDF, valida URL nulo.
     */
    @Test
    public void testGetPdfUT7() {
        try {
            String msgError = "AU2000 - El usuario y/o contraseña son inválidos, no se puede autenticar el servicio.";
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), "usertest",
                settings.getPasswordSW(), null, 0);
            String xmlcontent = settings.getXmlTimbrado();
            PdfResponse response = pdf.getPdf(xmlcontent);
            Assertions.assertNotNull(response);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue(msgError.equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    private void writePDF(String b64) {
        try {
            Path path = Paths.get("resources/pdfresult.pdf");
            Files.write(path, Base64.getDecoder().decode(b64));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------
    //Pruebas unitarias del metodo Regenerar PDF
    //-------------------------------------------
    /**
     * Método de UT consume servicio regenerar PDF, con token.
     */
    @Test
    public void testRegeneratePdf_Success(){
        try {
            Pdf pdf = new Pdf(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
            PdfResponse response = pdf.regeneratePdf(UUID.fromString("5bb78a5c-9fd7-4100-8fac-9b51b585e22f"));
            Assertions.assertNotNull(response);
            Assertions.assertTrue(!response.getMessage().isEmpty());
            Assertions.assertTrue("Success".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Solicitud se proceso correctamente.".equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    /**
     * Método de UT consume servicio regenerar PDF, con Usuario y contraseña.
     */
    @Test
    public void testRegeneratePdf_AuthSuccess(){
        try {
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), settings.getUserSW(),settings.getPasswordSW(), null, 0);
            PdfResponse response = pdf.regeneratePdf(UUID.fromString("5bb78a5c-9fd7-4100-8fac-9b51b585e22f"));
            Assertions.assertNotNull(response);
            Assertions.assertTrue(!response.getMessage().isEmpty());
            Assertions.assertTrue("Success".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Solicitud se proceso correctamente.".equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    /**
     * Método de UT consume servicio regenerar PDF, error en el usuario.
     */
    @Test
    public void testRegeneratePdf_ErrorAuth(){
        try {
            String msgError = "AU2000 - El usuario y/o contraseña son inválidos, no se puede autenticar el servicio.";
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), "user",settings.getPasswordSW(), null, 0);
            PdfResponse response = pdf.regeneratePdf(UUID.fromString("5bb78a5c-9fd7-4100-8fac-9b51b585e22f"));
            Assertions.assertNotNull(response);
            Assertions.assertTrue(!response.getMessage().isEmpty());
            Assertions.assertTrue("Error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue(msgError.equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    /**
     * Método de UT consume servicio regenerar PDF, Error con el UUID no encontrado.
     */
    @Test
    public void testRegeneratePdf_ErrorUUIDNull(){
        try {
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(),  settings.getUserSW(),settings.getPasswordSW(), null, 0);
            PdfResponse response = pdf.regeneratePdf(null);
            Assertions.assertNotNull(response);
            Assertions.assertTrue("Error".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    /**
     * Método de UT consume servicio regenerar PDF, Error con el UUID no encontrado.
     */
    @Test
    public void testRegeneratePdf_ErrorUUID(){
        try {
            Pdf pdf = new Pdf(settings.getUrlSW(), settings.getUrlServicesSW(), settings.getUserSW(),settings.getPasswordSW(), null, 0);
            PdfResponse response = pdf.regeneratePdf(UUID.fromString("21348cb0-a94a-466c-a8e0-abef7f35a71b"));
            Assertions.assertNotNull(response);
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue(!response.getMessage().isEmpty());
            Assertions.assertTrue("No se encontro el UUID.".equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
