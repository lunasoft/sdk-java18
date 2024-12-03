package mx.com.sw.helpers;

/**
 * Representa filtros utilizados para cuentas con claves asociadas a consultas.
 */
public enum EnumAccountFilters {

    /**
     * Filtro por correo electrónico.
     */
    EMAIL("Email"),

    /**
     * Filtro por identificación fiscal.
     */
    TAX_ID("TaxId"),

    /**
     * Filtro por ID de usuario.
     */
    ID_USER("IdUser"),

    /**
     * Filtro por estado activo/inactivo.
     */
    IS_ACTIVE("IsActive");

    // Campo privado que almacena la clave de consulta asociada al filtro
    private final String queryKey;

    /**
     * Constructor para asociar la clave de consulta al filtro.
     * 
     * @param queryKey La clave utilizada para la consulta asociada.
     */
    EnumAccountFilters(String queryKey) {
        this.queryKey = queryKey;
    }

    /**
     * Devuelve la clave de consulta asociada al filtro.
     * 
     * @return La clave de consulta.
     */
    public String getQueryKey() {
        return queryKey;
    }
}
