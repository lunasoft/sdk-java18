package mx.com.sw.services.account.balance.responses;

/**
 * AccountBalanceData - Clase con la informacion del saldo del cliente.
 * 
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-14
 */
public class AccountBalanceData {
    private String idSaldoCliente;
    private String idClienteUsuario;
    private Integer saldoTimbres;
    private Integer timbresUtilizados;
    private String fechaExpiracion;
    private boolean unlimited;
    private Integer timbresAsignados;

    /**
     * Obtiene el id del saldo.
     * 
     * @return String
     */
    public String getIdSaldoCliente() {
        return this.idSaldoCliente;
    }

    /**
     * Obtiene el id del cliente.
     * 
     * @return String
     */
    public String getIdClienteUsuario() {
        return this.idClienteUsuario;
    }

    /**
     * Obtiene el saldo restante.
     * 
     * @return Integer
     */
    public Integer getSaldoTimbres() {
        return this.saldoTimbres;
    }

    /**
     * Obtiene el total de timbres utilizados.
     * 
     * @return Integer
     */
    public Integer getTimbresUtilizados() {
        return this.timbresUtilizados;
    }

    /**
     * Obtiene la fecha de expiración de los timbres.
     * 
     * @return String
     */
    public String getFechaExpiracion() {
        return this.fechaExpiracion;
    }

    /**
     * Indica si el cliente está bajo el esquema de "ilimitado",
     * lo cual hace que se descuenten los timbres de la cuenta distribuidora.
     * 
     * @return boolean
     */
    public boolean isUnlimited() {
        return this.unlimited;
    }

    /**
     * Obtiene total de los timbres adquiridos.
     * 
     * @return String
     */
    public Integer getTimbresAsignados() {
        return this.timbresAsignados;
    }
}