package mx.com.sw.services.cfdi40.helpers;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.stamp.responses.StampResponseV1;
import mx.com.sw.services.stamp.responses.StampResponseV2;
import mx.com.sw.services.stamp.responses.StampResponseV3;
import mx.com.sw.services.stamp.responses.StampResponseV4;

/**
* Clase organizadora de las diferentes versiones de timbrados disponibles
* @author  Eduardo Mares
* @version 0.0.0.1
* @since   2022-04-28
*/
public class StampService extends BaseStamp {

    private boolean isToken;

    /**
    * Constructor de la clase.
    * @param isToken indica si el servicio de timbrado se autentificara con token o usuario y contraseña
    */
    public StampService(boolean isToken)
    {
        this.isToken = isToken;
    }

    /**
     * @throws ServicesException exception en caso de error.
     */    
    @Override    
    public StampResponseV1 StampResponseV1(String fileName, String stampVersion, boolean signed,
            boolean isBase64) throws ServicesException {
        switch (stampVersion)
        {
            case "V1":
                StampV1 stampV1 = new StampV1(isToken);
                return stampV1.StampResponseV1(fileName, stampVersion, signed, isBase64);
            case "V2":
                StampV2 stampV2 = new StampV2(isToken);
                return stampV2.StampResponseV1(fileName, stampVersion, signed, isBase64);
            case "V4":
                StampV4 stampV4 = new StampV4(isToken);
                return stampV4.StampResponseV1(fileName, stampVersion, signed, isBase64);
            case "IssueV1":
                IssueV1 issueV1 = new IssueV1(isToken);
                return issueV1.StampResponseV1(fileName, stampVersion, signed, isBase64);
            case "IssueV2":
                IssueV2 issueV2 = new IssueV2(isToken);
                return issueV2.StampResponseV1(fileName, stampVersion, signed, isBase64);
            case "IssueV4":
                IssueV4 issueV4 = new IssueV4(isToken);
                return issueV4.StampResponseV1(fileName, stampVersion, signed, isBase64);
            case "IssueJsonV1":
                IssueJsonV1 issueJsonV1 = new IssueJsonV1(isToken);
                return issueJsonV1.StampResponseV1(fileName, stampVersion, signed, isBase64);
            case "IssueJsonV4":
                IssueJsonV4 issueJsonV4 = new IssueJsonV4(isToken);
                return issueJsonV4.StampResponseV1(fileName, stampVersion, signed, isBase64);
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV2 StampResponseV2(String fileName, String stampVersion, boolean signed,
            boolean isBase64) throws ServicesException {
        switch (stampVersion)
        {
            case "V1":
                StampV1 stampV1 = new StampV1(isToken);
                return stampV1.StampResponseV2(fileName, stampVersion, signed, isBase64);
            case "V2":
                StampV2 stampV2 = new StampV2(isToken);
                return stampV2.StampResponseV2(fileName, stampVersion, signed, isBase64);
            case "V4":
                StampV4 stampV4 = new StampV4(isToken);
                return stampV4.StampResponseV2(fileName, stampVersion, signed, isBase64);
            case "IssueV1":
                IssueV1 issueV1 = new IssueV1(isToken);
                return issueV1.StampResponseV2(fileName, stampVersion, signed, isBase64);
            case "IssueV2":
                IssueV2 issueV2 = new IssueV2(isToken);
                return issueV2.StampResponseV2(fileName, stampVersion, signed, isBase64);
            case "IssueV4":
                IssueV4 issueV4 = new IssueV4(isToken);
                return issueV4.StampResponseV2(fileName, stampVersion, signed, isBase64);
            case "IssueJsonV1":
                IssueJsonV1 issueJsonV1 = new IssueJsonV1(isToken);
                return issueJsonV1.StampResponseV2(fileName, stampVersion, signed, isBase64);
            case "IssueJsonV4":
                IssueJsonV4 issueJsonV4 = new IssueJsonV4(isToken);
                return issueJsonV4.StampResponseV2(fileName, stampVersion, signed, isBase64);
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV3 StampResponseV3(String fileName, String stampVersion, boolean signed,
            boolean isBase64) throws ServicesException {
        switch (stampVersion)
        {
            case "V1":
                StampV1 stampV1 = new StampV1(isToken);
                return stampV1.StampResponseV3(fileName, stampVersion, signed, isBase64);
            case "V2":
                StampV2 stampV2 = new StampV2(isToken);
                return stampV2.StampResponseV3(fileName, stampVersion, signed, isBase64);
            case "V4":
                StampV4 stampV4 = new StampV4(isToken);
                return stampV4.StampResponseV3(fileName, stampVersion, signed, isBase64);
            case "IssueV1":
                IssueV1 issueV1 = new IssueV1(isToken);
                return issueV1.StampResponseV3(fileName, stampVersion, signed, isBase64);
            case "IssueV2":
                IssueV2 issueV2 = new IssueV2(isToken);
                return issueV2.StampResponseV3(fileName, stampVersion, signed, isBase64);
            case "IssueV4":
                IssueV4 issueV4 = new IssueV4(isToken);
                return issueV4.StampResponseV3(fileName, stampVersion, signed, isBase64);
            case "IssueJsonV1":
                IssueJsonV1 issueJsonV1 = new IssueJsonV1(isToken);
                return issueJsonV1.StampResponseV3(fileName, stampVersion, signed, isBase64);
            case "IssueJsonV4":
                IssueJsonV4 issueJsonV4 = new IssueJsonV4(isToken);
                return issueJsonV4.StampResponseV3(fileName, stampVersion, signed, isBase64);
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * @throws ServicesException exception en caso de error.
     */
    @Override
    public StampResponseV4 StampResponseV4(String fileName, String stampVersion, boolean signed,
            boolean isBase64) throws ServicesException {
        switch (stampVersion)
        {
            case "V1":
                StampV1 stampV1 = new StampV1(isToken);
                return stampV1.StampResponseV4(fileName, stampVersion, signed, isBase64);
            case "V2":
                StampV2 stampV2 = new StampV2(isToken);
                return stampV2.StampResponseV4(fileName, stampVersion, signed, isBase64);
            case "V4":
                StampV4 stampV4 = new StampV4(isToken);
                return stampV4.StampResponseV4(fileName, stampVersion, signed, isBase64);
            case "IssueV1":
                IssueV1 issueV1 = new IssueV1(isToken);
                return issueV1.StampResponseV4(fileName, stampVersion, signed, isBase64);
            case "IssueV2":
                IssueV2 issueV2 = new IssueV2(isToken);
                return issueV2.StampResponseV4(fileName, stampVersion, signed, isBase64);
            case "IssueV4":
                IssueV4 issueV4 = new IssueV4(isToken);
                return issueV4.StampResponseV4(fileName, stampVersion, signed, isBase64);
            case "IssueJsonV1":
                IssueJsonV1 issueJsonV1 = new IssueJsonV1(isToken);
                return issueJsonV1.StampResponseV4(fileName, stampVersion, signed, isBase64);
            case "IssueJsonV4":
                IssueJsonV4 issueJsonV4 = new IssueJsonV4(isToken);
                return issueJsonV4.StampResponseV4(fileName, stampVersion, signed, isBase64);
            default:
                throw new UnsupportedOperationException();
        }
    }    
}
