package mx.com.sw.services.stamp.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * <h1>StampResponseHandlerV4</h1> Handler para servicio de TimbradoV4.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class StampResponseHandlerV4 extends ResponseHandler<StampResponseV4> {

    /**
     * Método para hacer handle de un exception.
     * @param ex
     * @return StampResponseV4
     */
    @Override
    public StampResponseV4 handleException(Throwable ex) {
        return ResponseHelper.toStampResponseV4(ex);
    }
}
