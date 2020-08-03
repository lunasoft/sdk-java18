package mx.com.sw.services.stamp.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * <h1>StampResponseHandlerV3</h1> Handler para servicio de TimbradoV3.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class StampResponseHandlerV3 extends ResponseHandler<StampResponseV3> {

    /**
     * Método para hacer handle de un exception.
     * @param ex
     * @return StampResponseV3
     */
    @Override
    public StampResponseV3 handleException(Throwable ex) {
        return ResponseHelper.toStampResponseV3(ex);
    }
}
