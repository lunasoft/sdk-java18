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

public class BaseStampIssueJson extends IssueJsonService {
    private String formatPath;
    private String operation;

    protected BaseStampIssueJson(String url, String token, String operation, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
        this.formatPath = "v3/cfdi33/%s/%s";
        this.operation = operation;
    }

    protected BaseStampIssueJson(String url, String usuario, String password, String operation, String proxy, int proxyPort) {
        super(url, usuario, password, proxy, proxyPort);
        this.formatPath = "v3/cfdi33/%s/%s";
        this.operation = operation;
    }

    public StampResponseV1 TimbrarV1(String json){
        StampResponseHandlerV1 handler = new StampResponseHandlerV1();
        HashMap<String, String> headers = this.getHeaders();
        return super.Timbrar(json, headers, formatPath, operation, "v1", handler, StampResponseV1.class);
    }

    public StampResponseV2 TimbrarV2(String json){
        StampResponseHandlerV2 handler = new StampResponseHandlerV2();
        HashMap<String, String> headers = this.getHeaders();
        return super.Timbrar(json, headers, formatPath, operation, "v2", handler, StampResponseV2.class);
    }

    public StampResponseV3 TimbrarV3(String json){
        StampResponseHandlerV3 handler = new StampResponseHandlerV3();
        HashMap<String, String> headers = this.getHeaders();
        return super.Timbrar(json, headers, formatPath, operation, "v3", handler, StampResponseV3.class);
    }

    public StampResponseV4 TimbrarV4(String json){
        StampResponseHandlerV4 handler = new StampResponseHandlerV4();
        HashMap<String, String> headers = this.getHeaders();
        return super.Timbrar(json, headers, formatPath, operation, "v4", handler, StampResponseV4.class);
    }
    
}