package mx.com.sw.exceptions;

public class ServicesException extends Exception {
    private static final long serialVersionUID = -7451944976414203826L;
    public String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ServicesException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public ServicesException(String errorMessage, Throwable exeption){
        super(errorMessage, exeption);
        this.errorMessage = errorMessage;
    }
}