package mx.com.sw.helpers;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;

/**
 * <h1>GeneralHelpers</h1> Está clase contiene múltiples funciones de utilidad
 * que se utilizan a través de la librería.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public final class GeneralHelpers {
    private static final int SOCKET_TIMEOUT = 420000;
    private static final int CONNECT_TIMEOUT = 420000;
    private static final int REQUEST_TIMEOUT = 420000;

    /**
     * Constructor de la clase.
     */
    private GeneralHelpers() {
    }

    /**
     * Este método configura el proxy y timeout de las peticiones.
     * @param host
     * @param port
     * @return RequestConfig
     */
    public static RequestConfig setProxyAndTimeOut(String host, int port) {
        RequestConfig.Builder options = RequestConfig.custom();
        if (!stringEmptyOrNull(host)) {
            HttpHost proxy = new HttpHost(host, port);
            options.setProxy(proxy);
        }
        options.setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT)
            .setConnectionRequestTimeout(REQUEST_TIMEOUT);
        return options.build();
    }

    /**
     * Este método verifica si un String es nulo o está vacío.
     * @param st
     * @return true o false
     */
    public static boolean stringEmptyOrNull(String st) {
        return st == null || st.trim().isEmpty();
    }

    /**
     * Este método normaliza una URL.
     * @param url
     * @return url normalizada
     */
    public static String noralizeUrl(String url) {
        return !url.endsWith("/") ? url + "/" : url;
    }

    /**
     * Este método decodea un string base.
     * @param base64
     * @return string decodificado
     */
    public static String decodeBase64(String base64) {
        byte[] bytes = Base64.getDecoder().decode(base64);
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /**
     * Este método encodea bytes a string base64.
     * @param bytes
     * @return string codificado
     */
    public static String encodeBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
