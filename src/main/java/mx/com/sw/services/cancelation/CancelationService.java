package mx.com.sw.services.cancelation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import mx.com.sw.services.Services;
import mx.com.sw.services.cancelation.requests.CancelationRequestCSD;
import mx.com.sw.services.cancelation.requests.CancelationRequestPFX;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

/**
 * CancelationService Servicio para implementación de cancelación.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public abstract class CancelationService extends Services {

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    protected CancelationService(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    protected CancelationService(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
    }

    abstract CancelationResponse cancelar(String cer, String key, String rfc, String password, String uuid);

    abstract CancelationResponse cancelar(String pfx, String rfc, String password, String uuid);

    abstract CancelationResponse cancelar(String rfc, String uuid);

    abstract CancelationResponse cancelar(String xmlCancelation);

    /**
     * Construye el json del request a partir de los datos.
     * @param pfx String base64 del pfx.
     * @param rfc rfc emisor.
     * @param password password del pfx.
     * @param uuid uuid factura.
     * @return String json
     */
    protected String requestCancelar(String pfx, String rfc, String password, String uuid) {
        CancelationRequestPFX objectRequest = new CancelationRequestPFX(uuid, password, rfc, pfx);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }

    /**
     * Construye el json del request a partir de los datos.
     * @param csd String base64 del certificado.
     * @param key String base64 de llave privada.
     * @param rfc rfc emisor.
     * @param password password de llave privada.
     * @param uuid uuid factura.
     * @return String json
     */
    protected String requestCancelar(String csd, String key, String rfc, String password, String uuid) {
        CancelationRequestCSD objectRequest = new CancelationRequestCSD(uuid, password, rfc, csd, key);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * @return Map String, String
     */
    protected Map<String, String> getHeaders() {
        this.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }
}
