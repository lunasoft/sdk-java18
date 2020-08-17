package mx.com.sw.services.cancelation.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * CancelationResponseHandler Handler para servicio de Cancelación.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationResponseHandler extends ResponseHandler<CancelationResponse> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return CancelationResponse
     */
    @Override
    public CancelationResponse handleException(Throwable ex) {
        return ResponseHelper.toCancellationResponse(ex);
    }

}
