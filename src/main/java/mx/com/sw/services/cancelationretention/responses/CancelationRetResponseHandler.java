package mx.com.sw.services.cancelationretention.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;


/**
 * Handler para servicio de Cancelación de Retenciones.
 */
public class CancelationRetResponseHandler extends ResponseHandler<CancelationRetResponse> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return CancelationRetResponse
     */
    @Override
    public CancelationRetResponse handleException(Throwable ex) {
        return ResponseHelper.toCancelationRetResponse(ex);
    }

} 