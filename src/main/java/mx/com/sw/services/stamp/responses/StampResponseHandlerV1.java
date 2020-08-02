package mx.com.sw.services.stamp.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

public class StampResponseHandlerV1 extends ResponseHandler<StampResponseV1> {

    @Override
    public StampResponseV1 handleException(Throwable ex) {
        return ResponseHelper.toStampResponseV1(ex);
    }
    
}