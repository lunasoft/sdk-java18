package mx.com.sw.services.cfdi40.helpers;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

/**
* Constructor del servicio de Timbrado versión 4 con CFDI sin sellar en formato Json
 * Es necesario contar con certificados vigentes configurados en su cuenta
 * de SW, de esta manera se realiza el sellado del documento generado.
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-28
*/
public class IssueJsonV4 extends BaseStamp{

    private final mx.com.sw.services.issue.IssueJsonV4 issue;

    /**
    * Constructor de la clase.
    * @param isToken indica si el servicio de timbrado se autentificara con token o usuario y contraseña
    * @throws ServicesException exception en caso de error.
    */
    public IssueJsonV4(Boolean isToken) throws ServicesException
    {        
        if(!isToken)
            issue = new mx.com.sw.services.issue.IssueJsonV4(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
        else
            issue = new mx.com.sw.services.issue.IssueJsonV4(settings.getUrlSW(), settings.getTokenSW(),  null, 0);     
    }
    
    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV1 StampResponseV1(String fileName, String stampVersion, boolean signed,
            boolean isBase64) throws ServicesException {
                return issue.timbrarV1(settings.getJsonCFDI(fileName, isBase64), settings.getEmail());
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV2 StampResponseV2(String fileName, String stampVersion, boolean signed,
            boolean isBase64) throws ServicesException {
                return issue.timbrarV2(settings.getJsonCFDI(fileName, isBase64), settings.getEmail());
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV3 StampResponseV3(String fileName, String stampVersion, boolean signed,
            boolean isBase64) throws ServicesException {
                return issue.timbrarV3(settings.getJsonCFDI(fileName, isBase64), settings.getEmail());
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV4 StampResponseV4(String fileName, String stampVersion, boolean signed,
            boolean isBase64) throws ServicesException {
                return issue.timbrarV4(settings.getJsonCFDI(fileName, isBase64), settings.getEmail());
    }    
}
