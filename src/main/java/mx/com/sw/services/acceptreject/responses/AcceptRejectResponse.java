package mx.com.sw.services.acceptreject.responses;

/**
 * AcceptRejectResponse Clase con la informacion de la
 * aceptación/rechazo.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class AcceptRejectResponse {
    private AcceptRejectData data;
    private String codStatus;

    /**
     * Obtiene los datos de solicitud en caso de status "success".
     * @return AcceptRejectData
     */
    public AcceptRejectData getData() {
        return this.data;
    }

    /**
     * Configura los datos de respuesta.
     * @param data objeto con datos.
     */
    public void setData(AcceptRejectData data) {
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
