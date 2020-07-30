package mx.com.sw.services.stamp;

import java.util.HashMap;

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

}