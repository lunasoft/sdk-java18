package mx.com.sw.services.cfdi40;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.cfdi40.helpers.StampService;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

/**
* INE11Test
* Clase para UT de los servicio de timbrado disponibles utilizando diferentes ejemplos con complemento de INE
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-28
*/
public class INE11Test {
    
    StampService stampService = new StampService(false);

    /**
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento INE mediante el servicio de timbrado versión 1 de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 1
    */
    @Test
    public void testStampV1INEResponseV1() {
        try {            
            StampResponseV1 response = stampService.StampResponseV1("resources/CFDI40/INE11/CFDI40_INE.xml", "V1", true, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento INE mediante el servicio de timbrado versión 2 de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 2
    */
    @Test
    public void testStampV2INEResponseV2() {
        try {            
            StampResponseV2 response = stampService.StampResponseV2("resources/CFDI40/INE11/CFDI40_INE.xml", "V2", true, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento INE mediante el servicio de timbrado versión 4 de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 3 en base64
    */
    @Test
    public void testStampV4INEResponseV3B64() {
        try {            
            StampResponseV3 response = stampService.StampResponseV3("resources/CFDI40/INE11/CFDI40_INE.xml", "V4", true, true);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento INE mediante el servicio de timbrado versión 1 sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 4
    */
    @Test
    public void testIssueV1INEResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/INE11/CFDI40_INE.xml", "IssueV1", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento INE mediante el servicio de timbrado versión 2 sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 3 en base64
    */
    @Test
    public void testIssueV2INEResponseV3() {
        try {            
            StampResponseV3 response = stampService.StampResponseV3("resources/CFDI40/INE11/CFDI40_INE.xml", "IssueV2", false, true);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento INE mediante el servicio de timbrado versión 4 sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 4
    */
    @Test
    public void testIssueV4INEResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/INE11/CFDI40_INE.xml", "IssueV4", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento INE mediante el servicio de timbrado versión 1 (Json) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 3 
    */
    @Test
    public void testIssueJsonV1INEResponseV3() {
        try {            
            StampResponseV3 response = stampService.StampResponseV3("resources/CFDI40/INE11/CFDI40_INE.json", "IssueJsonV1", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento INE mediante el servicio de timbrado versión 4 (Json) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 4
    */
    @Test
    public void testIssueJsonV4INEResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/INE11/CFDI40_INE.json", "IssueJsonV4", false, false);
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
