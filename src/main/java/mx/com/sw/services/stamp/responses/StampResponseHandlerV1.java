package mx.com.sw.services.stamp.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * StampResponseHandlerV1 Handler para servicio de TimbradoV1.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class StampResponseHandlerV1 extends ResponseHandler<StampResponseV1> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return StampResponseV1
     */
    @Override
    public StampResponseV1 handleException(Throwable ex) {
        return ResponseHelper.toStampResponseV1(ex);
    }
}
