package mx.com.sw.exceptions;

/**
 * ServicesException Está exception ocurre cuando son validaciones
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
     * @param errorMessage mensaje de error.
     */
    public ServicesException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    /**
     * Constructor de la clase.
     * @param errorMessage mensaje de error.
     * @param exception exception arrojada.
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
     * @param errorMessage mensajde e error.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
