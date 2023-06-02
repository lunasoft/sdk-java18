package mx.com.sw.services.StatusCfdi.responses;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.eval.IRequestor;

public class StatusCancelationOptionsRequest implements IRequestor {
    private String URI;
    private String rfcEmisor;
    private String rfcReceptor;
    private String total;
    private String uuid;
    private String sello;
    private String action;

    public StatusCancelationOptionsRequest(String URI, String action, String rfcEmisor, String rfcReceptor, String total, String uuid, String sello, String proxyHost, int proxyPort) {
        this.URI = URI;
        this.rfcEmisor = rfcEmisor;
        this.rfcReceptor = rfcReceptor;
        this.total = total;
        this.uuid = uuid;
        this.sello = sello;
        this.action = action;
    }

    public String getURI() {
        return URI;
    }

    public String getRfcEmisor() {
        return rfcEmisor;
    }

    public String getRfcReceptor() {
        return rfcReceptor;
    }

    public String getTotal() {
        return total;
    }

    public String getUuid() {
        return uuid;
    }

    public String getSello() {
        return sello;
    }

    public String getAction() {
        return action;
    }

    @Override
    public boolean acceptClassFiles(ClassFile[] arg0, char[] arg1) {
        throw new UnsupportedOperationException("Unimplemented method 'acceptClassFiles'");
    }

    @Override
    public void acceptProblem(CategorizedProblem arg0, char[] arg1, int arg2) {
        throw new UnsupportedOperationException("Unimplemented method 'acceptProblem'");
    }
}