package mx.com.sw.services.account.info.responses;



/**
 * AccountInfoData - Clase con la informacion de la cuenta del cliente.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-17
 */
public class AccountInfoData {
    private int stamps;
    private boolean unlimited;
    private String profileValue;
    private String idUsuario;
    private String idCliente;
    private String nombre;
    private String rfc;
    private String username;
    private String fechaUltimoPassword;
    private String email;
    private String telefono;
    private boolean activo;
    private String registeredDate;
    private boolean eliminado;
    private String tokenAccess;
    private String data;  
    private String status;

    /**
     * Obtiene el Saldo de timbres.
     * @return Integer
     */
    public int getStamps() {
        return this.stamps;
    }

    /**
     * Indica si la cuenta está bajo el esquema "ilimitado".
     * @return boolean
     */
    public boolean isUnlimited() {
        return this.unlimited;
    }

    /**
     * Obtiene el profile de la cuenta.
     * @return String
     */
    public String getProfileValue() {
        return this.profileValue;
    }

    /**
     * Obtiene idUsuario.
     * @return String
     */
    public String getIdUsuario() {
        return this.idUsuario;
    }

    /**
     * Obtiene idCliente o también conocido como idDealer.
     * @return String
     */
    public String getIdCliente() {
        return this.idCliente;
    }

    /**
     * Obtiene el nombre de la cuenta.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el rfc registrado en la cuenta.
     * @return String
     */
    public String getRfc() {
        return this.rfc;
    }

    /**
     * Obtiene el username.
     * @return String
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Obtiene la fecha del último password.
     * @return String
     */
    public String getFechaUltimoPassword() {
        return this.fechaUltimoPassword;
    }

    /**
     * Obtiene el email.
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Obtiene telefono registrado en la cuenta.
     * @return String
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Indica si la cuenta está activada o no.
     * @return boolean
     */
    public boolean isActivo() {
        return this.activo;
    }

    /**
     * Obtiene la fecha en la cual se registro la cuenta.
     * @return String
     */
    public String getRegisteredDate() {
        return this.registeredDate;
    }

    /**
     * Indica si la cuenta está eliminada o no.
     * @return boolean
     */
    public boolean isEliminado() {
        return this.eliminado;
    }

    /**
     * Obtiene el token infinito de la cuenta.
     * @return String
     */
    public String getTokenAccess() {
        return this.tokenAccess;
    }

    /**
     * Obtiene los datos de la cuenta.
     * @return String
     */
    public String getData() {
        return this.data;
    }

    /**
     * Obtiene el estado de la respuesta.
     * @return String
     */
    public String getStatus() {
        return this.status;
    }
    
}
