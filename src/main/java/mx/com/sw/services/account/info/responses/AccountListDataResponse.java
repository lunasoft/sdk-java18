package mx.com.sw.services.account.info.responses;

import java.util.List;
import mx.com.sw.entities.IResponse;

/**
 * AccountListDataResponse.
 */
public class AccountListDataResponse extends IResponse {
    private List<AccountInfoData> data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public AccountListDataResponse(String status, String message, String messageDetail, List<AccountInfoData> data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    /**
     * Obtiene los datos del certificado cuando la consulta fue "success".
     * @return CsdData
     */
    public List<AccountInfoData> getData() {
        return this.data;
    }
}
