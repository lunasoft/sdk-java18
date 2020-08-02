package mx.com.sw.services.authentication.responses;

import mx.com.sw.entities.IResponse;
/**
* <h1>AuthenticationResponse</h1>
* Clase que contiene información acerca de la authentication.
* <p>
* <b>Note:</b> Se recomienda revisar el campo "status" para saber si el campo "data" contiene datos o en su lugar mirar los mensajes de error,
* los cuales están contenidos en los campos "message" y "messageDetail"
* Ejemplo
* Authentication auth = new Authentication("http://services.test.sw.com.mx", "demo", "123456789", null, 0);
* AuthenticationResponse res = auth.authenticate();
* if(res.status.equalsIgnoreCase("success")){
*    System.out.println(res.data.token);
*    System.out.println(res.data.expires_in);
* }
* else{
*   System.out.println("Error al tratar de obtener token");
*   System.out.println(res.message);
*   System.out.println(res.messageDetail);
* }
*
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class AuthenticationResponse extends IResponse {
    /**
     * Datos de la authentication cuando está es "success".
     */
    public AuthenticationData data;
}
