package mx.com.sw.services.acceptreject.requests;

/**
 * AcceptRejectItem Clase con la informacion para la
 * solicitud de aceptación/rechazo.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class AcceptRejectItem {
    private String uuid;
    private EnumAcceptReject action;

    /**
     * Constructor de clase.
     * @param uuid folio de factura.
     * @param action acción a realizar.
     */
    public AcceptRejectItem(String uuid, EnumAcceptReject action) {
        this.uuid = uuid;
        this.action = action;
    }

    /**
     * Obtiene el uuid de la factura.
     * @return String
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Obtiene la accion.
     * @return String
     */
    public EnumAcceptReject getAction() {
        return this.action;
    }
}
