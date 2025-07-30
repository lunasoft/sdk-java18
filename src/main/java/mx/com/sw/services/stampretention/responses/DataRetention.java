package mx.com.sw.services.stampretention.responses;

/**
* DataRetention
* Clase que contiene información acerca del timbrado de retenciones.
* <p>
* <b>Nota:</b> Este campo puede ser null cuando ha surgido un error.
*/
public class DataRetention {
    private String retention;

    /**
     * Constructor de la clase.
     * @param retention String retention.
     */
    public DataRetention(String retention) {
        this.retention = retention;
    }

    /**
     * Obtiene el XML de la retención timbrada.
     * @return String
     */
    public String getRetention() {
        return this.retention;
    }
} 