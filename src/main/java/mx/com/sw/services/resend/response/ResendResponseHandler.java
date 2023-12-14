package mx.com.sw.services.resend.response;

import mx.com.sw.helpers.ResponseHelper;
import mx.com.sw.services.ResponseHandler;

/**
 * ResendResponseHandler.
 */
public class ResendResponseHandler extends ResponseHandler<ResendResponse> {
    @Override
    public ResendResponse handleException(Throwable ex) {
        return ResponseHelper.toResendResponse(ex);
    }
}
