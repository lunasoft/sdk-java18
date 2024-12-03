package mx.com.sw.services.authentication.request;

/**
 * AuthenticateRequest.
 */
public class AuthenticateRequest {
    private String user;
    private String password;
    /**
     * Constructor de la clase.
     * 
     * @param usuario    String usuario.
     * @param contraseña String contraseña.
     */
    public AuthenticateRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /**
     * Obtiene el usuario.
     * 
     * @return string
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Obtiene la contraseña.
     * 
     * @return string
     */
    public String getPassword() {
        return this.password;
    }
}
