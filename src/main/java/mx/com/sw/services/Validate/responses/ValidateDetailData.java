package mx.com.sw.services.Validate.responses;

/**
 * ValidateDetailData Clase con la informacion detallada de cada nodo.
 */
public class ValidateDetailData {
    private String message;
    private String messageDetail;
    private String type;

    /**
     * Retorna message de la seccion.
     * @return String
    */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Retorna messageDetail detallado de la seccion.
     * @return String
    */
    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    /**
     * Retorna type de la seccion.
     * @return String
    */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
