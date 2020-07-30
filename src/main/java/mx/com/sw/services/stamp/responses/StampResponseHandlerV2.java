package mx.com.sw.services.stamp.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

public class StampResponseHandlerV2 extends ResponseHandler<StampResponseV2> {

    @Override
    public StampResponseV2 HandleException(Throwable ex) {
        return ResponseHelper.toStampResponseV2(ex);
    }
    
}