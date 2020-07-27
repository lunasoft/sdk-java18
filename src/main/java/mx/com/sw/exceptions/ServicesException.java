package mx.com.sw.exceptions;

public class ServicesException extends Exception {
    private static final long serialVersionUID = -7451944976414203826L;
    public String ErrorMessage;

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMSG) {
        ErrorMessage = errorMSG;
    }

    public ServicesException(String errorMSG) {
        super(errorMSG);
        ErrorMessage = errorMSG;
    }
}