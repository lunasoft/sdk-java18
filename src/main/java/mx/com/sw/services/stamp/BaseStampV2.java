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
    private String formatPath;

    protected BaseStampV2(String url, String user, String password, String operation, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
        this.operation = operation;
        this.formatPath = "cfdi33/v2/%s/%s/%s";
    }

    protected BaseStampV2(String url, String token, String operation, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
        this.operation = operation;
        this.formatPath = "cfdi33/v2/%s/%s/%s";
    }

    public StampResponseV1 TimbrarV1(String xml, boolean isBase64){
        StampResponseHandlerV1 handler = new StampResponseHandlerV1();
        return super.Timbrar(xml, isBase64, formatPath, operation, "v1", handler, StampResponseV1.class);
    }

    public StampResponseV2 TimbrarV2(String xml, boolean isBase64){
        StampResponseHandlerV2 handler = new StampResponseHandlerV2();
        return super.Timbrar(xml, isBase64, formatPath, operation, "v2", handler, StampResponseV2.class);
    }

    public StampResponseV3 TimbrarV3(String xml, boolean isBase64){
        StampResponseHandlerV3 handler = new StampResponseHandlerV3();
        return super.Timbrar(xml, isBase64, formatPath, operation, "v3", handler, StampResponseV3.class);
    }

    public StampResponseV4 TimbrarV4(String xml, boolean isBase64){
        StampResponseHandlerV4 handler = new StampResponseHandlerV4();
        return super.Timbrar(xml, isBase64, formatPath, operation, "v4", handler, StampResponseV4.class);
    }
}