package mx.com.sw.services.account.balance.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * AccountBalanceResponseHandler - Handler para servicio de consulta de saldos.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-14
 */
public class AccountBalanceResponseHandler extends ResponseHandler<AccountBalanceResponse> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return AccountBalanceResponseHandler
     */
    @Override
    public AccountBalanceResponse handleException(Throwable ex) {
        return ResponseHelper.toAccountBalanceResponse(ex);
    }

}
