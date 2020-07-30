package mx.com.sw.services.stamp;

import java.util.HashMap;
import java.util.UUID;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV1;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV2;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV3;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

public abstract class BaseStampV2 extends StampService {
    private String operation;
    protected BaseStampV2(String url, String user, String password, String operation, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
        this.operation = operation;
    }
    protected BaseStampV2(String url, String token, String operation, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
        this.operation = operation;
    }
    public StampResponseV1 TimbrarV1(String xml, boolean isBase64){
        StampResponseHandlerV1 handler = new StampResponseHandlerV1();
        try {
            String format = isBase64 ? "b64" : "";
            String boundary = UUID.randomUUID().toString();
            HashMap<String, String> headers = this.getHeaders();
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            xml = this.getMultipartBody(xml, boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            String path = String.format("cfdi33/v2/%s/%s/%s", operation, "v1", format);
            return handler.PostHTTPMultipart(getUrl(), path, headers, xml, config, StampResponseV1.class);
        } catch (Exception ex) {
            return handler.HandleException(ex);
        }
    }

    public StampResponseV2 TimbrarV2(String xml, boolean isBase64){
        StampResponseHandlerV2 handler = new StampResponseHandlerV2();
        try {
            String format = isBase64 ? "b64" : "";
            String boundary = UUID.randomUUID().toString();
            HashMap<String, String> headers = this.getHeaders();
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            xml = this.getMultipartBody(xml, boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            String path = String.format("cfdi33/v2/%s/%s/%s", operation, "v2", format);
            return handler.PostHTTPMultipart(getUrl(), path, headers, xml, config, StampResponseV2.class);
        } catch (Exception ex) {
            return handler.HandleException(ex);
        }
    }

    public StampResponseV3 TimbrarV3(String xml, boolean isBase64){
        StampResponseHandlerV3 handler = new StampResponseHandlerV3();
        try {
            String format = isBase64 ? "b64" : "";
            String boundary = UUID.randomUUID().toString();
            HashMap<String, String> headers = this.getHeaders();
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            xml = this.getMultipartBody(xml, boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            String path = String.format("cfdi33/v2/%s/%s/%s", operation, "v3", format);
            return handler.PostHTTPMultipart(getUrl(), path, headers, xml, config, StampResponseV3.class);
        } catch (Exception ex) {
            return handler.HandleException(ex);
        }
    }

    public StampResponseV4 TimbrarV4(String xml, boolean isBase64){
        StampResponseHandlerV4 handler = new StampResponseHandlerV4();
        try {
            String format = isBase64 ? "b64" : "";
            String boundary = UUID.randomUUID().toString();
            HashMap<String, String> headers = this.getHeaders();
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            xml = this.getMultipartBody(xml, boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            String path = String.format("cfdi33/v2/%s/%s/%s", operation, "v4", format);
            return handler.PostHTTPMultipart(getUrl(), path, headers, xml, config, StampResponseV4.class);
        } catch (Exception ex) {
            return handler.HandleException(ex);
        }
    }
}