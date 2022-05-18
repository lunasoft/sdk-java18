package mx.com.sw.services.cfdi40;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.cfdi40.helpers.StampService;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
* Detallista131Test
* Clase para UT de los servicio de timbrado disponibles utilizando diferentes ejemplos con complemento de detallista.
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-28
*/
public class Detallista131Test {

    private StampService stampService = new StampService(false);

    /**
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento detallista mediante el servicio de timbrado versión 1
    * de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 1.
    */
    @Test
    public void testStampV1DetallistaResponseV1() {
        try {
            StampResponseV1 response = stampService.stampResponseV1(
                "resources/CFDI40/Detallista131/CFDI40_Detallista.xml",
                "V1", true, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento detallista mediante el servicio de timbrado versión 2
    * de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 2.
    */
    @Test
    public void testStampV2DetallistaResponseV2() {
        try {
            StampResponseV2 response = stampService.stampResponseV2(
                "resources/CFDI40/Detallista131/CFDI40_Detallista.xml",
                "V2", true, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento detallista mediante el servicio de timbrado versión 4
    * de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 3 en base64.
    */
    @Test
    public void testStampV4DetallistaResponseV3B64() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/Detallista131/CFDI40_Detallista.xml",
                "V4", true, true);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento detallista mediante el servicio de timbrado versión 1
    * sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 4.
    */
    @Test
    public void testIssueV1DetallistaResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/Detallista131/CFDI40_Detallista.xml",
                "IssueV1", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento detallista mediante el servicio de timbrado versión 2
    * sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 3 en base64.
    */
    @Test
    public void testIssueV2DetallistaResponseV3() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/Detallista131/CFDI40_Detallista.xml",
                "IssueV2", false, true);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento detallista mediante el servicio de timbrado versión 4
    * sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 4.
    */
    @Test
    public void testIssueV4DetallistaResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/Detallista131/CFDI40_Detallista.xml",
                "IssueV4", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento detallista mediante el
    * servicio de timbrado versión 1 (Json) de la librería sdk-java18 mediante usuario y
    * contraseña con respuesta versión 3.
    */
    @Test
    public void testIssueJsonV1DetallistaResponseV3() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/Detallista131/CFDI40_Detallista.json",
                "IssueJsonV1", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento detallista mediante el
    * servicio de timbrado versión 4 (Json) de la librería sdk-java18 mediante usuario y
    * contraseña con respuesta versión 4.
    */
    @Test
    public void testIssueJsonV4DetallistaResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/Detallista131/CFDI40_Detallista.json",
                "IssueJsonV4", false, false);
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
