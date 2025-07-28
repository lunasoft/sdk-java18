package mx.com.sw.services.stampretention.responses;

import mx.com.sw.entities.IResponse;

/**
* StampRetentionResponseV3
* Clase que contiene información acerca del timbrado de retenciones con datos versión 3.
* <p>
* <b>Nota:</b> Se recomienda revisar el campo "getStatus()" para saber si el campo "getData()" contiene datos o en
* su lugar mirar los mensajes de error, los cuales están contenidos en los campos "getMessage()" y "getMessageDetail()".
*/
public class StampRetentionResponseV3 extends IResponse {
    private DataRetentionCFDI data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public StampRetentionResponseV3(String status, String message, String messageDetail, DataRetentionCFDI data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos de la retención timbrada.
     * <b>Nota:</b> Este valor puede ser null cuando
     * termino con status "error" la petición.
     * @return DataRetentionCFDI
     */
    public DataRetentionCFDI getData() {
        return this.data;
    }
} 