package mx.com.sw.services.relations.response;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * AcceptRejectHandler Handler para servicio de AcceptReject.
 * @author Daniel Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-17
 */
public class RelationsResponseHandler extends ResponseHandler<RelationsResponse> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return RelationsResponse
     */
    @Override
    public RelationsResponse handleException(Throwable ex) {
        return ResponseHelper.toRelationsResponse(ex);
    }
}
