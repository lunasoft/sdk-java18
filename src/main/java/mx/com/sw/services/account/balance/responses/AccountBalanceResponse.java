package mx.com.sw.services.account.balance.responses;

import mx.com.sw.entities.IResponse;

/**
 * AccountBalanceData - Clase con la informacion del saldo del cliente.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-14
 */
public class AccountBalanceResponse extends IResponse {
    private AccountBalanceData data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public AccountBalanceResponse(String status, String message, String messageDetail, AccountBalanceData data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos de la consulta de saldo cuando está fue "success".
     * @return {@link AccountBalanceData}
     */
    public AccountBalanceData getData() {
        return this.data;
    }
}
