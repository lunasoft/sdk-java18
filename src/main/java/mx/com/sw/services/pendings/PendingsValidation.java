package mx.com.sw.services.pendings;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.GeneralHelpers;
import mx.com.sw.helpers.GeneralValidations;

/**
 * PendingsValidation Clase para validaciones en el
 * servicio de AcceptReject.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-27
 */
public class PendingsValidation extends GeneralValidations {

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param user usuario de SW.
     * @param password password de SW.
     * @param token token de SW.
     * @throws ServicesException exception en caso de error.
     */
    public PendingsValidation(String url, String user, String password, String token) throws ServicesException {
        super(url, user, password, token);
    }

    /**
     * Validación para pendings mediante RFC.
     * @param rfc rfc emisor.
     * @throws ServicesException exception en caso de error.
     */
    public void validateRequestUUID(String rfc) throws ServicesException {
        validateString(rfc, "Falta Capturar el RFC a consultar de pendientes");
    }

    /**
     * Validación para un String.
     * @param value valor.
     * @param errorDescription mensaje de error.
     * @throws ServicesException exception en caso de error.
     */
    private void validateString(String value, String errorDescription)
            throws ServicesException {
        if (GeneralHelpers.stringEmptyOrNull(value)) {
            throw new ServicesException(errorDescription);
        }
    }
}
