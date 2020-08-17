package mx.com.sw.services.account.info.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * AccountInfoResponseHandler - Handler para servicio de consulta de saldos.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-17
 */
public class AccountInfoResponseHandler extends ResponseHandler<AccountInfoResponse> {
    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return {@link AccountInfoResponse}
     */
    @Override
    public AccountInfoResponse handleException(Throwable ex) {
        return ResponseHelper.toAccountInfoResponse(ex);
    }
}
