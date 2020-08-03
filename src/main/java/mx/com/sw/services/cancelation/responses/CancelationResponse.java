package mx.com.sw.services.cancelation.responses;

import mx.com.sw.entities.IResponse;

/**
 * <h1>CancelationResponse</h1> Respuesta de cancelación con la información de la misma.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationResponse extends IResponse {
    private CancelationData data;

    /**
     * Constructor de la clase.
     * @param status
     * @param message
     * @param messageDetail
     * @param data
     */
    public CancelationResponse(String status, String message, String messageDetail, CancelationData data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos de la cancelación cuando está fue "success".
     */
    public CancelationData getData() {
        return this.data;
    }
}
