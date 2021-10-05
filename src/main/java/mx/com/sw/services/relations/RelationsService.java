package mx.com.sw.services.relations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;
import mx.com.sw.services.relations.requests.RelationsRequestCSD;
import mx.com.sw.services.relations.requests.RelationsRequestPFX;
import mx.com.sw.services.relations.response.RelationsResponse;

/**
 * RelationsService Servicio para implementación de facturas relacionadas.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-24
 */
public abstract class RelationsService extends Services {

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param user usuario de SW.
     * @param password password de SW.
     * @param proxy url o host a usar de proxy (null en caso de no usar).
     * @param proxyPort puerto a usar de proxy (cualquier valor en caso de no usar).
     * @throws ServicesException exception en caso de error.
     */
    protected RelationsService(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * @param url url de la API Rest.
     * @param token token infinito de SW.
     * @param proxy url o host a usar de proxy (null en caso de no usar).
     * @param proxyPort puerto a usar de proxy (cualquier valor en caso de no usar).
     * @throws ServicesException exception en caso de error.
     */
    protected RelationsService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    abstract RelationsResponse getRelations(String cer, String key, String rfc, String password,
        String uuid);

    abstract RelationsResponse getRelations(String xmlCancelation);

    abstract RelationsResponse getRelations(String pfx, String rfc, String password,
            String uuid);

    abstract RelationsResponse getRelations(String rfc, String uuid);

    /**
     * Obtiene los headers necesarios para el consumo del servicio.
     * @throws ServicesException exception en caso de error.
     * @return Map String, String
     */
    protected Map<String, String> getHeaders() throws ServicesException {
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
     * @param uuid lista uuids a tratar.
     * @return String json
     */
    protected String requestRelations(String pfx, String rfc, String password, String uuid) {
        RelationsRequestPFX objectRequest = new RelationsRequestPFX(uuid, password, rfc, pfx);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }

    /**
     * Construye el json del request a partir de los datos.
     * @param csd certificado del emisor.
     * @param key llave privada del emisor.
     * @param rfc rfc emisor.
     * @param password password de la llave privada.
     * @param uuid lista de uuid a tratar.
     * @return String json
     */
    protected String requestRelations(String csd, String key, String rfc, String password, String uuid) {
        RelationsRequestCSD objectRequest = new RelationsRequestCSD(uuid, password, rfc, csd, key);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(objectRequest);
    }
}
