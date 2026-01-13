package mx.com.sw.services.cancelationretention.responses;

import mx.com.sw.entities.IResponse;

/**
 * CancelationRetResponse Respuesta de cancelación de retención con la información de la misma.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationRetResponse extends IResponse {
    private CancelationRetData data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public CancelationRetResponse(String status, String message, String messageDetail, CancelationRetData data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos de la cancelación cuando está fue "success".
     * @return CancelationRetData
     */
    public CancelationRetData getData() {
        return this.data;
    }
}
