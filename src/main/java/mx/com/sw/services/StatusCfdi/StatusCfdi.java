package mx.com.sw.services.StatusCfdi;

import mx.com.sw.exceptions.GeneralException;
import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;
import mx.com.sw.exceptions.ServicesException;

import java.io.IOException;
import javax.xml.soap.SOAPException;

public class StatusCfdi {
    private StatusCfdiService Service;

    public StatusCfdi() {
        Service = new StatusCfdiService();
    }

    public StatusCfdiResponse GetStatusCfdi(String rfcEmisor, String rfcReceptor, String total, String uuid, String sello) throws ServicesException, GeneralException, IOException, SOAPException {
        return Service.GetStatusCfdi(rfcEmisor, rfcReceptor, total, uuid, sello);
    }
    
}
