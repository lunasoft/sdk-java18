package mx.com.sw.services.cancelationretention.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * CancelationRetentionResponseHandler Handler para servicio de Cancelación de Retenciones.
 * @author Martin F
 * @version 0.0.0.1
 * @since 2025-01-27
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