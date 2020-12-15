package mx.com.sw.services.pdf.responses;

import mx.com.sw.entities.IResponse;

/**
 * PdfResponse Clase con la informacion PDF retornado.
 * @author Manuel Castillo  
 * @version 0.0.0.1
 * @since 2020-12-14
 */
public class PdfResponse extends IResponse{

    private PdfData data;

    /**
     * Constructor de la clase.
     * @param status status de llamada a API.
     * @param message mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data objeto con los datos de respuesta.
     */
    public PdfResponse(String status, String message, String messageDetail, PdfData data) {
        super(status, message, messageDetail);
        this.data = data;
    }
    
    /**
     * Obtiene los datos del documento impreso cuando está fue "success".
     * @return PdfData
     */
    public PdfData getData() {
        return this.data;
    }
}
