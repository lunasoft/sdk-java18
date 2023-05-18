package mx.com.sw.services.csd;

import java.util.List;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.csd.responses.CsdDataResponse;
import mx.com.sw.services.csd.responses.CsdListDataResponse;
import mx.com.sw.services.csd.responses.CsdResponse;
import mx.com.sw.services.csd.responses.CsdData;
import mx.com.sw.helpers.BuildSettings;

import org.junit.jupiter.api.Assertions;
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
    public void testUploadCsd_Auth_Error()
    {
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
    public void testUploadCsd_Token_Success(){
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
    public void testUploadCsd_Token_Error(){
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
    public void testUploadCsd_EmptyCsd()
    {
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
    public void testUploadCsd_EmptyKey()
    {
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
    public void testUploadCsd_EmptyPassword()
    {
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
    public void testUploadCsd_InvalidPassword()
    {
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
            Assertions.assertTrue("El certificado no pertenece a la llave privada.".equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsd_Success(){
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String NoCertificado = "30001000000400002463";
            CsdDataResponse response = csd.GetCsd(NoCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            System.out.println(response.getData().getIssuer_rfc());
            System.out.println(response.getData().getIssuer_business_name());
            System.out.println(response.getData().getCertificate_number());
            System.out.println(response.getData().getCertificate_type());
            System.out.println(response.getData().getIs_active());
            System.out.println(response.getData().getValid_from());
            System.out.println(response.getData().getValid_to());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
    
    @Test
    public void testGetCsd_Error(){
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String NoCertificado = "3000100000040";
            CsdDataResponse response = csd.GetCsd(NoCertificado);
            String Message = String.format("No se encontro certificado con el numero de certificado %s activo.", NoCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Certificados".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue(Message.equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsd_Token_Success(){
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW() , null, 0);
            String NoCertificado = "30001000000400002463";
            CsdDataResponse response = csd.GetCsd(NoCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            System.out.println(response.getData().getIssuer_rfc());
            System.out.println(response.getData().getIssuer_business_name());
            System.out.println(response.getData().getCertificate_number());
            System.out.println(response.getData().getCertificate_type());
            System.out.println(response.getData().getIs_active());
            System.out.println(response.getData().getValid_from());
            System.out.println(response.getData().getValid_to());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetCsd_Token_Error(){
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            String NoCertificado = "3000100000040";
            CsdDataResponse response = csd.GetCsd(NoCertificado);
            String Message = String.format("No se encontro certificado con el numero de certificado %s activo.", NoCertificado);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("error".equalsIgnoreCase(response.getStatus()));
            Assertions.assertTrue("Certificados".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue(Message.equalsIgnoreCase(response.getMessageDetail()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetAllCsd_Success(){
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            CsdListDataResponse response = csd.GetAllCsd();
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            List<CsdData> lista = response.getData();
            if(lista != null) {
                for(int i=0; i<lista.size(); i++) {
                    CsdData dato = lista.get(i);
                    System.out.println(dato.getIssuer_rfc());
                    System.out.println(dato.getIssuer_business_name());
                    System.out.println(dato.getCertificate_number());
                    System.out.println(dato.getCertificate_type());
                    System.out.println(dato.getIs_active());
                    System.out.println(dato.getValid_from());
                    System.out.println(dato.getValid_to());
                }
            }
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    @Test
    public void testGetAllCsd_Token_Success(){
        try {
            CsdUtils csd = new CsdUtils(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            CsdListDataResponse response = csd.GetAllCsd();
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
            List<CsdData> lista = response.getData();
            if(lista != null) {
                for(int i=0; i<lista.size(); i++) {
                    CsdData dato = lista.get(i);
                    System.out.println(dato.getIssuer_rfc());
                    System.out.println(dato.getIssuer_business_name());
                    System.out.println(dato.getCertificate_number());
                    System.out.println(dato.getCertificate_type());
                    System.out.println(dato.getIs_active());
                    System.out.println(dato.getValid_from());
                    System.out.println(dato.getValid_to());
                }
            }
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}