package mx.com.sw.services.storage;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * StorageResponseHandler.
 */
public class StorageResponseHandler extends ResponseHandler<StorageResponse> {

    /**
     * StorageResponse handleException.
     * @param ex
     * @return
    */
    @Override
    public StorageResponse handleException(Throwable ex) {
        return ResponseHelper.toStorageResponse(ex);
    }
}
