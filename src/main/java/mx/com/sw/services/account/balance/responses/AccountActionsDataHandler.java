package mx.com.sw.services.account.balance.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

public class AccountActionsDataHandler extends ResponseHandler<AccountActionsData>{
 /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return AccountActionsData
     */
    @Override
    public AccountActionsData handleException(Throwable ex) {
        return ResponseHelper.toAccountActionsData(ex);
    }
    
    
}
