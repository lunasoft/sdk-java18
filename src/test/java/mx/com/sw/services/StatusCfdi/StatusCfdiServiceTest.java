package mx.com.sw.services.StatusCfdi;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;

public class StatusCfdiServiceTest {
    @Test
    public void testStatusCancelationService_Real() throws Exception {
        StatusCfdiService app = new StatusCfdiService("https://consultaqr.facturaelectronica.sat.gob.mx/ConsultaCFDIService.svc", "http://tempuri.org/IConsultaCFDIService/Consulta");
        StatusCfdiResponse response = null;
        response = (StatusCfdiResponse) app.StatusCfdi("API6609273E0", "XAXX010101000", "314.00", "39292240-74c8-40fa-9192-bdca4b412d95","lWZ1DQ==");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expect_status = "success";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
    }
    @Ignore
    public void testStatusCancelationService_Test() throws Exception {
        StatusCfdiService app = new StatusCfdiService("https://pruebacfdiconsultaqr.cloudapp.net/ConsultaCFDIService.svc", "http://tempuri.org/IConsultaCFDIService/Consulta");
        StatusCfdiResponse response = null;
        response = (StatusCfdiResponse) app.StatusCfdi("EKU9003173C9", "XEXX010101000", "11.48", "3eeb3400-4c53-454c-91c7-caf05a7f111b","kRLGkg==");
        System.out.println(response.Status);
        System.out.println(response.HttpStatusCode);
        System.out.println(response.codigoEstatus);
        System.out.println(response.estado);
        System.out.println(response.esCancelable);
        System.out.println(response.estatusCancelacion);
        String expect_status = "success";
        Assert.assertTrue(expect_status.equalsIgnoreCase(response.Status));
    }
}