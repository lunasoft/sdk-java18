package mx.com.sw.services.stamp;

import mx.com.sw.services.issue.IssueV2;

/**
* Servicio de Timbrado
* Está clase permite realizar el timbrado de un <b>XML sellado</b>.
* <b>Nota:</b> No es necesario generar una nueva instancia de está clase para cada documento.
* <b>Nota:</b> A diferencia de la clase Stamp, está clase regresa información del CFDI cuando
* ocurre el error "307. El CFDI proporcionado ya ha sido timbrado anteriormente".
* <p>
* Ejemplo de uso:
* <pre>
* StampV2 stamp = new StampV2("http://services.test.sw.com.mx", "demo", "123456789", null, 0);
* String xml = app.obtenCFDI(); //CFDI sellado de su aplicativo.
* StampResponseV1 response = stamp.timbrarV1(xml, false); //false significa que el XML no es base64.
* if("success".equalsIgnoreCase(response.getStatus()){
*    System.out.println(response.getData().getTFD());
* } else{ // ocurrió un error y en los mensajes podría haber información últil acerca del error.
*   if("307. El comprobante contiene un timbre previo.".equalsIgnoreCase(response.getMessage())) {
*       System.our.println(response.getData().getTFD())
*   } else {
*       System.out.println(response.getMessage());
*       System.out.println(response.getMessageDetail());
*   }
* }
* </pre>
* Si no se cuenta con la capacidad de tener el CFDI sellado, se puede hacer uso del servicio
* "IssueV2", donde se puede timbrar XML sin sellar.
* @see IssueV2
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class StampV2 extends BaseStampV2 {

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param user correo o usuario de SW
    * @param password password de SW.
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    public StampV2(String url, String user, String password, String proxy, int proxyPort) {
        super(url, user, password, "stamp", proxy, proxyPort);
    }

    /**
    * Constructor de la clase.
    * @param url url base de la API
    * @param token token infinito
    * @param proxy ip o dominio de proxy (null si no se utiliza)
    * @param proxyPort número de puerto de proxy (cualquier valor si proxy es null)
    */
    public StampV2(String url, String token, String proxy, int proxyPort) {
        super(url, token, "stamp", proxy, proxyPort);
    }
}
