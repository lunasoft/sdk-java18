package mx.com.sw.services.cfdi40.helpers;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

/**
* Constructor del servicio de Timbrado versión 1 con CFDI sin sellar en formato Json
 * Es necesario contar con certificados vigentes configurados en su cuenta
 * de SW, de esta manera se realiza el sellado del documento generado.
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-28
*/
public class IssueJsonV1 extends BaseStamp {

    private final mx.com.sw.services.issue.IssueJson issue;

    /**
    * Constructor de la clase.
    * @param isToken indica si el servicio de timbrado se autentificara con token o usuario y contraseña
    * @throws ServicesException exception en caso de error.
    */
    public IssueJsonV1(Boolean isToken) throws ServicesException {
        if (!isToken) {
            issue = new mx.com.sw.services.issue.IssueJson(getSettings().getUrlSW(), getSettings().getUserSW(),
            getSettings().getPasswordSW(), null, 0);
        } else {
            issue = new mx.com.sw.services.issue.IssueJson(getSettings().getUrlSW(), getSettings().getTokenSW(),
                null, 0);
        }
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV1 stampResponseV1(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException {
        return issue.timbrarV1(getSettings().getJsonCFDI(fileName, isBase64));
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV2 stampResponseV2(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException {
        return issue.timbrarV2(getSettings().getJsonCFDI(fileName, isBase64));
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV3 stampResponseV3(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException {
        return issue.timbrarV3(getSettings().getJsonCFDI(fileName, isBase64));
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV4 stampResponseV4(String fileName, String stampVersion, boolean signed,
        boolean isBase64) throws ServicesException {
        return issue.timbrarV4(getSettings().getJsonCFDI(fileName, isBase64));
    }
}
