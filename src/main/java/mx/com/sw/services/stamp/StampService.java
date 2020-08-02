package mx.com.sw.services.stamp;

import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.services.ResponseHandler;
import mx.com.sw.services.Services;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;
import java.util.HashMap;
import java.util.UUID;
import org.apache.http.client.config.RequestConfig;

public abstract class StampService extends Services {

    protected StampService(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
    }

    protected StampService(String url, String usuario, String password, String proxy, int proxyPort) {
        super(url, usuario, password, proxy, proxyPort);
    }

    public abstract StampResponseV1 TimbrarV1(String xml, boolean isBase64);

    public abstract StampResponseV2 TimbrarV2(String xml, boolean isBase64);

    public abstract StampResponseV3 TimbrarV3(String xml, boolean isBase64);

    public abstract StampResponseV4 TimbrarV4(String xml, boolean isBase64);

    protected String getMultipartBody(String xmlString, String boundary) {
        return String.format(
                "--%s\r\nContent-Disposition: form-data; name=xml; filename=xml\r\nContent-Type: application/xml\r\n\r\n%s\r\n--%s--",
                boundary, xmlString, boundary);
    }

    protected HashMap<String, String> getHeaders() {
        super.setupRequest();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }

    protected <T> T Timbrar(String xml, boolean isBase64, String formatPath, String operation, String version,
            ResponseHandler<T> handler, Class<T> classType) {
        try {
            String format = isBase64 ? "b64" : "";
            String boundary = UUID.randomUUID().toString();
            HashMap<String, String> headers = this.getHeaders();
            headers.put("Content-Type", "multipart/form-data; boundary=" + boundary);
            xml = this.getMultipartBody(xml, boundary);
            RequestConfig config = GeneralHelpers.setProxyAndTimeOut(getProxy(), getProxyPort());
            String path = String.format(formatPath, operation, version, format);
            return handler.postHTTPMultipart(getUrl(), path, headers, xml, config, classType);
        } catch (Exception ex) {
            return handler.handleException(ex);
        }
    }

}