package mx.com.sw.services.pendings.response;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * PendingsHandler - Handler para servicio de pendientes.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-26
 */
public class PendingsResponseHandler extends ResponseHandler<PendingsResponse> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return PendingsHandler
     */
    @Override
    public PendingsResponse handleException(Throwable ex) {
        return ResponseHelper.toPendingsResponse(ex);
    }
}
