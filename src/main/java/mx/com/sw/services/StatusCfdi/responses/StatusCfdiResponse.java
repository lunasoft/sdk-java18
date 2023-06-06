package mx.com.sw.services.StatusCfdi.responses;

public class StatusCfdiResponse {
    public String codigoEstatus;
    public String estado;
    public String esCancelable;
    public String estatusCancelacion;
    public String Status;
    public String HttpStatusCode;

    /**
     * Constructor de la clase StatusCfdiResponse.
     * 
     * @param httpStatusCode     El código de estado HTTP.
     * @param status             El estado de la solicitud.
     * @param codigoEstatus      El código de estatus del servicio SAT.
     * @param estado             El estado del comprobante.
     * @param esCancelable       Indica si el comprobante es cancelable.
     * @param estatusCancelacion El estatus de cancelación.
     * @param msg                El mensaje.
     * @param msgDetail          Los detalles del mensaje.
     */
    public StatusCfdiResponse(int httpStatusCode, String status, String codigoEstatus, String estado, String esCancelable, String estatusCancelacion, String msg, String msgDetail) {
        this.HttpStatusCode = String.valueOf(httpStatusCode);
        this.Status = status;
        this.codigoEstatus = codigoEstatus;
        this.estado = estado;
        this.esCancelable = esCancelable;
        this.estatusCancelacion = estatusCancelacion;
    }

    /**
     * Constructor de la clase StatusCfdiResponse.
     * 
     * @param httpStatusCode El código de estado HTTP.
     * @param status         El estado de la solicitud.
     * @param msg            El mensaje.
     * @param msgDetail      Los detalles del mensaje.
     */
    public StatusCfdiResponse(int httpStatusCode, String status, String msg, String msgDetail) {
        super();
    }
}