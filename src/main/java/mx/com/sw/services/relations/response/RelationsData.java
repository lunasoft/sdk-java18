package mx.com.sw.services.relations.response;

import java.util.ArrayList;
import java.util.List;

/**
 * RelationsData Clase con la informacion de la respuesta de
 * Relations.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-24
 */
public class RelationsData {
    private String uuidConsultado;
    private String resultado;
    private List<RelationsUUIDs> uuidsRelacionadosPadres;
    private List<RelationsUUIDs> uuidsRelacionadosHijos;

    /**
     * Obtiene el uuidConsultado de relations.
     * @return String
     */
    public String getUUIDConsultado() {
        return this.uuidConsultado;
    }

    /**
     * Configura el uuidConsultado de relations.
     * @param value uuidConsultado.
     */
    public void setUUIDConsultado(String value) {
        this.uuidConsultado = value;
    }

    /**
     * Obtiene el resultadoRelacionados de relations.
     * @return String
     */
    public String getResultado() {
        return this.resultado;
    }

    /**
     * Configura el resultadoRelacionados de relations.
     * @param value resultadoRelacionados.
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

    /**
     * Obtiene una lista de uuidsRelacionados padre UUID, RfcReceptor, RfcEmisor.
     * Esté metodo funciona como setter de la manera
     * obj.getUUIDsRelacionadosPadres.add(RelationsUUIDs).
     * @return List RelationsUUIDs
     */
    public List<RelationsUUIDs> getUUIDsRelacionadosPadres() {
        if (this.uuidsRelacionadosPadres == null) {
            this.uuidsRelacionadosPadres = new ArrayList<RelationsUUIDs>();
        }
        return this.uuidsRelacionadosPadres;
    }

    /**
     * Obtiene una lista de uuidsRelacionados hijo UUID, RfcReceptor, RfcEmisor.
     * Esté metodo funciona como setter de la manera
     * obj.getUUIDsRelacionadosHijos.add(RelationsUUIDs).
     * @return List RelationsUUIDs
     */
    public List<RelationsUUIDs> getUUIDsRelacionadosHijos() {
        if (this.uuidsRelacionadosHijos == null) {
            this.uuidsRelacionadosHijos = new ArrayList<RelationsUUIDs>();
        }
        return this.uuidsRelacionadosHijos;
    }
}
