package mx.com.sw.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.authentication.Authentication;
import mx.com.sw.services.authentication.AuthenticationResponse;

public class Services {
    private String token;
    private String url;
    private String user;
    private String password;
    private String proxy;
    private int proxyPort;
    private Instant expirationDate;
    
    protected String GetToken(){
        return this.token;
    }
    protected String GetUrl(){
        return this.url;
    }
    protected String GetUser(){
        return this.user;
    }
    protected String GetPassword(){
        return this.password;
    }
    protected String GetProxy(){
        return this.proxy;
    }
    protected int GetProxyPort(){
        return this.proxyPort;
    }
    protected Instant GetExpirationDate(){
        return this.expirationDate;
    }

    protected Services(String url, String token, String proxy, int proxyPort)
    {
        this.url = GeneralHelpers.noralizeUrl(url);
        this.token = token;
        this.expirationDate = Instant.now().plus(2, ChronoUnit.DECADES);
        this.proxy = proxy;
        this.proxyPort = proxyPort;
    }
    protected Services(String url, String user, String password, String proxy, int proxyPort)
    {
        this.url = GeneralHelpers.noralizeUrl(url);
        this.user = user;
        this.password = password;
        this.proxy = proxy;
        this.proxyPort = proxyPort;
    }
    protected Services setupRequest(){
        if(GeneralHelpers.stringEmptyOrNull(token) || Instant.now().isAfter(expirationDate)){
            Authentication auth = new Authentication(url, user, password, proxy, proxyPort);
            AuthenticationResponse response = auth.getToken();
            if(response.status.equalsIgnoreCase("success")){
                this.token = response.data.token;
                this.expirationDate = Instant.ofEpochSecond(response.data.expires_in);
            }
        }
        return this;
    }
}