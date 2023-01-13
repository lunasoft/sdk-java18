package mx.com.sw.services.Validate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.Validate.responses.ValidateDetailData;
import mx.com.sw.services.Validate.responses.ValidateNodeDetail;
import mx.com.sw.services.Validate.responses.ValidateResponse;

/**
 * ValidateTest Clase para UT del servicio de validacion de CFDI.
 */
public class ValidateTest {
    private final BuildSettings settings;

    /**
     * Constructor de la clase.
     */
    public ValidateTest() {
        this.settings = new BuildSettings();
    }

    /**
     * Método de UT consume el servicio de validacion de XML mediante token.
     */
    @Test
    public void testValidateXml_Success(){
        try {
            String xml = settings.getCFDI(true);
            Validate api = new Validate(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            ValidateResponse response = api.ValidateXML(xml);
            Assertions.assertNotNull(response);
            Assertions.assertTrue("Success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     *  Método  de UT consume el servicio de validacion de XML mediante usuario y contraseña.
     */
    @Test
    public void testValidateXml_AuthSuccess(){
        try {
            String xml = settings.getCFDI(true);
            Validate api = new Validate(settings.getUrlSW(),settings.getUserSW(), settings.getPasswordSW(), null, 0);
            ValidateResponse response = api.ValidateXML(xml);
            Assertions.assertNotNull(response);
            Assertions.assertTrue("Success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT consume el servicio de validacion de XML mediante token e imprime todos los datos.
     */
    @Test
    public void testValidateXml_SuccessComplete(){
        try {
            String xml = settings.getCFDI(true);
            Validate api = new Validate(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            ValidateResponse response = api.ValidateXML(xml);
            Assertions.assertNotNull(response);
            List<ValidateNodeDetail> List = response.getDetail();
            for(int i=0; i<List.size();i++){
                ValidateNodeDetail node = List.get(i);
                List<ValidateDetailData> ListData = node.getDetailData();
                for(int j=0; j<ListData.size();j++){
                    ValidateDetailData data = ListData.get(j);
                    System.out.println("\t\t"+data.getMessage());
                    System.out.println("\t\t"+data.getMessageDetail());
                    System.out.println("\t\t"+data.getType());
                }
                System.out.println("\t"+node.getSection());
            }
            System.out.println(response.getCadenaOriginalComprobante());
            System.out.println(response.getCadenaOriginalSAT());
            System.out.println(response.getUuid());
            System.out.println(response.getStatusSat());
            System.out.println(response.getStatusCodeSat());
            Assertions.assertTrue("Success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     *  Método  de UT consume el servicio de validacion de XML, Error con usuario
     */
    @Test
    public void testValidateXml_ErrorUser(){
        try {
            String xml = settings.getCFDI(true);
            Validate api = new Validate(settings.getUrlSW(), null , settings.getPasswordSW(), null, 0);
            ValidateResponse response = api.ValidateXML(xml);
            Assertions.assertNotNull(response);
            Assertions.assertTrue("Error".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     *  Método  de UT consume el servicio de validacion de XML, Error con el XML nulo
     */
    @Test
    public void testValidateXml_ErrorXML(){
        try {
            Validate api = new Validate(settings.getUrlSW(),settings.getUserSW(), settings.getPasswordSW(), null, 0);
            ValidateResponse response = api.ValidateXML(null);
            Assertions.assertNotNull(response);
            Assertions.assertTrue("301 - La estructura del comprobante es incorrecta.".equalsIgnoreCase(response.getMessage()));
            Assertions.assertTrue("Error".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
