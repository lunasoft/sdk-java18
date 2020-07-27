package mx.com.sw.entities;

public abstract class IResponse {
    public String status;
    public String message;
    public String messageDetail;

    public IResponse(){
        
    }
    public IResponse(String status, String message, String messageDetail) {
        this.status = status;
        this.message = message;
        this.messageDetail = messageDetail;
    }
}