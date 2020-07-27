package mx.com.sw.services.cancelation;

import java.util.HashMap;
import java.util.UUID;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.helpers.GeneralHelpers;

public class Cancelation extends CancelationService {
    private CancelationResponseHandler handler;

    public Cancelation(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
        handler = new CancelationResponseHandler();
    }

    public Cancelation(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
        handler = new CancelationResponseHandler();
    }

    private HashMap<String, String> GetHeaders(){
        this.setupRequest();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.GetToken());
        return headers;
    }

    @Override
    CancelationResponse Cancelar(String cer, String key, String rfc, String password, String uuid) {
        try {
            new CancelationValidation(GetUrl(), GetUser(), GetPassword(), GetToken()).ValidateRequestCSD(cer, key, password, uuid);
            HashMap<String, String> headers = GetHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.RequestCancelar(cer, key, rfc, password, uuid);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(GetProxy(), GetProxyPort());
            return handler.PostHTTPJson(GetUrl(), "cfdi33/cancel/csd", headers, jsonBody, config, CancelationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }

    @Override
    CancelationResponse Cancelar(String pfx, String rfc, String password, String uuid) {
        try {
            new CancelationValidation(GetUrl(), GetUser(), GetPassword(), GetToken()).ValidateRequestPFX(pfx, password, uuid);
            HashMap<String, String> headers = GetHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.RequestCancelar(pfx, rfc, password, uuid);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(GetProxy(), GetProxyPort());
            return handler.PostHTTPJson(GetUrl(), "cfdi33/cancel/pfx", headers, jsonBody, config, CancelationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }

    @Override
    CancelationResponse Cancelar(String rfc, String uuid) {
        try {
            String path = String.format("cfdi33/cancel/%s/%s", rfc, uuid);
            new CancelationValidation(GetUrl(), GetUser(), GetPassword(), GetToken()).ValidateRequestUUID(rfc, uuid);
            HashMap<String, String> headers = GetHeaders();
            headers.put("Content-Type", "application/json");
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(GetProxy(), GetProxyPort());
            return handler.PostHTTPJson(GetUrl(), path, headers, null, config, CancelationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }

    @Override
    CancelationResponse Cancelar(String xmlCancelation) {
        try {
            new CancelationValidation(GetUrl(), GetUser(), GetPassword(), GetToken()).ValidateRequestXML(xmlCancelation);
            HashMap<String, String> headers = GetHeaders();
            String boundary = UUID.randomUUID().toString();
            xmlCancelation = String.format("--%s\r\nContent-Disposition: form-data; name=xml; filename=xml\r\nContent-Type: application/xml\r\n\r\n%s\r\n--%s--", boundary, xmlCancelation, boundary);
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(GetProxy(), GetProxyPort());
            return handler.PostHTTPMultipart(GetUrl(), "cfdi33/cancel/xml", headers, xmlCancelation, config, CancelationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }
    
}