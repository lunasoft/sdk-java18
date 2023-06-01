package mx.com.sw.services.csd.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * CsdResponseHandler Handler para servicio de CSD en las acciones de carga y eliminacion de certificados.
 */
public class CsdResponseHandler extends ResponseHandler<CsdResponse>{
    
    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return CsdResponse
     */
    @Override
    public CsdResponse handleException(Throwable ex) {
        return ResponseHelper.toCsdResponse(ex);
    }

}
