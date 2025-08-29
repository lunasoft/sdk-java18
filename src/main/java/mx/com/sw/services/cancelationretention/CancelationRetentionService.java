package mx.com.sw.services.cancelationretention;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;
import mx.com.sw.services.cancelation.requests.CancelationRequestCSD;
import mx.com.sw.services.cancelation.requests.CancelationRequestPFX;
import mx.com.sw.services.cancelation.responses.CancelationResponse;

/**
 * Servicio para implementación de cancelación de retenciones.
 */
public abstract class CancelationRetentionService extends Services {

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected CancelationRetentionService(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected CancelationRetentionService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Métodos abstractos para cancelar retención mediante XML, CSD y PFX.
     * @return CancelationRetResponse
     */
    abstract CancelationResponse cancelar(String xmlCancelation);

    abstract CancelationResponse cancelar(String cer, String key, String rfc, String password, String uuid,
        String motivo, String folioSustitucion);

    abstract CancelationResponse cancelar(String pfx, String rfc, String password, String uuid, String motivo,
        String folioSustitucion);

        /**
     * Construye el json del request a partir de los datos.
     * @param pfx String base64 del pfx.
     * @param rfc rfc emisor.
     * @param password password del pfx.
     * @param uuid uuid factura.
     * @param motivo motivo de cancelacion.
     * @param folioSustitucion uuid factura que sustituye.
     * @return String json
     */
    protected String requestCancelar(String pfx, String rfc, String password, String uuid, String motivo,
        String folioSustitucion) {
        CancelationRequestPFX objectRequest = new CancelationRequestPFX(uuid, password, rfc, pfx, motivo,
            folioSustitucion);
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
     * @param motivo motivo de cancelacion.
     * @param folioSustitucion uuid factura que sustituye.
     * @return String json
     */
    protected String requestCancelar(String csd, String key, String rfc, String password, String uuid,
        String motivo, String folioSustitucion) {
        CancelationRequestCSD objectRequest = new CancelationRequestCSD(uuid, password, rfc, csd, key, motivo,
            folioSustitucion);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * @return Map String, String
     * @throws ServicesException exception en caso de error.
     */
    protected Map<String, String> getHeaders() throws ServicesException {
        this.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }
} 