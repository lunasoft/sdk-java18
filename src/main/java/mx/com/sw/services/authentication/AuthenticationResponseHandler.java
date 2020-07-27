package mx.com.sw.services.authentication;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

public class AuthenticationResponseHandler extends ResponseHandler<AuthenticationResponse> {

    @Override
    public AuthenticationResponse HandleException(Throwable ex) {
        return ResponseHelper.toAuthenticationResponse(ex);
    }
    
}