package mx.com.sw.services.StatusCfdi.request;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.eval.IRequestor;

/**
 * Clase que genera una solicitud para concer el estatus de CFDI mediante los servicios del SAT.
 * Implementa la interfaz IRequestor.
 */
public class StatusCfdiOptionsRequest implements IRequestor {
    private String URI;
    private String rfcEmisor;
    private String rfcReceptor;
    private String total;
    private String uuid;
    private String sello;
    private String action;

    /**
     * Constructor de la clase StatusCfdiOptionsRequest.
     * 
     * @param URI         La URI de la solicitud.
     * @param action      La acción de la solicitud.
     * @param rfcEmisor   El RFC del emisor.
     * @param rfcReceptor El RFC del receptor.
     * @param total       El total del CFDI.
     * @param uuid        El UUID del CFDI.
     * @param sello       El sello del CFDI.
     * @param proxyHost   El host del proxy.
     * @param proxyPort   El puerto del proxy.
     */
    public StatusCfdiOptionsRequest(String URI, String action, String rfcEmisor, String rfcReceptor, String total, String uuid, String sello, String proxyHost, int proxyPort) {
        this.URI = URI;
        this.rfcEmisor = rfcEmisor;
        this.rfcReceptor = rfcReceptor;
        this.total = total;
        this.uuid = uuid;
        this.sello = sello;
        this.action = action;
    }

    /**
     * Obtiene la URI de la solicitud.
     * 
     * @return La URI de la solicitud.
     */
    public String getURI() {
        return URI;
    }

    /**
     * Obtiene el RFC del emisor.
     * 
     * @return El RFC del emisor.
     */
    public String getRfcEmisor() {
        return rfcEmisor;
    }

    /**
     * Obtiene el RFC del receptor.
     * 
     * @return El RFC del receptor.
     */
    public String getRfcReceptor() {
        return rfcReceptor;
    }

    /**
     * Obtiene el total del CFDI.
     * 
     * @return El total del CFDI.
     */
    public String getTotal() {
        return total;
    }

    /**
     * Obtiene el UUID del CFDI.
     * 
     * @return El UUID del CFDI.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Obtiene el sello del CFDI.
     * 
     * @return El sello del CFDI.
     */
    public String getSello() {
        return sello;
    }

    /**
     * Obtiene la acción de la solicitud.
     * 
     * @return La acción de la solicitud.
     */
    public String getAction() {
        return action;
    }

    /**
     * Método sobreescrito de la interfaz IRequestor.
     * 
     * @param arg0                              Los archivos de clase.
     * @param arg1                              Los caracteres.
     * @return                                  Si se aceptan los archivos de clase.
     * @throws UnsupportedOperationException    Si se llama a este método.
     */
    @Override
    public boolean acceptClassFiles(ClassFile[] arg0, char[] arg1) {
        throw new UnsupportedOperationException("Unimplemented method 'acceptClassFiles'");
    }

    /**
     * Método sobreescrito de la interfaz IRequestor.
     * 
     * @param arg0                              El problema categorizado.
     * @param arg1                              Los caracteres.
     * @param arg2                              El número.
     * @throws UnsupportedOperationException    Si se llama a este método.
     */
    @Override
    public void acceptProblem(CategorizedProblem arg0, char[] arg1, int arg2) {
        throw new UnsupportedOperationException("Unimplemented method 'acceptProblem'");
    }
}