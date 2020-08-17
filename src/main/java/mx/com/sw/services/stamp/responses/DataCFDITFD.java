package mx.com.sw.services.stamp.responses;

/**
* DataCFDITFD
* Clase que contiene información acerca del timbrado.
* <p>
* <b>Nota:</b> Este campo puede ser null cuando ha surgido un error.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class DataCFDITFD extends DataTFD {
    private String cfdi;

    /**
     * Constructor de la clase.
     * @param cfdi String cfdi.
     * @param tfd String tfd.
     */
    public DataCFDITFD(String tfd, String cfdi) {
        super(tfd);
        this.cfdi = cfdi;
    }

    /**
     * Obtiene el XML del cfdi timbrado.
     * @return String
     */
    public String getCFDI() {
        return this.cfdi;
    }
}
