package mx.com.sw.helpers;

import java.io.PrintWriter;
import java.io.StringWriter;

import mx.com.sw.services.authentication.AuthenticationResponse;
import mx.com.sw.services.cancelation.CancelationResponse;

public class ResponseHelper {
    public static CancelationResponse toCancellationResponse(Throwable ex){
        return new CancelationResponse(){
            {
                message = ex.getMessage();
                messageDetail = getStackError(ex);
                status = "error";
            }
        };
    }
    public static AuthenticationResponse toAuthenticationResponse(Throwable ex){
        return new AuthenticationResponse(){
            {
                message = ex.getMessage();
                messageDetail = getStackError(ex);
                status = "error";
            }
        };
    }

    private static String getStackError(Throwable ex){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        return stringWriter.toString(); 
    }
}