package mx.com.sw.services.stamp.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

public class StampResponseHandlerV4 extends ResponseHandler<StampResponseV4> {

    @Override
    public StampResponseV4 handleException(Throwable ex) {
        return ResponseHelper.toStampResponseV4(ex);
    }
    
}