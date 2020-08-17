package mx.com.sw.services.stamp.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * StampResponseHandlerV2 Handler para servicio de TimbradoV2.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class StampResponseHandlerV2 extends ResponseHandler<StampResponseV2> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return StampResponseV2
     */
    @Override
    public StampResponseV2 handleException(Throwable ex) {
        return ResponseHelper.toStampResponseV2(ex);
    }
}
