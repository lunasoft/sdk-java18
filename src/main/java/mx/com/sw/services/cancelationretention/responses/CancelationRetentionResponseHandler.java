package mx.com.sw.services.cancelationretention.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * Handler para servicio de Cancelación de Retenciones.
 */
public class CancelationRetentionResponseHandler extends ResponseHandler<CancelationRetentionResponse> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return CancelationRetentionResponse
     */
    @Override
    public CancelationRetentionResponse handleException(Throwable ex) {
        return ResponseHelper.toCancelationRetentionResponse(ex);
    }

} 