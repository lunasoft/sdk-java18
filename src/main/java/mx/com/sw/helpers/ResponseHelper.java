package mx.com.sw.helpers;

import java.io.PrintWriter;
import java.io.StringWriter;

import mx.com.sw.services.authentication.responses.AuthenticationResponse;
import mx.com.sw.services.cancelation.responses.CancelationResponse;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

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

    public static StampResponseV1 toStampResponseV1(Throwable ex){
        return new StampResponseV1(){
            {
                message = ex.getMessage();
                messageDetail = getStackError(ex);
                status = "error";
            }
        };
    }

    public static StampResponseV2 toStampResponseV2(Throwable ex){
        return new StampResponseV2(){
            {
                message = ex.getMessage();
                messageDetail = getStackError(ex);
                status = "error";
            }
        };
    }

    public static StampResponseV3 toStampResponseV3(Throwable ex){
        return new StampResponseV3(){
            {
                message = ex.getMessage();
                messageDetail = getStackError(ex);
                status = "error";
            }
        };
    }

    public static StampResponseV4 toStampResponseV4(Throwable ex){
        return new StampResponseV4(){
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