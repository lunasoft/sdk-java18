package mx.com.sw.services.issue;

public class IssueJson extends BaseStampIssueJson {

    public IssueJson(String url, String token, String proxy, int proxyPort) {
        super(url, token, "issue/json", proxy, proxyPort);
    }

    public IssueJson(String url, String usuario, String password, String proxy, int proxyPort) {
        super(url, usuario, password, "issue/json", proxy, proxyPort);
    }
}