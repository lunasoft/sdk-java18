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
* CartaPorte20Test
* Clase para UT de los servicio de timbrado disponibles utilizando diferentes ejemplos con complemento de carta porte.
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-28
*/
public class CartaPorte20Test {

    private StampService stampService = new StampService(false);

    /**
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento carta porte de tipo autotransporte mediante el
    * servicio de timbrado versión 1 de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 1.
    */
    @Test
    public void testStampV1IngresoCartaPorteAutotransporteResponseV1() {
        try {
            StampResponseV1 response = stampService.stampResponseV1(
                "resources/CFDI40/CartaPorte20/CFDI40_Ingreso_CartaPorte_Autotransporte.xml", "V1", true, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento carta porte de tipo transporte ferroviario mediante
    * el servicio de timbrado versión 2 de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 2.
    */
    @Test
    public void testStampV2IngresoCartaPorteTransporteFerroviarioResponseV2() {
        try {
            StampResponseV2 response = stampService.stampResponseV2(
                "resources/CFDI40/CartaPorte20/CFDI40_Ingreso_CartaPorte_TransporteFerroviario.xml", "V2", true, false);
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento carta porte de tipo transporte aéreo mediante el
    * servicio de timbrado versión 4 de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 3
    * en base64.
    */
    @Test
    public void testStampV4IngresoCartaPorteTransporteAereoResponseV3B64() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/CartaPorte20/CFDI40_Ingreso_CartaPorte_TransporteAereo.xml", 
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento carta porte de tipo transporte marítimo mediante el
    * servicio de timbrado versión 4 de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 4.
    */
    @Test
    public void testStampV4IngresoCartaPorteTransporteMaritimoResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/CartaPorte20/CFDI40_Ingreso_CartaPorte_TransporteMaritimo.xml", "V4", true, false);
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
    * Timbrado de CFDI versión 4.0 de tipo traslado con complemento carta porte de tipo autotransporte marítimo mediante
    * el servicio de timbrado versión 1 sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña con
    * respuesta versión 1.
    */
    @Test
    public void testIssueV1TrasladoCartaPorteAutotransporteResponseV1() {
        try {
            StampResponseV1 response = stampService.stampResponseV1(
                "resources/CFDI40/CartaPorte20/CFDI40_Traslado_CartaPorte_Autotransporte.xml", "IssueV1", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo traslado con complemento carta porte de tipo transporte aéreo mediante
    * el servicio de timbrado versión 2 sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña
    * con respuesta versión 2.
    */
    @Test
    public void testIssueV2TrasladoCartaPorteTransporteAereoResponseV2() {
        try {
            StampResponseV2 response = stampService.stampResponseV2(
                "resources/CFDI40/CartaPorte20/CFDI40_Traslado_CartaPorte_TransporteAereo.xml",
                "IssueV2", false, false);
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
    * Timbrado de CFDI versión 4.0 de tipo traslado con complemento carta porte de tipo transporte ferroviario
    * mediante el servicio de timbrado versión 4 sin sellar (Issue) de la librería sdk-java18 mediante usuario
    * y contraseña con respuesta versión 3.
    */
    @Test
    public void testIssueV4TrasladoCartaPorteTransporteFerroviarioResponseV3() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/CartaPorte20/CFDI40_Traslado_CartaPorte_TransporteFerroviario.xml",
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
    * Timbrado de CFDI versión 4.0 de tipo traslado con complemento carta porte de tipo transporte marítimo mediante
    * el servicio de timbrado versión 4 sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña
    * con respuesta versión 4.
    */
    @Test
    public void testIssueV4TrasladoCartaPorteTransporteMaritimoResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/CartaPorte20/CFDI40_Traslado_CartaPorte_TransporteMaritimo.xml",
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento carta porte de tipo autotransporte mediante
    * el servicio de timbrado versión 1 (Json) de la librería sdk-java18 mediante usuario y contraseña con
    * respuesta versión 1.
    */
    @Test
    public void testIssueJsonV1IngresoCartaPorteAutotransporteResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/CartaPorte20/CFDI40_Ingreso_CartaPorte_Autotransporte.json",
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
    * Timbrado de CFDI versión 4.0 de tipo ingreso con complemento carta porte de tipo transporte ferroviario
    * mediante el servicio de timbrado versión 4 (Json) de la librería sdk-java18 mediante usuario y contraseña
    * con respuesta versión 4.
    */
    @Test
    public void testIssueJsonV4IngresoCartaPorteTransporteFerroviarioResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/CartaPorte20/CFDI40_Ingreso_CartaPorte_TransporteFerroviario.json",
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

    /**
    * Timbrado de CFDI versión 4.0 de tipo traslado con complemento carta porte de tipo autotransporte
    * mediante el servicio de timbrado versión 4 (Json) de la librería sdk-java18 mediante usuario y
    * contraseña con respuesta versión 4.
    */
    @Test
    public void testIssueJsonV4TrasladoCartaPorteAutotransporteResponseV4B64() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/CartaPorte20/CFDI40_Traslado_CartaPorte_Autotransporte.json",
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
