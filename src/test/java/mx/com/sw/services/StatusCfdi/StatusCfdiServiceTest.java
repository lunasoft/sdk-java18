package mx.com.sw.services.StatusCfdi;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;

public class StatusCfdiServiceTest {
    /**
     * Prueba el servicio StatusCfdi en un entorno real.
     * 
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    public void testStatusCfdiService_Real_Vigente() throws Exception {
        StatusCfdiService app = new StatusCfdiService("https://consultaqr.facturaelectronica.sat.gob.mx/ConsultaCFDIService.svc");
        StatusCfdiResponse response = null;
        response = (StatusCfdiResponse) app.GetStatusCfdi("GOM0809114P5", "LSO1306189R5", "206.85", "021ea2fb-2254-4232-983b-9808c2ed831b", "WBjHe+9loaYIMM5wYwLxfhT6FnotG0KLRNheOlIxXoVMvsafsRdWY/aZ....");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expect_status = "success";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
    }

    /**
     * Prueba el servicio StatusCfdi en un entorno real cuando se genera un error.
     * 
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    public void testStatusCfdiService_Real_Error() throws Exception {
        StatusCfdiService app = new StatusCfdiService("https://consultaqr.facturaelectronica.sat.gob.mx/ConsultaCFDIService.svc");
        StatusCfdiResponse response = null;
        response = (StatusCfdiResponse) app.GetStatusCfdi("GOM0809114P5", "LSO1306189R5", "206.85", "021ea2fb-2254-4232-983b-9808c2ed831c", "WBjHe+9loaYIMM5wYwLxfhT6FnotG0KLRNheOlIxXoVMvsafsRdWY/aZ....");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expect_status = "error";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
    }

    /**
     * Prueba el servicio StatusCfdi en el entorno de pruebas.
     * 
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    @Ignore
    public void testStatusCfdiService_Test() throws Exception {
        StatusCfdiService app = new StatusCfdiService("https://pruebacfdiconsultaqr.cloudapp.net/ConsultaCFDIService.svc");
        StatusCfdiResponse response = null;
        response = (StatusCfdiResponse) app.GetStatusCfdi("EKU9003173C9", "XEXX010101000", "9300.00", "bad75896-551e-4d5e-a372-d168180133f5", "bX4qYU8wHAhLk6UXrs93hM1iSFMXubIBgQtfRCJZTGRpy9sfsnTu2M....");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expect_status = "success";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
    }

    /**
     * Prueba el servicio StatusCfdi en el entorno de pruebas cuando se genera un error.
     * 
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    @Ignore
    public void testStatusCfdiService_Test_Error() throws Exception {
        StatusCfdiService app = new StatusCfdiService("https://pruebacfdiconsultaqr.cloudapp.net/ConsultaCFDIService.svc");
        StatusCfdiResponse response = null;
        response = (StatusCfdiResponse) app.GetStatusCfdi("EKU9003173C9", "XEXX010101000", "9300.00", "bad75896-551e-4d5e-a372-d168180133g6", "bX4qYU8wHAhLk6UXrs93hM1iSFMXubIBgQtfRCJZTGRpy9sfsnTu2M....");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expect_status = "error";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
    }
}