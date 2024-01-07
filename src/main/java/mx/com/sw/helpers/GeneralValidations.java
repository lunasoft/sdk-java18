package mx.com.sw.helpers;

import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mx.com.sw.exceptions.GeneralException;
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

    /**
     * Este método valida el CustomId proporcionado.
     * @param customId
     * @throws ServicesException
     */
    protected void validateCustomId(String customId) throws ServicesException{
        if (customId.length() <= 0 || customId.length() > 150) {
            throw new ServicesException("El CustomId no es válido o viene vacío.");
        } 
    }

    /**
     * Este método valida el o los emails proporcionados.
     * @param emails
     * @throws ServicesException
     */
    protected boolean validateEmails(String emails) throws ServicesException {
        List<String> emailList = Arrays.asList(emails.split("\\s*,\\s*"));
        if (emailList.size() > 0 && emailList.size() <= 5) {
            for (int i = 0; i <= emailList.size() - 1; i++) {
                Pattern pattern = Pattern
                        .compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
                Matcher matcher = pattern.matcher(emailList.get(i));
                if (!matcher.matches()) {
                    throw new ServicesException(
                        "El listado de correos no contiene un formato válido o alguno de los correos es inválido."
                        );
                }
            }
        } else {
            throw new ServicesException("El listado de correos está vacío o contiene más de 5 correos.");
        }
        return true;
    }
}
