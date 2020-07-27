package mx.com.sw.services.authentication;

import java.util.HashMap;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.helpers.GeneralHelpers;

public class Authentication extends AuthenticationService {
    private AuthenticationResponseHandler handler;
    public Authentication(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
        handler = new AuthenticationResponseHandler();
    }

    @Override
    public AuthenticationResponse getToken() {
        try {
            new AuthenticationValidation(GetUrl(), GetUser(), GetPassword(), GetToken());
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("user", GetUser());
            headers.put("password", GetPassword());
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(GetProxy(), GetProxyPort());
            return handler.GetHTTP(GetUrl(), "security/authenticate", headers, config, AuthenticationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }
    
}