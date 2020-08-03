package mx.com.sw.services.stamp.responses;

import mx.com.sw.entities.IResponse;

/**
* <h1>StampResponseV4</h1>
* Clase que contiene información acerca del timbrado con datos versión 4.
* <p>
* <b>Nota:</b> Se recomienda revisar el campo "getStatus()" para saber si el campo "getData()" contiene datos o en
* su lugar mirar los mensajes de error, los cuales están contenidos en los campos "getMessage()" y "getMessageDetail()".
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class StampResponseV4 extends IResponse {
    private DataComplete data;

    /**
     * Constructor de la clase.
     * @param status
     * @param message
     * @param messageDetail
     * @param data
     */
    public StampResponseV4(String status, String message, String messageDetail, DataComplete data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos del cfdi timbrado.
     * <b>Nota:</b> Este valor puede ser null cuando
     * termino con status "error" la petición.
     */
    public DataComplete getData() {
        return this.data;
    }
}
