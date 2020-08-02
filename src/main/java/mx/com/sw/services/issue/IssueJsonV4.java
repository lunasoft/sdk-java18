package mx.com.sw.services.issue;

public class IssueJsonV4 extends BaseStampIssueJsonV4 {
    public IssueJsonV4(String url, String token, String proxy, int proxyPort) {
        super(url, token, "issue/json", proxy, proxyPort);
    }

    public IssueJsonV4(String url, String usuario, String password, String proxy, int proxyPort) {
        super(url, usuario, password, "issue/json", proxy, proxyPort);
    }
}