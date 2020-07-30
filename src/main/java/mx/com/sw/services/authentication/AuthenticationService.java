package mx.com.sw.services.authentication;

import mx.com.sw.services.Services;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;

public abstract class AuthenticationService extends Services {

    public AuthenticationService(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
    }
    public abstract AuthenticationResponse authenticate();
    
}