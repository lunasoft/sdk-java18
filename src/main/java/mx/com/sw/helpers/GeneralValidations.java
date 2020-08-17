package mx.com.sw.helpers;

import mx.com.sw.exceptions.ServicesException;

/**
 * GeneralValidations Está clase permite realizar validaciones de la
 * configuracion con la cual se instancio una clase.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class GeneralValidations {
    private static final int TOKEN_PARTS = 3;
    private String url;
    private String user;
    private String password;
    private String token;

    /**
     * Constructor de la clase.
     * @param url      url base de la API
     * @param user     correo o usuario de SW
     * @param password password de SW.
     * @param token    token de SW.
     * @throws ServicesException Exception en caso de paramétros incorrectos.
     */
    public GeneralValidations(String url, String user, String password, String token) throws ServicesException {
        this.url = url;
        this.user = user;
        this.password = password;
        this.token = token;
        validateHeaderParameters();
    }

    /**
     * Este método valida los parámetros enviados.
     * @throws ServicesException Exception en caso de paramétros incorrectos.
     */
    public void validateHeaderParameters() throws ServicesException {
        if (GeneralHelpers.stringEmptyOrNull(url) || "/".equalsIgnoreCase(url)) {
            throw new ServicesException("Falta Capturar URL");
        }
        if (GeneralHelpers.stringEmptyOrNull(token)) {
            if (GeneralHelpers.stringEmptyOrNull(user) && GeneralHelpers.stringEmptyOrNull(password)) {
                throw new ServicesException("Falta Capturar Token");
            }
            if (GeneralHelpers.stringEmptyOrNull(user)) {
                throw new ServicesException("Falta Capturar Usuario");
            }
            if (GeneralHelpers.stringEmptyOrNull(password)) {
                throw new ServicesException("Falta Capturar Contraseña");
            }
        } else {
            validateToken(token);
        }
    }

    /**
     * Este método valida el token proporcionado.
     * @param tokenValidate
     * @throws ServicesException
     */
    private void validateToken(String tokenValidate) throws ServicesException {
        String[] validToken = tokenValidate.split("\\.");
        if (validToken.length != TOKEN_PARTS) {
            throw new ServicesException("Token Mal Formado");
        }
    }
}
