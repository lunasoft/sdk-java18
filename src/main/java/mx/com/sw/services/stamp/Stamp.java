package mx.com.sw.services.stamp;

public class Stamp extends BaseStamp {
    public Stamp(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, "stamp", proxy, proxyPort);
    }
    public Stamp(String url, String token, String proxy, int proxyPort) {
        super(url, token, "stamp", proxy, proxyPort);
    }
}