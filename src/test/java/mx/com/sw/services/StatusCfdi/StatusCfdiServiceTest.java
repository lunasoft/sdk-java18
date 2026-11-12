package mx.com.sw.services.StatusCfdi;

import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * StatusCfdiServiceTest.
 */
public class StatusCfdiServiceTest {
    /**
     * Prueba el servicio StatusCfdi en un entorno real.
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    public void testStatusCfdiService_Real_Vigente() throws Exception {
        StatusCfdiService app = new StatusCfdiService(
                "https://consultaqr.facturaelectronica.sat.gob.mx/ConsultaCFDIService.svc"
        );
        StatusCfdiResponse response = null;
        response = (StatusCfdiResponse) app.GetStatusCfdi("GOM0809114P5", "LSO1306189R5",
                "206.85", "021ea2fb-2254-4232-983b-9808c2ed831b",
                "WBjHe+9loaYIMM5wYwLxfhT6FnotG0KLRNheOlIxXoVMvsafsRdWY/aZ....");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expectStatus = "success";
        Assertions.assertTrue(expectStatus.equalsIgnoreCase(response.Status));
    }

    /**
     * Prueba el servicio StatusCfdi en un entorno real cuando se genera un error.
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    public void testStatusCfdiService_Real_Error() throws Exception {
        StatusCfdiService app = new StatusCfdiService(
                "https://consultaqr.facturaelectronica.sat.gob.mx/ConsultaCFDIService.svc"
        );
        StatusCfdiResponse response = null;
        response = (StatusCfdiResponse)app.GetStatusCfdi("GOM0809114P5", "LSO1306189R5",
                "206.85", "021ea2fb-2254-4232-983b-9808c2ed831c",
                "WBjHe+9loaYIMM5wYwLxfhT6FnotG0KLRNheOlIxXoVMvsafsRdWY/aZ....");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expectStatus = "error";
        Assertions.assertTrue(expectStatus.equalsIgnoreCase(response.Status));
    }

    /**
     * Prueba el servicio StatusCfdi en el entorno de pruebas.
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    public void testStatusCfdiService_Test() throws Exception {
        StatusCfdiService app = new StatusCfdiService(
                "https://api.test.sw.com.mx/ConsultaCFDIService.svc"
        );
        StatusCfdiResponse response=null;
        response = (StatusCfdiResponse) app.GetStatusCfdi("EKU9003173C9",
                "URE180429TM6", "199.16", "0f9bde73-beeb-44fa-a402-ac48a02be765",
                "RcauvQ==");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expectStatus = "success";
        Assertions.assertTrue(expectStatus.equalsIgnoreCase(response.Status));
    }
    /**
     * Prueba el servicio StatusCfdi en el entorno de pruebas cuando se genera un error.
     * @throws Exception Si ocurre un error durante la prueba.
    */
    @Test
    public void testStatusCfdiService_Test_Error() throws Exception {
        StatusCfdiService app = new StatusCfdiService(
                "https://api.test.sw.com.mx/ConsultaCFDIService.svc"
        );
        StatusCfdiResponse response = null;
        response = (StatusCfdiResponse) app.GetStatusCfdi("EKU9003173C9",
                "XEXX010101000", "9300.00", "bad75896-551e-4d5e-a372-d168180133g6",
                "bX4qYU8wHAhLk6UXrs93hM1iSFMXubIBgQtfRCJZTGRpy9sfsnTu2M....");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expectStatus = "error";
        Assertions.assertTrue(expectStatus.equalsIgnoreCase(response.Status));
    }

    /**
     * Prueba la clase StatusCfdi indicando el endpoint del entorno de pruebas.
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    public void testStatusCfdi_Url() throws Exception {
        StatusCfdi statusCfdi = new StatusCfdi("https://api.test.sw.com.mx/ConsultaCFDIService.svc");
        StatusCfdiResponse response = statusCfdi.GetStatusCfdi("EKU9003173C9", "URE180429TM6", "199.16",
                "0f9bde73-beeb-44fa-a402-ac48a02be765", "RcauvQ==");
        Assertions.assertTrue("success".equalsIgnoreCase(response.Status));
        Assertions.assertTrue("Vigente".equalsIgnoreCase(response.estado));
    }

    /**
     * Prueba la clase StatusCfdi sin indicar endpoint, que consulta el servicio del SAT.
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    public void testStatusCfdi_UrlPorDefecto() throws Exception {
        StatusCfdi statusCfdi = new StatusCfdi();
        StatusCfdiResponse response = statusCfdi.GetStatusCfdi("GOM0809114P5", "LSO1306189R5",
                "206.85", "021ea2fb-2254-4232-983b-9808c2ed831b",
                "WBjHe+9loaYIMM5wYwLxfhT6FnotG0KLRNheOlIxXoVMvsafsRdWY/aZ....");
        Assertions.assertTrue("success".equalsIgnoreCase(response.Status));
    }

    /**
     * Prueba que un endpoint inaccesible regresa un error y no una excepción.
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    public void testStatusCfdi_UrlInvalida_Error() throws Exception {
        StatusCfdi statusCfdi = new StatusCfdi("https://servicio.invalido.sw.test/ConsultaCFDIService.svc");
        StatusCfdiResponse response = statusCfdi.GetStatusCfdi("EKU9003173C9", "URE180429TM6", "199.16",
                "0f9bde73-beeb-44fa-a402-ac48a02be765", "RcauvQ==");
        Assertions.assertTrue("error".equalsIgnoreCase(response.Status));
        Assertions.assertEquals("500", response.HttpStatusCode);
    }
}
