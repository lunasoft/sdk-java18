package mx.com.sw.services.relations.response;

/**
 * RelationsUUIDs Clase con la informacion especifica
 * de los folios.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-24
 */
public class RelationsUUIDs {
    private String uuid;
    private String rfcEmisor;
    private String rfcReceptor;

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
     * Obtiene el rfcEmisor de la factura.
     * @return String
     */
    public String getRfcEmisor() {
        return this.rfcEmisor;
    }

    /**
     * Configura el rfcEmisor.
     * @param value rfcEmisor to set.
     */
    public void setRfcEmisor(String value) {
        this.rfcEmisor = value;
    }

    /**
     * Obtiene el rfcReceptor de la factura.
     * @return String
     */
    public String getRfcReceptor() {
        return this.rfcReceptor;
    }

    /**
     * Configura el rfcReceptor.
     * @param value rfcReceptor to set.
     */
    public void setRfcReceptor(String value) {
        this.rfcReceptor = value;
    }
}
