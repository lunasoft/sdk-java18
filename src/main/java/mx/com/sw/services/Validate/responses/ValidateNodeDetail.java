package mx.com.sw.services.Validate.responses;

import java.util.List;

/**
 * ValidateNodeDetail Clase con la informacion de los nodos de la validacion.
 */
public class ValidateNodeDetail {
    private String section;
    private List<ValidateDetailData> detail;

    /**
     * Retorna la seccion.
     * @return String
    */
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Retorna datos detallados de cada seccion.
     * @return objeto tipo ValidateDetailData
    */
    public List<ValidateDetailData> getDetailData() {
        return detail;
    }

    public void setDetailData(List<ValidateDetailData> detail) {
        this.detail = detail;
    }
}
