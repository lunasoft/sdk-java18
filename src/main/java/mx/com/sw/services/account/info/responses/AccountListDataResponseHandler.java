package mx.com.sw.services.account.info.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * CsdListDataResponseHandler Handler para servicio de CSD en las acciones de consulta.
 */
public class AccountListDataResponseHandler extends ResponseHandler<AccountListDataResponse>{

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return CsdResponse
     */
    @Override
    public AccountListDataResponse handleException(Throwable ex) {
        return ResponseHelper.toAccountListDataResponse(ex);
    }
}
