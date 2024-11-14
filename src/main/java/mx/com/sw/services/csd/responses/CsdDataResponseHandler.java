package mx.com.sw.services.csd.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * CsdDataResponseHandler Handler para servicio de CSD en las acciones de consulta.
 */
public class CsdDataResponseHandler extends ResponseHandler<CsdDataResponse> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return CsdResponse
     */
    @Override
    public CsdDataResponse handleException(Throwable ex) {
        return ResponseHelper.toCsdDataResponse(ex);
    }
}
