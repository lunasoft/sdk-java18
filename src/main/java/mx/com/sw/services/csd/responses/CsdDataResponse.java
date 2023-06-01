package mx.com.sw.services.csd.responses;

import mx.com.sw.entities.IResponse;

/**
 * CsdDataResponse Clase que retorna la informacion retornada por el servicio de CSD al realizar una consulta.
 */
public class CsdDataResponse extends IResponse{
    private CsdData data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public CsdDataResponse(String status, String message, String messageDetail, CsdData data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos del certificado cuando la consulta fue "success".
     * @return CsdData
     */
    public CsdData getData() {
        return this.data;
    }
}
