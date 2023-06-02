package mx.com.sw.services.StatusCfdi;

import java.io.IOException;

import javax.xml.soap.SOAPException;

import mx.com.sw.exceptions.GeneralException;
import mx.com.sw.services.StatusCfdi.responses.StatusCancelationOptionsRequest;
import mx.com.sw.services.StatusCfdi.responses.StatusCancelationRequest;
import mx.com.sw.services.StatusCfdi.responses.StatusCfdiResponse;
import mx.com.sw.exceptions.ServicesException;

public class StatusCfdiService {
        private String URL = null;
        private String Action = null;
        public StatusCfdiService(String URL, String Action) {
        this.URL = URL;
        this.Action = Action;
    }

    public StatusCfdiResponse StatusCfdi(String rfcEmisor, String rfcReceptor, String total, String uuid, String sello) throws ServicesException, GeneralException, IOException, SOAPException { 
            StatusCancelationOptionsRequest settings = new StatusCancelationOptionsRequest(URL, Action, rfcEmisor, rfcReceptor, total, uuid, sello, null, 0);
            StatusCancelationRequest req = new StatusCancelationRequest();
            return req.sendRequest(settings);
    }
}