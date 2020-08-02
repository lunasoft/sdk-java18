package mx.com.sw.services.stamp;

import java.util.HashMap;
import java.util.UUID;

import org.apache.http.client.config.RequestConfig;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.ResponseHandler;
import mx.com.sw.services.Services;

public abstract class StampService extends Services {

    protected StampService(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
    }

    protected StampService(String url, String usuario, String password, String proxy, int proxyPort) {
        super(url, usuario, password, proxy, proxyPort);
    }

    protected String getMultipartBody(String xmlString, String boundary) {
        return String.format(
                "--%s\r\nContent-Disposition: form-data; name=xml; filename=xml\r\nContent-Type: application/xml\r\n\r\n%s\r\n--%s--",
                boundary, xmlString, boundary);
    }

    protected HashMap<String, String> getHeaders()
    {
        super.setupRequest();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }

    protected <T> T Timbrar(String xml, boolean isBase64, String formatPath, String operation, String version, ResponseHandler<T> handler, Class<T> classType) {
        try {
            String format = isBase64 ? "b64" : "";
            String boundary = UUID.randomUUID().toString();
            HashMap<String, String> headers = this.getHeaders();
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            xml = this.getMultipartBody(xml, boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            String path = String.format("cfdi33/%s/%s/%s", operation, version, format);
            return handler.PostHTTPMultipart(getUrl(), path, headers, xml, config, classType);
        } catch (Exception ex) {
            return handler.HandleException(ex);
        }
    }

}