package mx.com.sw.services.csd.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * CsdListDataResponseHandler Handler para servicio de CSD en las acciones de consulta.
*/
public class CsdListDataResponseHandler extends ResponseHandler<CsdListDataResponse> {
    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return CsdResponse
    */
    @Override
    public CsdListDataResponse handleException(Throwable ex) {
        return ResponseHelper.toCsdListDataResponse(ex);
    }
}
