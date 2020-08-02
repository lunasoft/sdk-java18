package mx.com.sw.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.authentication.Authentication;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;

public class Services {
    private String token;
    private String url;
    private String user;
    private String password;
    private String proxy;
    private int proxyPort;
    private Instant expirationDate;
    
    protected String getToken(){
        return this.token;
    }
    protected String getUrl(){
        return this.url;
    }
    protected String getUser(){
        return this.user;
    }
    protected String getPassword(){
        return this.password;
    }
    protected String getProxy(){
        return this.proxy;
    }
    protected int getProxyPort(){
        return this.proxyPort;
    }
    protected Instant getExpirationDate(){
        return this.expirationDate;
    }

    protected Services(String url, String token, String proxy, int proxyPort)
    {
        this.url = GeneralHelpers.noralizeUrl(url);
        this.token = token;
        this.expirationDate = Instant.now().plus(7300, ChronoUnit.DAYS);
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
            AuthenticationResponse response = auth.authenticate();
            if(response.status.equalsIgnoreCase("success")){
                this.token = response.data.token;
                this.expirationDate = Instant.ofEpochSecond(response.data.expires_in);
            }
        }
        return this;
    }
}