package mx.com.sw.helpers;

import java.io.PrintWriter;
import java.io.StringWriter;
import mx.com.sw.services.account.balance.responses.AccountBalanceResponse;
import mx.com.sw.services.authentication.responses.AuthenticationResponse;
import mx.com.sw.services.cancelation.responses.CancelationResponse;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

/**
* ResponseHelper
* Está clase funciona como un handler de exceptions donde se toma un exception
* y se construye una respuesta de acuerdo al servicio con detalles del error.
*
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public final class ResponseHelper {
    private static final String STATUS_ERROR = "error";

    /**
    * Constructor de la clase.
    */
    private ResponseHelper() {

    }

    /**
    * Este método obtiene una respuesta de tipo CancelationResponse.
    * @param ex Throwable a ser tratado
    * @return CancelationResponse.
    */
    public static CancelationResponse toCancellationResponse(Throwable ex) {
        return new CancelationResponse(STATUS_ERROR, ex.getMessage(), getStackError(ex), null);
    }

    /**
    * Este método obtiene una respuesta de tipo AuthenticationResponse.
    * @param ex Throwable a ser tratado
    * @return AuthenticationResponse.
    */
    public static AuthenticationResponse toAuthenticationResponse(Throwable ex) {
        return new AuthenticationResponse(STATUS_ERROR, ex.getMessage(), getStackError(ex), null);
    }

    /**
    * Este método obtiene una respuesta de tipo StampResponseV1.
    * @param ex Throwable a ser tratado
    * @return StampResponseV1.
    */
    public static StampResponseV1 toStampResponseV1(Throwable ex) {
        return new StampResponseV1(STATUS_ERROR, ex.getMessage(), getStackError(ex), null);
    }

    /**
    * Este método obtiene una respuesta de tipo StampResponseV2.
    * @param ex Throwable a ser tratado
    * @return StampResponseV2.
    */
    public static StampResponseV2 toStampResponseV2(Throwable ex) {
        return new StampResponseV2(STATUS_ERROR, ex.getMessage(), getStackError(ex), null);
    }

    /**
    * Este método obtiene una respuesta de tipo StampResponseV3.
    * @param ex Throwable a ser tratado
    * @return StampResponseV3.
    */
    public static StampResponseV3 toStampResponseV3(Throwable ex) {
        return new StampResponseV3(STATUS_ERROR, ex.getMessage(), getStackError(ex), null);
    }

    /**
    * Este método obtiene una respuesta de tipo StampResponseV4.
    * @param ex Throwable a ser tratado
    * @return StampResponseV4.
    */
    public static StampResponseV4 toStampResponseV4(Throwable ex) {
        return new StampResponseV4(STATUS_ERROR, ex.getMessage(), getStackError(ex), null);
    }

    /**
    * Este método obtiene una respuesta de tipo AccountBalanceResponse.
    * @param ex Throwable a ser tratado
    * @return AccountBalanceResponse.
    */
    public static AccountBalanceResponse toAccountBalanceResponse(Throwable ex) {
        return new AccountBalanceResponse(STATUS_ERROR, ex.getMessage(), getStackError(ex), null);
    }

    /**
    * Este método obtiene el stacktrace de una exception.
    * @param ex Throwable del cual se obtiene el stacktrace
    * @return String.
    */
    public static String getStackError(Throwable ex) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}
