package mx.com.sw.services.authentication.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
* <h1>AuthenticationResponseHandler</h1>
* Clase para handler de exceptions en el servicio de authentication.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class AuthenticationResponseHandler extends ResponseHandler<AuthenticationResponse> {

    /**
     * Handler de exceptions.
     * @param ex
     * @return AuthenticationResponse
     * @see AuthenticationResponse
     */
    @Override
    public AuthenticationResponse handleException(Throwable ex) {
        return ResponseHelper.toAuthenticationResponse(ex);
    }

}
