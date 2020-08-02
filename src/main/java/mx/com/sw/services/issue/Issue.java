package mx.com.sw.services.issue;

import mx.com.sw.services.stamp.BaseStamp;

public class Issue extends BaseStamp {

    public Issue(String url, String token, String proxy, int proxyPort) {
        super(url, token, "issue", proxy, proxyPort);
    }
    
    public Issue(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, "issue", proxy, proxyPort);
    }
    
}