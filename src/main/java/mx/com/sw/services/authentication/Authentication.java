package mx.com.sw.services.authentication;

import java.util.HashMap;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;
import mx.com.sw.services.authentication.responses.AuthenticationResponseHandler;

/**
* <h1>Servicio de Authentication</h1>
* Está clase permite obtener un token de SW sapien® mediante el uso de un usuario y contraseña con una duración de 2 hrs.
* <p>
* Los demás servicios hacen uso interno de esta clase cuando se inician mediante usuario y contraseña.
* <p>
* <b>Nota:</b> No es necesario generar un token para cada petición web, se recomienda el uso del token infinito como inicializador de los métodos
*
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
    * @param password
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
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("user", getUser());
            headers.put("password", getPassword());
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.getHTTP(getUrl(), "security/authenticate", headers, config, AuthenticationResponse.class);
        } catch (Exception e) {
            return handler.handleException(e);
        }
    }
    
}