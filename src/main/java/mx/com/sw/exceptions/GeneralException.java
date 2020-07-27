package mx.com.sw.exceptions;

public class GeneralException extends Exception {
    private static final long serialVersionUID = -8710534610872475478L;
    public int HttpStatusCode;
    public String ErrorMessage;

    public int getHttpStatusCode() {
        return HttpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        HttpStatusCode = httpStatusCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMSG) {
        ErrorMessage = errorMSG;
    }

    public GeneralException(int httpStatusCode, String errorMSG) {
        super(httpStatusCode + " ----> " + errorMSG);
        HttpStatusCode = httpStatusCode;
        ErrorMessage = errorMSG;
    }
}