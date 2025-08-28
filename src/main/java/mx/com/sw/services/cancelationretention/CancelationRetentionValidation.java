package mx.com.sw.services.cancelationretention;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralValidations;

/**
 * Clase para validaciones en el
 * servicio de cancelación de retenciones.
 */
public class CancelationRetentionValidation extends GeneralValidations {

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param user usuario de SW.
     * @param password password de SW.
     * @param token token de SW.
     * @throws ServicesException exception en caso de error.
     */
    public CancelationRetentionValidation(String url, String user, String password, String token) throws ServicesException {
        super(url, user, password, token);
    }

    /**
     * Validación para cancelacion de retención mediante XML.
     * @param xml String xml de cancelación.
     * @throws ServicesException exception en caso de error.
     */
    public void validateRequestXML(String xml) throws ServicesException {
        validateString(xml, "Faltan especificar el XML de cancelacion de retención", false, null);
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
        if (value == null || value.trim().isEmpty()) {
            throw new ServicesException(errorDescription);
        }
    }

    /**
     * Validación para cancelacion mediante CSD.
     * @param csd String base64 del certificado.
     * @param key String base64 de llave privada.
     * @param password password de llave privada.
     * @param uuid uuid factura.
     * @throws ServicesException exception en caso de error.
     */
    public void validateRequestCSD(String csd, String key, String password, String uuid) throws ServicesException {
        validateString(uuid, "Faltan especificar el UUID a Cancelar", false, null);
        validateString(csd, "Falta Capturar el Certificado", true, "Certificado");
        validateString(key, "Falta Capturar Key del Certificado", true, "Key");
        validateString(password, "Falta Capturar Contraseña del Certificado", false, null);
    }

    /**
     * Validación para cancelacion mediante PFX.
     * @param pfx String base64 del pfx.
     * @param password password del pfx.
     * @param uuid uuid factura.
     * @throws ServicesException exception en caso de error.
     */
    public void validateRequestPFX(String pfx, String password, String uuid) throws ServicesException {
        validateString(uuid, "Faltan especificar el UUID a Cancelar", false, null);
        validateString(pfx, "Falta Capturar el Certificado PFX", true, "PFX");
        validateString(password, "Falta Capturar Contraseña del Certificado", false, null);
    }
} 