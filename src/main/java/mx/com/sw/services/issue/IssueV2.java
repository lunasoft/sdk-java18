package mx.com.sw.services.issue;

import mx.com.sw.services.stamp.BaseStampV2;

public class IssueV2 extends BaseStampV2 {

    public IssueV2(String url, String token, String operation, String proxy, int proxyPort) {
        super(url, token, "issue", proxy, proxyPort);
    }
    
    public IssueV2(String url, String user, String password, String operation, String proxy, int proxyPort) {
        super(url, user, password, "issue", proxy, proxyPort);
    }
}