package mx.com.sw.services.csd;

import java.util.List;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.csd.responses.CsdResponse;
import mx.com.sw.services.csd.responses.CsdData;
import mx.com.sw.services.csd.responses.CsdDataResponse;
import mx.com.sw.services.csd.responses.CsdListDataResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
* CsdTest
* Clase para UT del servicio de Certificados (CSD).
*/
public class CsdTest {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public CsdTest() {
        this.settings = new BuildSettings();
    }

    @Test
    public void testUploadCsd_Auth_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String csdBase64 = settings.getCSD();
            String keyBase64 = settings.getKey();
            String password = settings.getPasswordCSD();
            CsdResponse response = csd.UploadCsd(csdBase64, keyBase64, password);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.data);
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testUploadCsd_Auth_Error() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), "user", settings.getPasswordSW(), null, 0);
            String csdBase64 = settings.getCSD();
            String keyBase64 = settings.getKey();
            String password = settings.getPasswordCSD();
            CsdResponse response = csd.UploadCsd(csdBase64, keyBase64, password);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testUploadCsd_Token_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String csdBase64 = settings.getCSD();
            String keyBase64 = settings.getKey();
            String password = settings.getPasswordCSD();
            CsdResponse response = csd.UploadCsd(csdBase64, keyBase64, password);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.data);
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testUploadCsd_Token_Error() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), "T2lYQ0t4L0RHVk...", null, 0);
            String csdBase64 = settings.getCSD();
            String keyBase64 = settings.getKey();
            String password = settings.getPasswordCSD();
            CsdResponse response = csd.UploadCsd(csdBase64, keyBase64, password);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testUploadCsd_EmptyCsd() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String csdBase64 = "";
            String keyBase64 = settings.getKey();
            String password = settings.getPasswordCSD();
            CsdResponse response = csd.UploadCsd(csdBase64, keyBase64, password);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("El certificado viene vacio".equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testUploadCsd_EmptyKey() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String csdBase64 = settings.getCSD();
            String keyBase64 = "";
            String password = settings.getPasswordCSD();
            CsdResponse response = csd.UploadCsd(csdBase64, keyBase64, password);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("La llave privada viene vacia".equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testUploadCsd_EmptyPassword() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String csdBase64 = settings.getCSD();
            String keyBase64 = settings.getKey();
            String password = "";
            CsdResponse response = csd.UploadCsd(csdBase64, keyBase64, password);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("El password viene vacio".equalsIgnoreCase(response.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testUploadCsd_InvalidPassword() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String csdBase64 = settings.getCSD();
            String keyBase64 = settings.getKey();
            String password = "password";
            CsdResponse response = csd.UploadCsd(csdBase64, keyBase64, password);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Certificados".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue("El certificado no pertenece a la llave privada."
                    .equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsd_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String noCertificado = "30001000000400002434";
            CsdDataResponse response = csd.GetCsd(noCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            System.out.println(response.getData().getIssuerRfc());
            System.out.println(response.getData().getIssuerBusinessName());
            System.out.println(response.getData().getCertificateNumber());
            System.out.println(response.getData().getCsdCertificate());
            System.out.println(response.getData().getCertificateType());
            System.out.println(response.getData().getIsActive());
            System.out.println(response.getData().getValidFrom());
            System.out.println(response.getData().getValidTo());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsd_Error() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String noCertificado = "3000100000040";
            CsdDataResponse response = csd.GetCsd(noCertificado);
            String message = String.format("No se encontro certificado con el numero de certificado %s activo.",
                    noCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Certificados".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue(message.equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsd_Token_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String noCertificado = "30001000000400002434";
            CsdDataResponse response = csd.GetCsd(noCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            System.out.println(response.getData().getIssuerRfc());
            System.out.println(response.getData().getIssuerBusinessName());
            System.out.println(response.getData().getCertificateNumber());
            System.out.println(response.getData().getCsdCertificate());
            System.out.println(response.getData().getCertificateType());
            System.out.println(response.getData().getIsActive());
            System.out.println(response.getData().getValidFrom());
            System.out.println(response.getData().getValidTo());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsd_Token_Error() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String noCertificado = "3000100000040";
            CsdDataResponse response = csd.GetCsd(noCertificado);
            String message = String.format("No se encontro certificado con el numero de certificado %s activo.",
                    noCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Certificados".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue(message.equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsdByRfc_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String rfc = "EKU9003173C9";
            CsdListDataResponse response = csd.GetCsdByRfc(rfc);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull("success".equalsIgnoreCase(response.getStatus()));
            List<CsdData> lista = response.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    CsdData dato = lista.get(i);
                    System.out.println(dato.getIssuerRfc());
                    System.out.println(dato.getIssuerBusinessName());
                    System.out.println(dato.getCertificateNumber());
                    System.out.println(dato.getCsdCertificate());
                    System.out.println(dato.getCertificateType());
                    System.out.println(dato.getIsActive());
                    System.out.println(dato.getValidFrom());
                    System.out.println(dato.getValidTo());
                }
            }
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsdByRfc_Error() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String rfc = "MYRFC";
            CsdListDataResponse response = csd.GetCsdByRfc(rfc);
            String message = String.format("El Rfc proporcionado es invalido. Favor de verificar.");
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Certificados".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue(message.equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsdByRfc_Token_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String rfc = "EKU9003173C9";
            CsdListDataResponse response = csd.GetCsdByRfc(rfc);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull("success".equalsIgnoreCase(response.getStatus()));
            List<CsdData> lista = response.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    CsdData dato = lista.get(i);
                    System.out.println(dato.getIssuerRfc());
                    System.out.println(dato.getIssuerBusinessName());
                    System.out.println(dato.getCertificateNumber());
                    System.out.println(dato.getCsdCertificate());
                    System.out.println(dato.getCertificateType());
                    System.out.println(dato.getIsActive());
                    System.out.println(dato.getValidFrom());
                    System.out.println(dato.getValidTo());
                }
            }
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsdByRfc_Token_Error() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String rfc = "MYRFC";
            CsdListDataResponse response = csd.GetCsdByRfc(rfc);
            String message = String.format("El Rfc proporcionado es invalido. Favor de verificar.");
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Certificados".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue(message.equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetAllCsd_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            CsdListDataResponse response = csd.GetAllCsd();
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            List<CsdData> lista = response.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    CsdData dato = lista.get(i);
                    System.out.println(dato.getIssuerRfc());
                    System.out.println(dato.getIssuerBusinessName());
                    System.out.println(dato.getCertificateNumber());
                    System.out.println(dato.getCsdCertificate());
                    System.out.println(dato.getCertificateType());
                    System.out.println(dato.getIsActive());
                    System.out.println(dato.getValidFrom());
                    System.out.println(dato.getValidTo());
                }
            }
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetAllCsd_Token_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            CsdListDataResponse response = csd.GetAllCsd();
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            List<CsdData> lista = response.getData();
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    CsdData dato = lista.get(i);
                    System.out.println(dato.getIssuerRfc());
                    System.out.println(dato.getIssuerBusinessName());
                    System.out.println(dato.getCertificateNumber());
                    System.out.println(dato.getCsdCertificate());
                    System.out.println(dato.getCertificateType());
                    System.out.println(dato.getIsActive());
                    System.out.println(dato.getValidFrom());
                    System.out.println(dato.getValidTo());
                }
            }
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Disabled("Número de certificado no disponible en la cuenta de pruebas")
    @Test
    public void testDeleteCsd_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String noCertificado = "30001000000400002463";
            String message = String.format("Certificado %s desactivado.", noCertificado);
            CsdResponse response = csd.DeleteCsd(noCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.data);
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue(message.equalsIgnoreCase(response.data));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Disabled("Número de certificado no disponible en la cuenta de pruebas")
    @Test
    public void testDeleteCsd_Token_Success() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String noCertificado = "30001000000400002463";
            String message = String.format("Certificado %s desactivado.", noCertificado);
            CsdResponse response = csd.DeleteCsd(noCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.data);
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue(message.equalsIgnoreCase(response.data));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testDeleteCsd_Error() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String noCertificado = "3000100000040";
            CsdResponse response = csd.DeleteCsd(noCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Certificados".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue("One or more errors occurred.".equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testDeleteCsd_Token_Error() {
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String noCertificado = "3000100000040";
            CsdResponse response = csd.DeleteCsd(noCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Certificados".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue("One or more errors occurred.".equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
