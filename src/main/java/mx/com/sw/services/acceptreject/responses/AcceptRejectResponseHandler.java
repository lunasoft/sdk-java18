package mx.com.sw.services.acceptreject.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * AcceptRejectHandler Handler para servicio de AcceptReject.
 * @author Daniel Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-17
 */
public class AcceptRejectResponseHandler extends ResponseHandler<AcceptRejectResponse> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return AcceptRejectResponse
     */
    @Override
    public AcceptRejectResponse handleException(Throwable ex) {
        return ResponseHelper.toAcceptRejectResponse(ex);
    }
}
