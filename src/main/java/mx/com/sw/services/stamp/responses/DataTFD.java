package mx.com.sw.services.stamp.responses;

/**
* <h1>DataTFD</h1>
* Clase que contiene información acerca del timbrado.
* <p>
* <b>Nota:</b> Este campo puede ser null cuando ha surgido un error.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class DataTFD {
    private String tfd;

    /**
     * Constructor de la clase.
     * @param tfd
     */
    public DataTFD(String tfd) {
        this.tfd = tfd;
    }

    /**
     * Obtiene el Timbre Fiscal Digital del CFDI enviado a timbrar.
     */
    public String getTFD() {
        return this.tfd;
    }
}
