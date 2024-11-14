package mx.com.sw.services.cfdi40.helpers;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

/**
* Constructor del servicio de Timbrado versión 4.
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-28
*/
public class StampV4 extends BaseStamp {

    private final mx.com.sw.services.stamp.StampV4 stamp;

    /**
    * Constructor de la clase.
    * @param isToken indica si el servicio de timbrado se autentificara con token o usuario y contraseña
    * @throws ServicesException exception en caso de error.
    */
    public StampV4(Boolean isToken) throws ServicesException {
        if (!isToken) {
            stamp = new mx.com.sw.services.stamp.StampV4(getSettings().getUrlSW(), getSettings().getUserSW(),
                getSettings().getPasswordSW(), null, 0);
        } else {
            stamp = new mx.com.sw.services.stamp.StampV4(getSettings().getUrlSW(), getSettings().getTokenSW(), null, 0);
        }
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV1 stampResponseV1(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException {
        return stamp.timbrarV1(getSettings().getCFDI(fileName, true, "4.0", isBase64),
        getSettings().getCorreo(), null, false, isBase64);
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV2 stampResponseV2(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException {
        return stamp.timbrarV2(getSettings().getCFDI(fileName, true, "4.0", isBase64),
        getSettings().getCorreo(), null, false, isBase64);
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV3 stampResponseV3(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException {
        return stamp.timbrarV3(getSettings().getCFDI(fileName, true, "4.0", isBase64),
        getSettings().getCorreo(), null, false, isBase64);
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV4 stampResponseV4(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException {
        return stamp.timbrarV4(getSettings().getCFDI(fileName, true, "4.0", isBase64),
        getSettings().getCorreo(), null, false, isBase64);
    }
}
