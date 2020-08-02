package mx.com.sw.services.issue;

import mx.com.sw.services.stamp.BaseStampV4;

public class IssueV4 extends BaseStampV4 {
    
    public IssueV4(String url, String token, String operation, String proxy, int proxyPort) {
        super(url, token, "issue", proxy, proxyPort);
    }
    
    public IssueV4(String url, String user, String password, String operation, String proxy, int proxyPort) {
        super(url, user, password, "issue", proxy, proxyPort);
    }
}