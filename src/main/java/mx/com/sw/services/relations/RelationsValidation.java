package mx.com.sw.services.relations;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.helpers.GeneralValidations;
import org.apache.commons.codec.binary.Base64;

/**
 * RelationsValidation Clase para validaciones en el
 * servicio de Relations.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-24
 */
public class RelationsValidation extends GeneralValidations {

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param user usuario de SW.
     * @param password password de SW.
     * @param token token de SW.
     * @throws ServicesException exception en caso de error.
     */
    public RelationsValidation(String url, String user, String password, String token) throws ServicesException {
        super(url, user, password, token);
    }

    /**
     * Validación para cancelacion mediante RFC y UUID.
     * @param rfc rfc emisor.
     * @param uuid uuid factura.
     * @throws ServicesException exception en caso de error.
     */
    public void validateRequestUUID(String rfc, String uuid) throws ServicesException {
        validateString(uuid, "Faltan especificar el UUID relacionados", false, null);
        validateString(rfc, "Falta Capturar el RFC emisor", false, null);
    }

    /**
     * Validación para Relations mediante CSD.
     * @param csd String base64 del certificado.
     * @param key String base64 de llave privada.
     * @param password password de llave privada.
     * @param uuid uuid factura.
     * @throws ServicesException exception en caso de error.
     */
    public void validateRequestCSD(String csd, String key, String password, String uuid) throws ServicesException {
        validateString(uuid, "Faltan especificar el UUID relacionados", false, null);
        validateString(csd, "Falta Capturar el Certificado", true, "Certificado");
        validateString(key, "Falta Capturar Key del Certificado", true, "Key");
        validateString(password, "Falta Capturar Contraseña del Certificado", false, null);
    }

    /**
     * Validación para Relations mediante PFX.
     * @param pfx String base64 del pfx.
     * @param password password del pfx.
     * @param uuid uuid factura.
     * @throws ServicesException exception en caso de error.
     */
    public void validateRequestPFX(String pfx, String password, String uuid) throws ServicesException {
        validateString(uuid, "Faltan especificar el UUID relacionados", false, null);
        validateString(pfx, "Falta Capturar el Certificado PFX", true, "PFX");
        validateString(password, "Falta Capturar Contraseña del Certificado", false, null);
    }

    /**
     * Validación para Relations mediante XML.
     * @param xml String xml.
     * @throws ServicesException exception en caso de error.
     */
    public void validateRequestXML(String xml) throws ServicesException {
        validateString(xml, "Faltan especificar el XML de relacionados", false, null);
    }

    /**
     * Validación String Base64.
     * @param key llave.
     * @param value valor.
     * @throws ServicesException exception en caso de error.
     */
    private void validateIsBase64(String key, String value) throws ServicesException {
        if (!Base64.isBase64(value)) {
            throw new ServicesException("El valor " + key + " no es Base64");
        }
    }

    /**
     * Validación para un String.
     * @param value valor.
     * @param errorDescription mensaje de error.
     * @param b64 es base64?
     * @param parameterName nombre paramétro.
     * @throws ServicesException exception en caso de error.
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
