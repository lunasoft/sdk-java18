package mx.com.sw.services.stampretention.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * StampRetentionResponseHandlerV3 Handler para servicio de Timbrado de Retenciones V3.
 */
public class StampRetentionResponseHandlerV3 extends ResponseHandler<StampRetentionResponseV3> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return StampRetentionResponseV3
     */
    @Override
    public StampRetentionResponseV3 handleException(Throwable ex) {
        return ResponseHelper.toStampRetentionResponseV3(ex);
    }
} 