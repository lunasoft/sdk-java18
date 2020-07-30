package mx.com.sw.services.stamp.responses;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

public class StampResponseHandlerV3 extends ResponseHandler<StampResponseV3> {

    @Override
    public StampResponseV3 HandleException(Throwable ex) {
        return ResponseHelper.toStampResponseV3(ex);
    }
    
}