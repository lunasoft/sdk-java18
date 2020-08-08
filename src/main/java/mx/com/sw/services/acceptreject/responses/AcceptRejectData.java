package mx.com.sw.services.acceptreject.responses;

import java.util.ArrayList;
import java.util.List;

/**
 * AcceptRejectData Clase con la informacion de la respuesta de
 * aceptación/rechazo.
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 */
public class AcceptRejectData {
    private String acuse;
    private List<AcceptRejectInvoiceStatus> folios;

    /**
     * Obtiene el acuse de cancelación.
     * @return String
     */
    public String getAcuse() {
        return this.acuse;
    }

    /**
     * Configura el acuse de cancelación.
     * @param acuse xml acuse.
     */
    public void setAcuse(String acuse) {
        this.acuse = acuse;
    }

    /**
     * Obtiene una lista de status con los folios.
     * Esté metodo funciona como setter de la manera
     * obj.getFolios.add(AcceptRejectInvoiceStatus).
     * @return List AcceptRejectInvoiceStatus
     */
    public List<AcceptRejectInvoiceStatus> getFolios() {
        if (this.folios == null) {
            this.folios = new ArrayList<AcceptRejectInvoiceStatus>();
        }
        return this.folios;
    }
}
