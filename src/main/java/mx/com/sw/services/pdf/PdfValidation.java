package mx.com.sw.services.pdf;
import org.apache.commons.codec.binary.Base64;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.helpers.GeneralValidations;

/**
 * PdfValidation Clase para validacion antes del request.
 * 
 * @author Manuel Castillo  
 * @version 0.0.0.1
 * @since 2020-12-15
 */
public class PdfValidation extends GeneralValidations {

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param user usuario de SW.
     * @param password password de SW.
     * @param token token de SW.
     * @throws ServicesException exception en caso de error.
     */
    public PdfValidation(String url, String user, String password, String token) throws ServicesException {
        super(url, user, password, token);
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
     * @param b64 es base64
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


    /**
     * Validación para generar pdf.
     * @param templateid templateid para generar PDF.
     * @param xmlcontent cfdi para extraccion de datos para formar PDF.
     * @throws ServicesException exception en caso de error.
     */
    public void validateRequestPdf(String templateid, String xmlcontent, String logo) throws ServicesException {
        validateString(templateid, "Falta especificar el templateid", false, null);
        validateString(xmlcontent, "Falta especificar el xml a procesar", false, null);
        if(logo != null)
        validateString(logo, "--", true, "logo");
    }
}
