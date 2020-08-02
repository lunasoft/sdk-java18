package mx.com.sw.services.issue;

import java.util.HashMap;

import mx.com.sw.services.stamp.responses.StampResponseHandlerV1;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV2;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV3;
import mx.com.sw.services.stamp.responses.StampResponseHandlerV4;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

public class BaseStampIssueJsonV4 extends IssueJsonService {
    private String formatPath;
    private String operation;

    protected BaseStampIssueJsonV4(String url, String token, String operation, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
        this.formatPath = "v4/cfdi33/%s/%s";
        this.operation = operation;
    }

    protected BaseStampIssueJsonV4(String url, String usuario, String password, String operation, String proxy, int proxyPort) {
        super(url, usuario, password, proxy, proxyPort);
        this.formatPath = "v4/cfdi33/%s/%s";
        this.operation = operation;
    }
    
    protected HashMap<String, String> getHeaders(String email){
        HashMap<String, String> headers = this.getHeaders();
        headers.put("email", email);
        return headers;
    }

    public StampResponseV1 TimbrarV1(String json, String email){
        StampResponseHandlerV1 handler = new StampResponseHandlerV1();
        HashMap<String, String> headers = this.getHeaders(email);
        return super.Timbrar(json, headers, formatPath, operation, "v1", handler, StampResponseV1.class);
    }

    public StampResponseV2 TimbrarV2(String json, String email){
        StampResponseHandlerV2 handler = new StampResponseHandlerV2();
        HashMap<String, String> headers = this.getHeaders(email);
        return super.Timbrar(json, headers, formatPath, operation, "v2", handler, StampResponseV2.class);
    }

    public StampResponseV3 TimbrarV3(String json, String email){
        StampResponseHandlerV3 handler = new StampResponseHandlerV3();
        HashMap<String, String> headers = this.getHeaders(email);
        return super.Timbrar(json, headers, formatPath, operation, "v3", handler, StampResponseV3.class);
    }

    public StampResponseV4 TimbrarV4(String json, String email){
        StampResponseHandlerV4 handler = new StampResponseHandlerV4();
        HashMap<String, String> headers = this.getHeaders(email);
        return super.Timbrar(json, headers, formatPath, operation, "v4", handler, StampResponseV4.class);
    }
}