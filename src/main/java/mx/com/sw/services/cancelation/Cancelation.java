package mx.com.sw.services.cancelation;

import java.util.HashMap;
import java.util.UUID;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.cancelation.responses.CancelationResponse;
import mx.com.sw.services.cancelation.responses.CancelationResponseHandler;

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

    @Override
    CancelationResponse Cancelar(String cer, String key, String rfc, String password, String uuid) {
        try {
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken()).ValidateRequestCSD(cer, key, password, uuid);
            HashMap<String, String> headers = GetHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.RequestCancelar(cer, key, rfc, password, uuid);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.PostHTTPJson(getUrl(), "cfdi33/cancel/csd", headers, jsonBody, config, CancelationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }

    @Override
    CancelationResponse Cancelar(String pfx, String rfc, String password, String uuid) {
        try {
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken()).ValidateRequestPFX(pfx, password, uuid);
            HashMap<String, String> headers = GetHeaders();
            headers.put("Content-Type", "application/json");
            String jsonBody = this.RequestCancelar(pfx, rfc, password, uuid);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.PostHTTPJson(getUrl(), "cfdi33/cancel/pfx", headers, jsonBody, config, CancelationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }

    @Override
    CancelationResponse Cancelar(String rfc, String uuid) {
        try {
            String path = String.format("cfdi33/cancel/%s/%s", rfc, uuid);
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken()).ValidateRequestUUID(rfc, uuid);
            HashMap<String, String> headers = GetHeaders();
            headers.put("Content-Type", "application/json");
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.PostHTTPJson(getUrl(), path, headers, null, config, CancelationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }

    @Override
    CancelationResponse Cancelar(String xmlCancelation) {
        try {
            new CancelationValidation(getUrl(), getUser(), getPassword(), getToken()).ValidateRequestXML(xmlCancelation);
            HashMap<String, String> headers = GetHeaders();
            String boundary = UUID.randomUUID().toString();
            xmlCancelation = String.format("--%s\r\nContent-Disposition: form-data; name=xml; filename=xml\r\nContent-Type: application/xml\r\n\r\n%s\r\n--%s--", boundary, xmlCancelation, boundary);
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            return handler.PostHTTPMultipart(getUrl(), "cfdi33/cancel/xml", headers, xmlCancelation, config, CancelationResponse.class);
        } catch (Exception e) {
            return handler.HandleException(e);
        }
    }
    
}