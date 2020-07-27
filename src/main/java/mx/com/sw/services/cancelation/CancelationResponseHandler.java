package mx.com.sw.services.cancelation;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

public class CancelationResponseHandler extends ResponseHandler<CancelationResponse> {

    @Override
    public CancelationResponse HandleException(Throwable ex) {
        return ResponseHelper.toCancellationResponse(ex);
    }
    
}