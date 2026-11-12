package mx.com.sw.services.account.info.responses;

/**
 * AccountListMeta - Datos de paginación de la consulta de usuarios.
 */
public class AccountListMeta {
    private int page;
    private int perPage;
    private int pageCount;
    private int totalCount;
    private int totalPages;

    /**
     * Página actual.
     * @return int
     */
    public int getPage() {
        return page;
    }

    /**
     * Registros solicitados por página.
     * @return int
     */
    public int getPerPage() {
        return perPage;
    }

    /**
     * Registros devueltos en la página actual.
     * @return int
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Total de registros que cumplen el filtro.
     * @return int
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Total de páginas.
     * @return int
     */
    public int getTotalPages() {
        return totalPages;
    }
}
