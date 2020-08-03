package mx.com.sw.entities;

/**
 * <h1>IResponse</h1> Está clase sirve de base para las respuestas que se
 * utilizan a través de la librería.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public abstract class IResponse {
    private String status;
    private String message;
    private String messageDetail;

    /**
     * Constructor parametrizado.
     * @param status
     * @param message
     * @param messageDetail
     */
    public IResponse(String status, String message, String messageDetail) {
        this.status = status;
        this.message = message;
        this.messageDetail = messageDetail;
    }

    /**
     * Obtiene el status de la solicitud.
     * Solo puede ser "success" o "error".
     * En caso de "success" puede consultar el campo "data".
     * En caso de "error", consultar "getMessage" y "getMessageDetail".
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Obtiene el mensaje de error obtenido.
     * <b>Nota:</b> Este valor generalmente solo existe cunado la solicitud
     * termino con status "error".
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Obtiene los detalles acerca del mensaje de error.
     * Útil cuando el mensaje de error no es muy claro.
     * <b>Nota:</b> Este valor generalmente solo existe cunado la solicitud
     * termino con status "error".
     * <b>Nota:</b> Puede ser null.
     */
    public String getMessageDetail() {
        return this.messageDetail;
    }
}
