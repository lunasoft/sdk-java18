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
* CFDI40Test
* Clase para UT de los servicio de timbrado disponibles utilizando diferentes ejemplos de CFDI 4.0
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-28
*/
public class CFDI40Test {
    
    StampService stampService = new StampService(false);
    StampService stampServiceToken = new StampService(true);

    /**
    * Timbrado de CFDI versión 4.0 de tipo ingreso mediante el servicio de timbrado versión 1 de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 1
    */
    @Test
    public void testStampV1IngresoResponseV1() {
        try {            
            StampResponseV1 response = stampService.StampResponseV1("resources/CFDI40/CFDI40/CFDI40_Ingreso.xml", "V1", true, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con nodo parte mediante el servicio de timbrado versión 2 de la libreria sdk-java18 mediante Token con respuesta versión 2
    */
    @Test
    public void testStampV2IngresoKitParteResponseV2() {
        try {            
            StampResponseV2 response = stampServiceToken.StampResponseV2("resources/CFDI40/CFDI40/CFDI40_Ingreso_KitParte.xml", "V2", true, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con nodo ACuentaTerceros mediante el servicio de timbrado versión 4 de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 3 en base64
    */
    @Test
    public void testStampV4IngresoACuentaTercerosResponseV3B64() {
        try {            
            StampResponseV3 response = stampService.StampResponseV3("resources/CFDI40/CFDI40/CFDI40_Ingreso_ACuentaTerceros.xml", "V4", true, true);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso global mediante el servicio de timbrado versión 1 sin sellar (Issue) de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 4
    */
    @Test
    public void testIssueV1IngresoGlobalResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/CFDI40/CFDI40_Ingreso_Global.xml", "IssueV1", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso global extranjero mediante el servicio de timbrado versión 2 sin sellar (Issue) de la libreria sdk-java18 mediante Token con respuesta versión 4 en base64
    */
    @Test
    public void testIssueV2IngresoGlobalExtranjeroResponseV2() {
        try {            
            StampResponseV2 response = stampServiceToken.StampResponseV2("resources/CFDI40/CFDI40/CFDI40_Ingreso_GlobalExtranjero.xml", "IssueV2", false, true);
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
    * Timbrado de CFDI versión 4.0 de tipo egreso mediante el servicio de timbrado versión 4 sin sellar (Issue) de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 4
    */
    @Test
    public void testIssueV4EgresoNotaDeCreditoResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/CFDI40/CFDI40_Egreso_NotaDeCredito.xml", "IssueV4", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo traslado mediante el servicio de timbrado versión 4 sin sellar (Issue) de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 4 en base64
    */
    @Test
    public void testIssueV4TrasladoResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/CFDI40/CFDI40_Traslado.xml", "IssueV4", false, true);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso mediante el servicio de timbrado versión 1 (Json) de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 1
    */
    @Test
    public void testIssueJsonV1IngresoResponseV1() {
        try {            
            StampResponseV1 response = stampService.StampResponseV1("resources/CFDI40/CFDI40/CFDI40_Ingreso.json", "IssueJsonV1", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con nodo parte mediante el servicio de timbrado versión 4 (Json) de la libreria sdk-java18 mediante Token con respuesta versión 2
    */
    @Test
    public void testIssueJsonV4IngresoKitParteResponseV2() {
        try {            
            StampResponseV2 response = stampServiceToken.StampResponseV2("resources/CFDI40/CFDI40/CFDI40_Ingreso_KitParte.json", "IssueJsonV4", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con nodo ACuentaTerceros mediante el servicio de timbrado versión 1 (Json) de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 3
    */
    @Test
    public void testIssueJsonV1IngresoACuentaTercerosResponseV3B64() {
        try {            
            StampResponseV3 response = stampService.StampResponseV3("resources/CFDI40/CFDI40/CFDI40_Ingreso_ACuentaTerceros.json", "IssueJsonV1", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso global mediante el servicio de timbrado versión 4 (Json) de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 4
    */
    @Test
    public void testIssueJsonV4IngresoGlobalResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/CFDI40/CFDI40_Ingreso_Global.json", "IssueJsonV4", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso global extranjero mediante el servicio de timbrado versión 1 (Json) de la libreria sdk-java18 mediante Token con respuesta versión 4 
    */
    @Test
    public void testIssueJsonV1IngresoGlobalExtranjeroResponseV4() {
        try {            
            StampResponseV4 response = stampServiceToken.StampResponseV4("resources/CFDI40/CFDI40/CFDI40_Ingreso_GlobalExtranjero.json", "IssueJsonV1", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo egreso mediante el servicio de timbrado versión 4 (Json) de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 4
    */
    @Test
    public void testIssueJsonV4EgresoNotaDeCreditoResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/CFDI40/CFDI40_Egreso_NotaDeCredito.json", "IssueJsonV4", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo traslado mediante el servicio de timbrado versión 4 (Json) de la libreria sdk-java18 mediante usuario y contrasena con respuesta versión 4
    */
    @Test
    public void testIssueJsonV4TrasladoResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/CFDI40/CFDI40_Traslado.json", "IssueJsonV4", false, false);
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
