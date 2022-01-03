package mx.com.sw.services.pendings.response;

import java.util.ArrayList;
import java.util.List;

/**
 * PendingsData Clase con la informacion de la respuesta de
 * Pendientes.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-26
 */
public class PendingsData {
    private List<String> uuid;

    /**
     * Obtiene una lista de uuids pendientes
     * Esté metodo funciona como setter de la manera
     * obj.getUUIDs.add(uuid).
     * @return List String uuids
     */
    public List<String> getUUIDs() {
        if (this.uuid == null) {
            this.uuid = new ArrayList<String>();
        }
        return this.uuid;
    }
}
