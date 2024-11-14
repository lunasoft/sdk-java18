package mx.com.sw.services.csd;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;

/**
 * CsdValidation Clase para validacion antes del request.
 */
public class CsdValidation {

    /**
     * Validación de que parametro no venga vacio.
     * @param value valor.
     * @param errorDescription mensaje de error.
     * @throws ServicesException exception en caso de error.
     */
    private void validateNull(String value, String errorDescription)
            throws ServicesException {
        if (GeneralHelpers.stringEmptyOrNull(value)) {
            throw new ServicesException(errorDescription);
        }
    }

    /**
     * Validación para verificar que parametros enviados en el Request.
     * @param b64Cer String Certificado en base 64
     * @param b64Key string Llave privada en base 64
     * @param password String Contraseña del certificado
     * @throws ServicesException exception en caso de error.
    */
    public void validateRequestCsd(String b64Cer, String b64Key, String password) throws ServicesException {
        validateNull(b64Cer, "El certificado viene vacio");
        validateNull(b64Key, "La llave privada viene vacia");
        validateNull(password, "El password viene vacio");
    }
}
