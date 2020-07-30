package mx.com.sw.services.stamp;

public class StampV4 extends BaseStampV4 {
    public StampV4(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, "stamp", proxy, proxyPort);
    }
    public StampV4(String url, String token, String proxy, int proxyPort) {
        super(url, token, "stamp", proxy, proxyPort);
    }
}