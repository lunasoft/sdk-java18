package mx.com.sw.services.pendings.response;

import mx.com.sw.entities.IResponse;

/**
 * Pendings Clase con la informacion de la
 * facturas pedientes.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-24
 */
public class PendingsResponse extends IResponse {
    private PendingsData data;
    private String codStatus;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public PendingsResponse(String status, String message, String messageDetail, PendingsData data) {
        super(status, message, messageDetail);
        // TODO Auto-generated constructor stub
    }

    /**
     * Obtiene los datos de solicitud en caso de status "success".
     * @return RelationsData
     */
    public PendingsData getData() {
        return this.data;
    }

    /**
     * Configura los datos de respuesta.
     * @param data objeto con datos.
     */
    public void setData(PendingsData data) {
        this.data = data;
    }

    /**
     * Obtiene una estatus devuelto por el SAT.
     * @return String
     */
    public String getCodStatus() {
        return this.codStatus;
    }

    /**
     * Obtiene una estatus devuelto por el SAT.
     * @param codStatus status SAT.
     */
    public void setCodStatus(String codStatus) {
        this.codStatus = codStatus;
    }
}
