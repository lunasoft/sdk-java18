package mx.com.sw.services.StatusCfdi;

import org.junit.Assert;
import org.junit.Test;
import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;

public class StatusCfdiServiceTest {
    /**
     * Prueba el servicio StatusCfdi en un entorno real.
     * 
     * @throws Exception Si ocurre un error durante la prueba.
     */
    @Test
    public void testStatusCfdiService_Real() throws Exception {
        StatusCfdiService app = new StatusCfdiService();
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
        StatusCfdiService app = new StatusCfdiService();
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
}