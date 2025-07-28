package mx.com.sw.services.stampretention;

import mx.com.sw.exceptions.ServicesException;

/**
* Servicio de Timbrado de Retenciones
* Está clase permite realizar el timbrado de un <b>XML de retención sellado</b>.
*/
public class StampRetention extends BaseStampRetention {

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public StampRetention(String url, String user, String password, String proxy, int proxyPort) throws ServicesException {
        super(url, user, password, "stamp", proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    * @throws ServicesException exception en caso de error.
    */
    public StampRetention(String url, String token, String proxy, int proxyPort) throws ServicesException {
        super(url, token, "stamp", proxy, proxyPort);
    }
} 