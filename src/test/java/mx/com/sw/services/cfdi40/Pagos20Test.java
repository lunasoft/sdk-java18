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
* Pagos20Test
* Clase para UT de los servicio de timbrado disponibles utilizando diferentes ejemplos con complemento de pagos
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-29
*/
public class Pagos20Test {
    
    StampService stampService = new StampService(false);

    /**
    * Timbrado de CFDI versión 4.0 de tipo pago mediante el servicio de timbrado versión 1 de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 1
    */
    @Test
    public void testStampV1PagoResponseV1() {
        try {            
            StampResponseV1 response = stampService.StampResponseV1("resources/CFDI40/Pagos20/CFDI40_Pago.xml", "V1", true, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }

    /**
    * Timbrado de CFDI versión 4.0 de tipo pago con moneda de pago en USD y monda del documento relacionado en MXN mediante el servicio de timbrado versión 2 de la libreria sdk-java18 mediante usuario y contraseña con respuesta versión 2
    */
    @Test
    public void testStampV2PagoDolarResponseV2() {
        try {            
            StampResponseV2 response = stampService.StampResponseV2("resources/CFDI40/Pagos20/CFDI40_Pago_Dolar.xml", "V2", true, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }

    /**
    * Timbrado de CFDI versión 4.0 de tipo pago con moneda de pago en MXN y monda del documento relacionado en USD mediante el servicio de timbrado versión 4 de la libreria sdk-java18 mediante usuario y contraseña con respuesta versión 3 en base64
    */
    @Test
    public void testStampV4PagoDoctoRelacionadoEnDolarResponseV3B64() {
        try {            
            StampResponseV3 response = stampService.StampResponseV3("resources/CFDI40/Pagos20/CFDI40_Pago_DoctoRelacionadoEnDolar.xml", "V4", true, true);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }
    
    /**
    * Timbrado de CFDI versión 4.0 de tipo pago con moneda de pago en EUR y monda del documento relacionado en USD mediante el servicio de timbrado versión 1 sin sellar (Issue) de la libreria sdk-java18 mediante usuario y contraseña con respuesta versión 4
    */
    @Test
    public void testIssueV1PagoEURyDRenUSDResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/Pagos20/CFDI40_Pago_EURyDRenUSD.xml", "IssueV1", false, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }
    
    /**
    * Timbrado de CFDI versión 4.0 de tipo pago con dos monedas de pago distintas y monda del documento relacionado en USD mediante el servicio de timbrado versión 2 sin sellar (Issue) de la libreria sdk-java18 mediante usuario y contraseña con respuesta versión 3
    */
    @Test
    public void testIssueV2PagoMonedasDistintasyDRenUSDResponseV3() {
        try {            
            StampResponseV3 response = stampService.StampResponseV3("resources/CFDI40/Pagos20/CFDI40_Pago_MonedasDistintasyDRenUSD.xml", "IssueV2", false, true);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }
    
    /**
    * Timbrado de CFDI versión 4.0 de tipo pago con con Factoraje mediante el servicio de timbrado versión 4 sin sellar (Issue) de la libreria sdk-java18 mediante usuario y contraseña con respuesta versión 4
    */
    @Test
    public void testIssueV4PagoFactorajeResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/Pagos20/CFDI40_Pago_Factoraje.xml", "IssueV4", false, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }
        
    /**
    * Timbrado de CFDI versión 4.0 de tipo pago mediante el servicio de timbrado versión 1 (Json) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 1
    */
    @Test
    public void testIssueJsonV1PagoResponseV1() {
        try {            
            StampResponseV1 response = stampService.StampResponseV1("resources/CFDI40/Pagos20/CFDI40_Pago.json", "IssueJsonV1", false, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }

    /**
    * Timbrado de CFDI versión 4.0 de tipo pago con moneda de pago en USD y monda del documento relacionado en MXN mediante el servicio de timbrado versión 4 (Json) de la libreria sdk-java18 mediante usuario y contraseña con respuesta versión 2
    */
    @Test
    public void testIssueJsonV4PagoDolarResponseV2() {
        try {            
            StampResponseV2 response = stampService.StampResponseV2("resources/CFDI40/Pagos20/CFDI40_Pago_Dolar.json", "IssueJsonV4", false, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getTFD());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }

    /**
    * Timbrado de CFDI versión 4.0 de tipo pago con moneda de pago en EUR y monda del documento relacionado en USD mediante el servicio de timbrado versión 1 (Json) de la libreria sdk-java18 mediante usuario y contraseña con respuesta versión 3
    */
    @Test
    public void testIssueJsonV1PagoEURyDRenUSDResponseV3() {
        try {            
            StampResponseV3 response = stampService.StampResponseV3("resources/CFDI40/Pagos20/CFDI40_Pago_EURyDRenUSD.json", "IssueJsonV1", false, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }
    
    /**
    * Timbrado de CFDI versión 4.0 de tipo pago con dos monedas de pago distintas y monda del documento relacionado en USD mediante el servicio de timbrado versión 4 (Json) de la libreria sdk-java18 mediante usuario y contraseña con respuesta versión 4
    */
    @Test
    public void testIssueV4PagoMonedasDistintasyDRenUSDResponseV4() {
        try {            
            StampResponseV4 response = stampService.StampResponseV4("resources/CFDI40/Pagos20/CFDI40_Pago_MonedasDistintasyDRenUSD.json", "IssueJsonV4", false, false);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getData());
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertNotNull(response.getData().getCFDI());
            Assertions.assertTrue("success".equalsIgnoreCase(response.getStatus()));
        } catch (ServicesException ex) {
            Assertions.fail(ex.getMessage());
        }
    }
}
