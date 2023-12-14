package mx.com.sw.services.StatusCfdi.responses;

/**
 * StatusCfdiResponse.
 */
public class StatusCfdiResponse {
    public String codigoEstatus;
    public String estado;
    public String esCancelable;
    public String estatusCancelacion;
    public String Status;
    public String HttpStatusCode;

    /**
     * Constructor de la clase StatusCfdiResponse.
     * @param httpStatusCode     El código de estado HTTP.
     * @param status             El estado de la solicitud.
     * @param codigoEstatus      El código de estatus del servicio SAT.
     * @param estado             El estado del comprobante.
     * @param esCancelable       Indica si el comprobante es cancelable.
     * @param estatusCancelacion El estatus de cancelación.
     * @param msg                El mensaje.
     * @param msgDetail          Los detalles del mensaje.
     */
    public StatusCfdiResponse(int httpStatusCode, String status, String codigoEstatus, String estado,
            String esCancelable, String estatusCancelacion, String msg, String msgDetail) {
        /**
         * Set HttpStatusCode.
         */
        this.HttpStatusCode = String.valueOf(httpStatusCode);
        /**
         * Set Status.
         */
        this.Status = status;
        /**
         * Set CodigoStatus.
         */
        this.codigoEstatus = codigoEstatus;
        /**
         * Set Estado.
         */
        this.estado = estado;
        /**
         * Set EsCancelable.
         */
        this.esCancelable = esCancelable;
        /**
         * Set EstatusCancelacion.
         */
        this.estatusCancelacion = estatusCancelacion;
    }

    /**
     * Constructor de la clase StatusCfdiResponse.
     * @param httpStatusCode El código de estado HTTP.
     * @param status         El estado de la solicitud.
     * @param msg            El mensaje.
     * @param msgDetail      Los detalles del mensaje.
     */
    public StatusCfdiResponse(int httpStatusCode, String status, String msg, String msgDetail) {
        super();
    }
}
