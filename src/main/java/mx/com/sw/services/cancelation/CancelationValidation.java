package mx.com.sw.services.cancelation;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.helpers.GeneralValidations;
import org.apache.commons.codec.binary.Base64;

/**
 * <h1>CancelationValidation</h1> Clase para validaciones en el
 * servicio de cancelacion.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class CancelationValidation extends GeneralValidations {

    /**
     * Constructor de clase.
     * @param url
     * @param user
     * @param password
     * @param token
     * @throws ServicesException
     */
    public CancelationValidation(String url, String user, String password, String token) throws ServicesException {
        super(url, user, password, token);
    }

    /**
     * Validación para cancelacion mediante CSD.
     * @param csd
     * @param key
     * @param password
     * @param uuid
     * @throws ServicesException
     */
    public void validateRequestCSD(String csd, String key, String password, String uuid) throws ServicesException {
        validateString(uuid, "Faltan especificar el UUID a Cancelar", false, null);
        validateString(csd, "Falta Capturar el Certificado", true, "Certificado");
        validateString(key, "Falta Capturar Key del Certificado", true, "Key");
        validateString(password, "Falta Capturar Contraseña del Certificado", false, null);
    }

    /**
     * Validación para cancelacion mediante PFX.
     * @param pfx
     * @param password
     * @param uuid
     * @throws ServicesException
     */
    public void validateRequestPFX(String pfx, String password, String uuid) throws ServicesException {
        validateString(uuid, "Faltan especificar el UUID a Cancelar", false, null);
        validateString(pfx, "Falta Capturar el Certificado PFX", true, "PFX");
        validateString(password, "Falta Capturar Contraseña del Certificado", false, null);
    }

    /**
     * Validación para cancelacion mediante RFC y UUID.
     * @param rfc
     * @param uuid
     * @throws ServicesException
     */
    public void validateRequestUUID(String rfc, String uuid) throws ServicesException {
        validateString(uuid, "Faltan especificar el UUID a Cancelar", false, null);
        validateString(rfc, "Falta Capturar el RFC emisor", false, null);
    }

    /**
     * Validación para cancelacion mediante XML.
     * @param xml
     * @throws ServicesException
     */
    public void validateRequestXML(String xml) throws ServicesException {
        validateString(xml, "Faltan especificar el XML de cancelacion", false, null);
    }

    /**
     * Validación String Base64.
     * @param key
     * @param value
     * @throws ServicesException
     */
    private void validateIsBase64(String key, String value) throws ServicesException {
        if (!Base64.isBase64(value)) {
            throw new ServicesException("El valor " + key + " no es Base64");
        }
    }

    /**
     * Validación para un String.
     * @param value
     * @param errorDescription
     * @param b64
     * @param parameterName
     * @throws ServicesException
     */
    private void validateString(String value, String errorDescription, boolean b64, String parameterName)
            throws ServicesException {
        if (GeneralHelpers.stringEmptyOrNull(value)) {
            throw new ServicesException(errorDescription);
        }
        if (b64) {
            validateIsBase64(parameterName, value);
        }
    }
}
