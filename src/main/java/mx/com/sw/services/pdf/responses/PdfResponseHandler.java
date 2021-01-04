package mx.com.sw.services.pdf.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * PdfResponseHandler handler para servicio de generacion PDF.
 * @author Manuel Castillo
 * @version 0.0.0.1
 * @since 2020-12-15
 */
public class PdfResponseHandler extends ResponseHandler<PdfResponse> {

    /**
     * Método para hacer handle de un exception.
     * @param ex exception.
     * @return PdfResponse
     */
    @Override
    public PdfResponse handleException(Throwable ex) {
        return ResponseHelper.toPdfResponse(ex);
    }
}
