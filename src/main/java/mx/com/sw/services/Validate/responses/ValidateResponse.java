package mx.com.sw.services.Validate.responses;

import java.util.List;
import mx.com.sw.entities.IResponse;

/**
 * ValidateResponse Clase con la informacion de la validacion.
 */
public class ValidateResponse extends IResponse {
    private List<ValidateNodeDetail> detail;
    private String cadenaOriginalSAT;
    private String cadenaOriginalComprobante;
    private String uuid;
    private String statusSat;
    private String statusCodeSat;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param detail objeto con los nodos de respuesta.
     * @param cadenaOriginalSAT cadena original del SAT.
     * @param cadenaOriginalComprobante cadena original del comprobate.
     * @param uuid UUID del comprobante enviado.
     * @param statusSat estatus del comprobante ante el SAT.
     * @param statusCodeSat codigo de estatus del SAT
     */
    public ValidateResponse(String status, String message, String messageDetail, List<ValidateNodeDetail> detail,
            String cadenaOriginalSAT, String cadenaOriginalComprobante, String uuid, String statusSat,
            String statusCodeSat) {
        super(status, message, messageDetail);
        this.detail = detail;
        this.cadenaOriginalSAT = cadenaOriginalSAT;
        this.cadenaOriginalComprobante = cadenaOriginalComprobante;
        this.uuid = uuid;
        this.statusSat = statusSat;
        this.statusCodeSat = statusCodeSat;
    }

    //En caso de "success" se obtendran todos los datos de la validacion
    /**
     * Obtiene una lista de nodos de la validacion.
     * @return ValidateData
     */
    public List<ValidateNodeDetail> getDetail() {
        return this.detail;
    }

    /**
     * Retorna la cadena original del SAT.
     * @return String
    */
    public String getCadenaOriginalSAT() {
        return cadenaOriginalSAT;
    }

    /**
     * Retorna la cadena original del Comprobante.
     * @return String
    */
    public String getCadenaOriginalComprobante() {
        return cadenaOriginalComprobante;
    }

    /**
     * Retorna el UUID del CFDI.
     * @return String
    */
    public String getUuid() {
        return uuid;
    }

    /**
     * Retorna el estatus en el SAT del CFDI.
     * @return String
    */
    public String getStatusSat() {
        return statusSat;
    }

    /**
     * Retorna el codigo de estatus del SAT.
     * @return String
    */
    public String getStatusCodeSat() {
        return statusCodeSat;
    }
}
