package mx.com.sw.services.authentication;

import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;
import mx.com.sw.services.authentication.responses.AuthenticationResponseHandler;
import org.apache.http.client.config.RequestConfig;

/**
* Servicio de Authentication
* Clase que permite obtener un token de SW sapien® mediante el uso de un usuario y contraseña con una duración de 2 hrs.
* <p>
* Los demás servicios hacen uso interno de esta clase cuando se inician mediante usuario y contraseña.
* <p>
* <b>Nota:</b> No es necesario generar un token para cada petición web, se recomienda el uso del token infinito como
* inicializador de los métodos.
* <p>
* Ejemplo de uso:
* <pre>
* Authentication auth = new Authentication("http://services.test.sw.com.mx", "demo", "123456789", null, 0);
* AuthenticationResponse res = auth.authenticate();
* if("success".equalsIgnoreCase(res.getStatus()){
*    System.out.println(res.getData().getToken());
*    System.out.println(res.getData().getExpiresIn());
* } else{ // ocurrió un error y en los mensajes podría haber información últil acerca del error.
*   System.out.println(res.getMessage());
*   System.out.println(res.getMessageDetail());
* }
* </pre>
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class Authentication extends AuthenticationService {
    private AuthenticationResponseHandler handler;

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    public Authentication(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
        handler = new AuthenticationResponseHandler();
    }

    /**
    * Este método obtiene un token mediante el usuario y password con el cual se inicio la instancia de clase.
    * @return AuthenticationResponse.
    * @see AuthenticationResponse
    */
    @Override
    public AuthenticationResponse authenticate() {
        try {
            new AuthenticationValidation(getUrl(), getUser(), getPassword(), getToken());
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("user", getUser());
            headers.put("password", getPassword());
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.getHTTP(getUrl(), "security/authenticate", headers, config, AuthenticationResponse.class);
        } catch (ServicesException e) {
            return handler.handleException(e);
        }
    }
}
