package mx.com.sw.services.authentication.responses;

import mx.com.sw.entities.IResponse;

/**
* AuthenticationResponse
* Clase que contiene información acerca de la authentication.
* <p>
* <b>Nota:</b> Se recomienda revisar el campo "getStatus()" para saber si el campo "getData()" contiene datos o en su
* lugar mirar los mensajes de error, los cuales están contenidos en los campos "getMessage()" y "getMessageDetail()".
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class AuthenticationResponse extends IResponse {
    private AuthenticationData data;

    /**
     * Constructor de la clase.
     * @param status status del call.
     * @param message mensaje de API.
     * @param messageDetail detalle de mensaje de API.
     * @param data objeto con datos de respuesta.
     */
    public AuthenticationResponse(String status, String message, String messageDetail, AuthenticationData data) {
        super(status, message, messageDetail);
    }

    /**
     * Datos de la authentication cuando está es "success".
     * @return AuthenticationData
     */
    public AuthenticationData getData() {
        return this.data;
    }
}
