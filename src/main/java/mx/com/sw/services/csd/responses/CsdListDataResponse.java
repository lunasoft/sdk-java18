package mx.com.sw.services.csd.responses;
import java.util.List;

import mx.com.sw.entities.IResponse;

/**
 * CsdListDataResponse Clase que retorna una lista de informacion retornada por el servicio de CSD al realizar una consulta.
 */

public class CsdListDataResponse extends IResponse{
    private List<CsdData> data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public CsdListDataResponse(String status, String message, String messageDetail, List<CsdData> data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos del certificado cuando la consulta fue "success".
     * @return CsdData
     */
    public List<CsdData> getData() {
        return this.data;
    }
}
