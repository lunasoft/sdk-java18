package mx.com.sw.services.Validate.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * ValidateResponseHandler handler para servicio de Validacion de XML.
 */
public class ValidateResponseHandler extends ResponseHandler<ValidateResponse>{
    
    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return ValidateResponse
     */
    @Override
    public ValidateResponse handleException(Throwable ex) {
        return ResponseHelper.toValidateResponse(ex);
    }
}
