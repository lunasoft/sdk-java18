package mx.com.sw.services.issue;

import java.util.HashMap;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.ResponseHandler;
import mx.com.sw.services.Services;

public class IssueJsonService extends Services {

    protected IssueJsonService(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
    }
    protected IssueJsonService(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
    }

    protected HashMap<String, String> getHeaders()
    {
        super.setupRequest();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        headers.put("Content-Type", "application/jsontoxml");
        return headers;
    }

    protected <T> T Timbrar(String json, HashMap<String, String> headers, String formatPath, String operation, String version, ResponseHandler<T> handler, Class<T> classType) {
        try {
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            String path = String.format(formatPath, operation, version);
            return handler.PostHTTPJson(getUrl(), path, headers, json, config, classType);
        } catch (Exception ex) {
            return handler.HandleException(ex);
        }
    }
}