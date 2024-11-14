package mx.com.sw.services.csd.responses;

import mx.com.sw.entities.IResponse;

/**
 * CsdResponse Clase con mensaje de exito que el servicio de CSD al cargar un certificado.
 */
public class CsdResponse extends IResponse {
    /**
     * Data.
     */
    public String data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data mensaje de respuesta.
     */
    public CsdResponse(String status, String message, String messageDetail, String data) {
        super(status, message, messageDetail);
        this.data = data;
    }
}
