package mx.com.sw.services.account.balance.responses;

import mx.com.sw.entities.IResponse;

public class AccountBalanceActionResponse extends IResponse {
    private String data;

    /**
     * Constructor de la clase.
     * 
     * @param status        status de llamada a API.
     * @param message       mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data          objeto con los datos de respuesta.
     */
    public AccountBalanceActionResponse(String status, String message, String messageDetail, String data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos del movimiento de saldo cuando está fue "success".
     * 
     * @return {@link AccountBalanceActionResponse}
     */
    public String getData() {
        return this.data;
    }
}
