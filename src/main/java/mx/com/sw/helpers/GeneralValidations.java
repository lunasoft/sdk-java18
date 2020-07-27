package mx.com.sw.helpers;

import mx.com.sw.exceptions.ServicesException;

public class GeneralValidations {
    private String url;
    private String user;
    private String password;
    private String token;
    public GeneralValidations(String url, String user, String password, String token) throws ServicesException
    {
        this.url = url;
        this.user = user;
        this.password = password;
        this.token = token;
        ValidateHeaderParameters();
    }
    public void ValidateHeaderParameters() throws ServicesException
    {
        if (GeneralHelpers.stringEmptyOrNull(url) || url.equalsIgnoreCase("/"))
            throw new ServicesException("Falta Capturar URL");

        if (GeneralHelpers.stringEmptyOrNull(token))
        {
            if (GeneralHelpers.stringEmptyOrNull(user) && GeneralHelpers.stringEmptyOrNull(password))
            {
                throw new ServicesException("Falta Capturar Token");
            }
            if (GeneralHelpers.stringEmptyOrNull(user))
            {
                throw new ServicesException("Falta Capturar Usuario");
            }
            if (GeneralHelpers.stringEmptyOrNull(password))
            {
                throw new ServicesException("Falta Capturar Contraseña");
            }
        }
        else
        {
            ValidateToken(token);
        }
    }
    private void ValidateToken(String token) throws ServicesException
    {
        String[] validToken = token.split(".");
        if (validToken.length != 3)
        {
            throw new ServicesException("Token Mal Formado");
        }
    }
}