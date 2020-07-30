package mx.com.sw.services.authentication;

import java.util.HashMap;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;
import mx.com.sw.services.authentication.responses.AuthenticationResponseHandler;

public class Authentication extends AuthenticationService {
    private AuthenticationResponseHandler handler;
    public Authentication(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
        handler = new AuthenticationResponseHandler();
    }

    @Override
    public AuthenticationResponse authenticate() {
        try {
            new AuthenticationValidation(getUrl(), getUser(), getPassword(), getToken());
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("user", getUser());
            headers.put("password", getPassword());
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.GetHTTP(getUrl(), "security/authenticate", headers, config, AuthenticationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }
    
}