package mx.com.sw.services.storage;

import mx.com.sw.entities.IResponse;

/**
 * StorageResponse.
 */
public class StorageResponse extends IResponse {
    private StorageData data;

    /**
     * Constructor de la clase.
     * @param status        status de llamada a API.
     * @param message       mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data          objeto con los datos de respuesta.
     */

    public StorageResponse(String status, String message, String messageDetail, StorageData data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos del xml cuando está fue "success".
     * @return {@link StorageData}
     */
    public StorageData getData() {
        return this.data;
    }
}
