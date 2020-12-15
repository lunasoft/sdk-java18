package mx.com.sw.services.pdf;

import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.pdf.responses.PdfResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * PdfTest Clase para UT del servicio de solicitud PDF.
 * 
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
     * Método de UT consume servicio genera PDF con token
     */
    @Test
    public void testGetPdfToken() {
        Pdf pdf = new Pdf(settings.getUrlServicesSW(), settings.getTokenSW(), null, 0);
        String xmlcontent = settings.getXmlTimbrado();
        PdfResponse response = pdf.getPdf(settings.getTemplateId(), xmlcontent, settings.getObservaciones());
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getData());
        Assertions.assertNotNull(response.getStatus());
        Assertions.assertNotNull(response.getData().getContentB64());
        Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        writePDF(response.getData().getContentB64());
    }

    /**
     * Método de UT consume servicio genera PDF
     */
    @Test
    public void testGetPdf() {
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
    }

    private void writePDF(String b64) {        
        try {
            Path path = Paths.get("resources/pdfresult.pdf");
            Files.write(path, Base64.getDecoder().decode(b64));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
