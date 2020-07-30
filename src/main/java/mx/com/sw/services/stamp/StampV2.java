package mx.com.sw.services.stamp;

public class StampV2 extends BaseStampV2 {
    public StampV2(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, "stamp", proxy, proxyPort);
    }
    public StampV2(String url, String token, String proxy, int proxyPort) {
        super(url, token, "stamp", proxy, proxyPort);
    }
}