package mx.com.sw.services.storage;


import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;


public class StorageResponseHandler extends ResponseHandler<StorageResponse> {

    @Override
    public StorageResponse handleException(Throwable ex) {
        return ResponseHelper.toStorageResponse(ex);
    }

    
}


