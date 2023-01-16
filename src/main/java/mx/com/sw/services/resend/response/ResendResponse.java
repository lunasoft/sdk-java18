package mx.com.sw.services.resend.response;

import mx.com.sw.entities.IResponse;

public class ResendResponse extends IResponse {

    private String data;

    /**
     * Constructor de la clase.
     *
     * @param status        status de llamada a API.
     * @param message       mensaje devuelto por API.
     * @param messageDetail detalles mensaje de la API.
     * @param data          objeto con los datos de respuesta.
     */
    public ResendResponse(String status, String message, String messageDetail, String data) {
        super(status, message, messageDetail);
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String value) {
        this.data = value;
    }


}
