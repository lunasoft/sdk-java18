package mx.com.sw.exceptions;

/**
 * <h1>ServicesException</h1> Está exception ocurre cuando son validaciones
 * simples.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class ServicesException extends Exception {
    private static final long serialVersionUID = -7451944976414203826L;
    private String errorMessage;

    /**
     * Constructor de la clase.
     * @param errorMessage
     */
    public ServicesException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    /**
     * Constructor de la clase.
     * @param errorMessage
     * @param exception
     */
    public ServicesException(String errorMessage, Throwable exception) {
        super(errorMessage, exception);
        this.errorMessage = errorMessage;
    }

    /**
     * Este método regresa el mensaje de error.
     * @return String
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Este método configura el mensaje de error.
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
