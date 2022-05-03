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
* Nomina12Test
* Clase para UT de los servicio de timbrado disponibles utilizando diferentes ejemplos con complemento de nomina.
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-29
*/
public class Nomina12Test {

    private StampService stampService = new StampService(false);

    /**
    * Timbrado de CFDI versión 4.0 con complemento de nómina mediante el servicio de timbrado versión 1
    * de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 1.
    */
    @Test
    public void testStampV1NominaResponseV1() {
        try {
            StampResponseV1 response = stampService.stampResponseV1("resources/CFDI40/Nomina12/CFDI40_Nomina.xml",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina extraordinaria mediante el servicio de timbrado versión 2
    * de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 2.
    */
    @Test
    public void testStampV2NominaExtraordinariaResponseV2() {
        try {
            StampResponseV2 response = stampService.stampResponseV2(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_Extraordinaria.xml",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina con horas extra mediante el servicio de timbrado versión 4
    * de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 3 en base64.
    */
    @Test
    public void testStampV4NominaHorasExtraResponseV3B64() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_HorasExtra.xml",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina con incapacidades mediante el servicio de
    * timbrado versión 1 sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña con
    * respuesta versión 4.
    */
    @Test
    public void testIssueV1NominaIncapacidadesResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_Incapacidades.xml",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina jubilación pensión retiro mediante el servicio
    * de timbrado versión 2 sin sellar (Issue) de la librería sdk-java18 mediante usuario y contraseña con
    * respuesta versión 3.
    */
    @Test
    public void testIssueV2NominaJubilacionPensionRetiroResponseV3() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_JubilacionPensionRetiro.xml",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina jubilación pensión retiro mediante el
    * servicio de timbrado versión 4 sin sellar (Issue) de la librería sdk-java18 mediante usuario
    * y contraseña con respuesta versión 4 en base64.
    */
    @Test
    public void testIssueV4NominaJubilacionPensionRetiro2ResponseV4B64() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_JubilacionPensionRetiro2.xml",
                "IssueV4", false, true);
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina separación indemnización mediante el
    * servicio de timbrado versión 1 de la librería sdk-java18 mediante usuario y contraseña con
    * respuesta versión 3.
    */
    @Test
    public void testStampV1NominaSeparacionIndemnizacionResponseV3() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_SeparacionIndemnizacion.xml",
                "V1", true, false);
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina sin deducciones mediante el servicio de timbrado versión 2
    * de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 4.
    */
    @Test
    public void testStampV2NominaSinDeduccionesResponseV4() {
        try {
            StampResponseV2 response = stampService.stampResponseV2(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_SinDeducciones.xml",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina mediante el servicio de timbrado versión 1 (Json)
    * de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 1.
    */
    @Test
    public void testIssueJsonV1NominaResponseV1() {
        try {
            StampResponseV1 response = stampService.stampResponseV1("resources/CFDI40/Nomina12/CFDI40_Nomina.json",
                "IssueJsonV1", false, false);
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina extraordinaria mediante el servicio
    * de timbrado versión 4 (Json) de la librería sdk-java18 mediante usuario y contraseña
    * con respuesta versión 2.
    */
    @Test
    public void testIssueJsonV4NominaExtraordinariaResponseV2() {
        try {
            StampResponseV2 response = stampService.stampResponseV2(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_Extraordinaria.json",
                "IssueJsonV4", false, false);
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina con horas extra mediante el servicio de timbrado
    * versión 1 (Json) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 3.
    */
    @Test
    public void testIssueJsonV1NominaHorasExtraResponseV3() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_HorasExtra.json",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina con incapacidades mediante el servicio
    * de timbrado versión 4 (Json) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 4.
    */
    @Test
    public void testIssueJsonV4NominaIncapacidadesResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_Incapacidades.json",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina jubilación pensión retiro mediante
    * el servicio de timbrado versión 1 (Json) de la librería sdk-java18 mediante usuario y
    * contraseña con respuesta versión 3.
    */
    @Test
    public void testIssueJsonV1NominaJubilacionPensionRetiroResponseV3() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_JubilacionPensionRetiro.json",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina jubilación pensión retiro mediante el
    * servicio de timbrado versión 4 (Json) de la librería sdk-java18 mediante usuario y contraseña
    * con respuesta versión 4.
    */
    @Test
    public void testIssueJsonV4NominaJubilacionPensionRetiro2ResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_JubilacionPensionRetiro2.json",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina separación indemnización mediante el servicio
    * de timbrado versión 1 (Json) de la librería sdk-java18 mediante usuario y contraseña con respuesta versión 3.
    */
    @Test
    public void testIssueJsonV1NominaSeparacionIndemnizacionResponseV3() {
        try {
            StampResponseV3 response = stampService.stampResponseV3(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_SeparacionIndemnizacion.json",
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
    * Timbrado de CFDI versión 4.0 con complemento de nómina sin deducciones mediante el servicio de
    * timbrado versión 4 (Json) de la librería sdk-java18 mediante usuario y contraseña con
    * respuesta versión 4.
    */
    @Test
    public void testIssueJsonV4NominaSinDeduccionesResponseV4() {
        try {
            StampResponseV4 response = stampService.stampResponseV4(
                "resources/CFDI40/Nomina12/CFDI40_Nomina_SinDeducciones.json",
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
