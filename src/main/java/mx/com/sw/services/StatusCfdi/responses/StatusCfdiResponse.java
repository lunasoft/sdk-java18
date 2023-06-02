package mx.com.sw.services.StatusCfdi.responses;

public class StatusCfdiResponse {
    public String codigoEstatus;
    public String estado;
    public String esCancelable;
    public String estatusCancelacion;
    public String Status;
    public String HttpStatusCode;

    public StatusCfdiResponse(int httpStatusCode, String status, String codigoEstatus, String estado, String esCancelable, String estatusCancelacion, String msg, String msgDetail) {
        this.HttpStatusCode = String.valueOf(httpStatusCode);
        this.Status = status;
        this.codigoEstatus = codigoEstatus;
        this.estado = estado;
        this.esCancelable = esCancelable;
        this.estatusCancelacion = estatusCancelacion;
    }
    public StatusCfdiResponse(int httpStatusCode, String status, String msg, String msgDetail) {
        super();
    }
        
}