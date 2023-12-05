package mx.com.sw.services.account.info.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

public class AccountInfoActionResponseHandler extends ResponseHandler<AccountInfoActionResponse>{
 /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return AccountActionsData
     */
    @Override
    public AccountInfoActionResponse handleException(Throwable ex) {
        return ResponseHelper.toAccountInfoActionResponse(ex);
    
    }
}