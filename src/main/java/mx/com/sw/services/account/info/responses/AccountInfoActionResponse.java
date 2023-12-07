package mx.com.sw.services.account.info.responses;

import mx.com.sw.entities.IResponse;

public class AccountInfoActionResponse extends IResponse {
    private String data;

    public AccountInfoActionResponse(String status, String message, String messageDetail, String data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

}
