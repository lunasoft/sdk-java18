package mx.com.sw.services.cancelationretention.responses;

import mx.com.sw.entities.IResponse;

/**
 * CancelationRetentionResponse Respuesta de cancelación de retención con la información de la misma.
 * @author Martin F
 * @version 0.0.0.1
 * @since 2025-01-27
 */
public class CancelationRetentionResponse extends IResponse {
    private CancelationRetentionData data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public CancelationRetentionResponse(String status, String message, String messageDetail, CancelationRetentionData data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos de la cancelación cuando está fue "success".
     * @return CancelationRetentionData
     */
    public CancelationRetentionData getData() {
        return this.data;
    }
} 