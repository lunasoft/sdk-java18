package mx.com.sw.services.account.info.responses;

import mx.com.sw.entities.IResponse;

/**
 * AccountInfoResponse - Clase con la respuesta del servicio AccountInfo.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-17
 */
public class AccountInfoResponse extends IResponse {
    private AccountInfoData data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public AccountInfoResponse(String status, String message, String messageDetail, AccountInfoData data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos de la consulta de saldo cuando está fue "success".
     * @return {@link AccountInfoData}
     */
    public AccountInfoData getData() {
        return this.data;
    }
}
