package mx.com.sw.services.StatusCfdi;

import java.io.IOException;
import javax.xml.soap.SOAPException;
import mx.com.sw.exceptions.GeneralException;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;

/**
 * La clase StatusCfdi proporciona métodos para obtener el estado del CFDI.
 */
public class StatusCfdi {
    private static final String URL_SAT = "https://consultaqr.facturaelectronica.sat.gob.mx/ConsultaCFDIService.svc";
    private StatusCfdiService Service;

    /**
     * Crea una instancia que consulta el estatus en el servicio de producción del SAT.
     */
    public StatusCfdi() {
        this(URL_SAT);
    }

    /**
     * Crea una instancia que consulta el estatus en el endpoint indicado.
     *
     * @param url URL del servicio ConsultaCFDIService.
     */
    public StatusCfdi(String url) {
        Service = new StatusCfdiService(url);
    }

    /**
     * Obtiene el estado del CFDI utilizando el servicio correspondiente.
     *
     * @param rfcEmisor          El RFC del emisor del CFDI.
     * @param rfcReceptor        El RFC del receptor del CFDI.
     * @param total              El total del CFDI.
     * @param uuid               El UUID del CFDI.
     * @param sello              El sello del CFDI (Últimos 8 caracteres).
     * @return                   El objeto StatusCfdiResponse que contiene la respuesta del servicio.
     * @throws ServicesException Si ocurre un error en el servicio.
     * @throws GeneralException  Si ocurre un error general.
     * @throws IOException       Si ocurre un error de entrada/salida.
     * @throws SOAPException     Si ocurre un error de SOAP.
     */
    public StatusCfdiResponse GetStatusCfdi(String rfcEmisor, String rfcReceptor, String total,
            String uuid, String sello)
            throws ServicesException, GeneralException, IOException, SOAPException {
        return Service.GetStatusCfdi(rfcEmisor, rfcReceptor, total, uuid, sello);
    }
}
