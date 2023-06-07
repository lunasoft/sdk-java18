package mx.com.sw.services.StatusCfdi;

import mx.com.sw.exceptions.GeneralException;
import mx.com.sw.services.StatusCfdi.request.StatusCfdiOptionsRequest;
import mx.com.sw.services.StatusCfdi.request.StatusCfdiRequest;
import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;
import mx.com.sw.exceptions.ServicesException;

import java.io.IOException;
import javax.xml.soap.SOAPException;

class StatusCfdiService {
    /**
     * Endpoint y Action necesarios a usar.
     * 
     * @param URL    La URL del servicio.
     * @param Action La acción a realizar.
     */
    private String URL = "https://consultaqr.facturaelectronica.sat.gob.mx/ConsultaCFDIService.svc";
    private String Action = "http://tempuri.org/IConsultaCFDIService/Consulta";

    /**
     * Obtiene el estado del CFDI.
     * 
     * @param rfcEmisor          El RFC del emisor.
     * @param rfcReceptor        El RFC del receptor.
     * @param total              El total del CFDI.
     * @param uuid               El UUID del CFDI.
     * @param sello              El sello  del CFDI.
     * @return                   El objeto StatusCfdiResponse que contiene la respuesta del servicio.
     * @throws ServicesException Si ocurre un error en el servicio.
     * @throws GeneralException  Si ocurre un error general.
     * @throws IOException       Si ocurre un error de entrada/salida.
     * @throws SOAPException     Si ocurre un error de SOAP.
     */
    StatusCfdiResponse GetStatusCfdi(String rfcEmisor, String rfcReceptor, String total, String uuid, String sello) throws ServicesException, GeneralException, IOException, SOAPException {
        StatusCfdiOptionsRequest settings = new StatusCfdiOptionsRequest(URL, Action, rfcEmisor, rfcReceptor, total, uuid, sello, null, 0);
        StatusCfdiRequest req = new StatusCfdiRequest();
        return req.sendRequest(settings);
    }
}