package mx.com.sw.entities;

/**
 * <h1>IResponse</h1> Está clase sirve de base para las respuestas que se
 * utilizan a través de la librería.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public abstract class IResponse {
    /**
     * Status de la solicitud.
     * Solo puede ser "success" o "error".
     * En caso de "success" puede consultar el campo "data".
     * En caso de "error", consultar "message" y "messageDetail".
     */
    public String status;
    /**
     * Mensaje de error obtenido.
     */
    public String message;
    /**
     * Detalles acerca del mensaje de error.
     * Útil cuando el mensaje de error no es muy claro.
     */
    public String messageDetail;

    /**
     * Constructor por defecto
     */
    public IResponse() {

    }

    /**
     * Constructor parametrizado
     * @param status
     * @param message
     * @param messageDetail
     */
    public IResponse(String status, String message, String messageDetail) {
        this.status = status;
        this.message = message;
        this.messageDetail = messageDetail;
    }
}
