package mx.com.sw.services.acceptreject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.sw.services.Services;
import mx.com.sw.services.acceptreject.requests.AcceptRejectItem;
import mx.com.sw.services.acceptreject.requests.AcceptRejectRequestCSD;
import mx.com.sw.services.acceptreject.requests.AcceptRejectRequestPFX;
import mx.com.sw.services.acceptreject.requests.EnumAcceptReject;
import mx.com.sw.services.acceptreject.responses.AcceptRejectResponse;

/**
 * AcceptRejectService Servicio para implementación de aceptación/rechazo.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public abstract class AcceptRejectService extends Services {

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param user usuario de SW.
     * @param password password de SW.
     * @param proxy url o host a usar de proxy (null en caso de no usar).
     * @param proxyPort puerto a usar de proxy (cualquier valor en caso de no usar).
     */
    protected AcceptRejectService(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param token token infinito de SW.
     * @param proxy url o host a usar de proxy (null en caso de no usar).
     * @param proxyPort puerto a usar de proxy (cualquier valor en caso de no usar).
     */
    protected AcceptRejectService(String url, String token, String proxy, int proxyPort) {
        super(url, token, proxy, proxyPort);
    }

    abstract AcceptRejectResponse acceptRejectRequest(String cer, String key, String rfc, String password,
        List<AcceptRejectItem> uuids);

    abstract AcceptRejectResponse acceptRejectRequest(String xmlCancelation);

    abstract AcceptRejectResponse acceptRejectRequest(String pfx, String rfc, String password,
        List<AcceptRejectItem> uuids);

    abstract AcceptRejectResponse acceptRejectRequest(String rfc, String uuid, EnumAcceptReject action);

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

    /**
     * Construye el json del request a partir de los datos.
     * @param pfx pfx base64.
     * @param rfc rfc emisor.
     * @param password passwor pfx.
     * @param uuids lista uuids a tratar.
     * @return String json
     */
    protected String requestCancelar(String pfx, String rfc, String password, List<AcceptRejectItem> uuids) {
        AcceptRejectRequestPFX objectRequest = new AcceptRejectRequestPFX(uuids, password, rfc, pfx);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }

    /**
     * Construye el json del request a partir de los datos.
     * @param csd certificado del emisor.
     * @param key llave privada del emisor.
     * @param rfc rfc emisor.
     * @param password password de la llave privada.
     * @param uuids lista de uuid a tratar.
     * @return String json
     */
    protected String requestCancelar(String csd, String key, String rfc, String password,
        List<AcceptRejectItem> uuids) {
        AcceptRejectRequestCSD objectRequest = new AcceptRejectRequestCSD(uuids, password, rfc, csd, key);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }
}
