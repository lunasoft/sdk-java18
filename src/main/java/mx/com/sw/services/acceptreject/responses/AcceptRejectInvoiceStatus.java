package mx.com.sw.services.acceptreject.responses;

/**
 * AcceptRejectInvoiceStatus Clase con la informacion especifica
 * de los folios.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class AcceptRejectInvoiceStatus {
    private String uuid;
    private String estatusUUID;
    private String respuesta;

    /**
     * Obtiene el uuid de la factura.
     * @return String
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Configura el uuid.
     * @param value uuid to set.
     */
    public void setUUID(String value) {
        this.uuid = value;
    }

    /**
     * Obtiene el estatus de la factura.
     * @return String
     */
    public String getEstatusUUID() {
        return this.estatusUUID;
    }

    /**
     * Configura el status.
     * @param value estatusUUID to set.
     */
    public void setEstatusUUID(String value) {
        this.estatusUUID = value;
    }

    /**
     * Obtiene la respuesta de la factura.
     * @return String
     */
    public String getRespuesta() {
        return this.respuesta;
    }

    /**
     * Configura la respuesta.
     * @param value respuesta to set.
     */
    public void setRespuesta(String value) {
        this.respuesta = value;
    }
}
