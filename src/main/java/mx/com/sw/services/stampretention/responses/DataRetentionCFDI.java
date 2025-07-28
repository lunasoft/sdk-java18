package mx.com.sw.services.stampretention.responses;

/**
* DataRetentionCFDI
* Clase que contiene información acerca del timbrado de retenciones.
*/
public class DataRetentionCFDI {
    private String retencion;

    /**
     * Constructor de la clase.
     * @param retencion String retention.
     */
    public DataRetentionCFDI(String retencion) {
        this.retencion = retencion;
    }

    /**
     * Obtiene el XML de la retención timbrada.
     * @return String
     */
    public String getRetention() {
        return this.retencion;
    }
} 