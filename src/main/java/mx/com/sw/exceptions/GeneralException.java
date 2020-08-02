package mx.com.sw.exceptions;

/**
 * <h1>GeneralException</h1> Está exception ocurre se encuentra algún problema
 * en la comunicación con los servicios.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class GeneralException extends Exception {
    private static final long serialVersionUID = -8710534610872475478L;
    private int httpStatusCode;
    private String errorMessage;

    /**
     * Constructor de la clase.
     * @param httpStatusCode
     * @param errorMSG
     */
    public GeneralException(int httpStatusCode, String errorMSG) {
        super(httpStatusCode + " ----> " + errorMSG);
        this.httpStatusCode = httpStatusCode;
        errorMessage = errorMSG;
    }

    /**
     * Obtiene el httpStatusCode que se tiene configurado.
     * @return httpStatusCode
     */
    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    /**
     * Configura el httpStatusCode.
     * @param httpStatusCode
     */
    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    /**
     * Obtiene el mensaje de error.
     * @return errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Configura el mensaje de error.
     * @param errorMSG
     */
    public void setErrorMessage(String errorMSG) {
        errorMessage = errorMSG;
    }
}
