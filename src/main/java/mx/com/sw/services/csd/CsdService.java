package mx.com.sw.services.csd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.Services;
import mx.com.sw.services.csd.requests.CsdRequest;

public abstract class CsdService extends Services{
    
    /**
    * Constructor de la clase.
    * @param url url Services
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected CsdService(String url, String user, String password, String proxy,
        int proxyPort) throws ServicesException {
        super(url, user, password, proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url Services
    * @param token token infinito de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    protected CsdService(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, proxy, proxyPort);
    }

    /**
     * Obtiene los headers minímos para su funcionamiento.
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
     * @param b64Cer  Certificado en base 64.
     * @param b64Key  Llave privada en base 64.
     * @param password Contraseña del certificado.
     * @return Gson, gson
     */
    protected String requestCsd(String b64Cer, String b64Key, String password) {
        CsdRequest request = new CsdRequest(b64Cer,b64Key,password);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(request);
    }
}
