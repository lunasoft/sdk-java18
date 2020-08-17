package mx.com.sw.services.cancelation.responses;

import mx.com.sw.entities.IResponse;

/**
 * CancelationResponse Respuesta de cancelación con la información de la misma.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationResponse extends IResponse {
    private CancelationData data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public CancelationResponse(String status, String message, String messageDetail, CancelationData data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos de la cancelación cuando está fue "success".
     * @return CancelationData
     */
    public CancelationData getData() {
        return this.data;
    }
}
