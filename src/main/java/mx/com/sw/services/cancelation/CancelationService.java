package mx.com.sw.services.cancelation;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.com.sw.services.Services;
import mx.com.sw.services.cancelation.requests.CancelationRequestCSD;
import mx.com.sw.services.cancelation.requests.CancelationRequestPFX;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

public abstract class CancelationService extends Services {

    protected CancelationService(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
    }
    protected CancelationService(String url, String token, String proxy, int proxyPort){
        super(url, token, proxy, proxyPort);
    }
    abstract CancelationResponse Cancelar(String cer, String key, String rfc, String password, String uuid);
    abstract CancelationResponse Cancelar(String pfx, String rfc, String password, String uuid);
    abstract CancelationResponse Cancelar(String rfc, String uuid);
    abstract CancelationResponse Cancelar(String xmlCancelation);

    protected String RequestCancelar(String pfx, String rfc, String password, String uuid){
        CancelationRequestPFX objectRequest = new CancelationRequestPFX();
        objectRequest.b64Pfx = pfx;
        objectRequest.password = password;
        objectRequest.rfc = rfc;
        objectRequest.uuid = uuid;
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }
    protected String RequestCancelar(String csd, String key, String rfc, String password, String uuid){
        CancelationRequestCSD objectRequest = new CancelationRequestCSD();
        objectRequest.b64Cer = csd;
        objectRequest.b64Key = key;
        objectRequest.password = password;
        objectRequest.rfc = rfc;
        objectRequest.uuid = uuid;
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }
    protected HashMap<String, String> GetHeaders(){
        this.setupRequest();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }
}