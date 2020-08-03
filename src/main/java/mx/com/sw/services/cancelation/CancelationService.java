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
 * <h1>CancelationService</h1> Servicio para implementación de cancelación.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public abstract class CancelationService extends Services {

    /**
     * Constructor de la clase.
     * @param url
     * @param user
     * @param password
     * @param proxy
     * @param proxyPort
     */
    protected CancelationService(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * @param url
     * @param token
     * @param proxy
     * @param proxyPort
     */
    protected CancelationService(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Método de cancelación enviando datos de CSD.
     * @param cer
     * @param key
     * @param rfc
     * @param password
     * @param uuid
     * @return CancelationResponse
     * @see CancelationResponse
     */
    abstract CancelationResponse cancelar(String cer, String key, String rfc, String password, String uuid);

    /**
     * Método de cancelación enviando datos de PFX.
     * @param pfx
     * @param rfc
     * @param password
     * @param uuid
     * @return CancelationResponse
     * @see CancelationResponse
     */
    abstract CancelationResponse cancelar(String pfx, String rfc, String password, String uuid);

    /**
     * Método de cancelación enviando RFC emisor y UUID.
     * <p>
     * <b>Nota:</b> Es necesario tener configurado un Certificado
     * para el RFC emisor en su cuenta de SW.
     * @param rfc
     * @param uuid
     * @return CancelationResponse
     * @see CancelationResponse
     */
    abstract CancelationResponse cancelar(String rfc, String uuid);

    /**
     * Método de cancelación enviando un XML de cancelación sellado.
     * <b>Nota:</b> El XML de cancelación no es igual a un CFDI.
     * @param xmlCancelation
     * @return CancelationResponse
     */
    abstract CancelationResponse cancelar(String xmlCancelation);

    /**
     * Construye el json del request a partir de los datos.
     * @param pfx
     * @param rfc
     * @param password
     * @param uuid
     * @return String json
     */
    protected String requestCancelar(String pfx, String rfc, String password, String uuid) {
        CancelationRequestPFX objectRequest = new CancelationRequestPFX(uuid, password, rfc, pfx);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }

    /**
     * Construye el json del request a partir de los datos.
     * @param csd
     * @param key
     * @param rfc
     * @param password
     * @param uuid
     * @return String json
     */
    protected String requestCancelar(String csd, String key, String rfc, String password, String uuid) {
        CancelationRequestCSD objectRequest = new CancelationRequestCSD(uuid, password, rfc, csd, key);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * @return Map<String, String>
     */
    protected Map<String, String> getHeaders() {
        this.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }
}
