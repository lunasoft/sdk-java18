package mx.com.sw.services.resend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.sw.services.Services;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.resend.request.ResendRequest;

public abstract class ResendService extends Services {
    /**
     * Constructor de la clase.
     * 
     * @param url       url base de la API
     * @param urlapi    url base de la API servicios
     * @param user      correo o usuario de SW
     * @param password  password de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    protected ResendService(String url, String urlapi, String user, String password, String proxy,
            int proxyPort) throws ServicesException {
        super(url, urlapi, user, password, proxy, proxyPort);
    }

    /**
     * Constructor de la clase.
     * 
     * @param url       url base de la API
     * @param token     token infinito de SW.
     * @param proxy     ip o dominio de proxy (null si no se utiliza)
     * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
     * @throws ServicesException exception en caso de error.
     */
    protected ResendService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Obtiene los headers minímos para su funcionamiento.
     * 
     * @return Map String, String
     * @throws ServicesException exception en caso de error.
     */
    protected Map<String, String> getHeaders() throws ServicesException {
        super.setupRequest();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "bearer " + this.getToken());
        return headers;
    }

    /**
     * Crea el body del request.
     * 
     * @param uuid    uuid del comprobante.
     * @param correos lista de correos.
     * @return Gson, gson
     */
    protected String requestResend(String uuid, List<String> correos) {
        ResendRequest request = new ResendRequest(uuid, correos);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(request);
    }
}
