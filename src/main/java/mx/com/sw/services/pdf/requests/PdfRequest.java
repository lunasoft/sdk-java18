package mx.com.sw.services.pdf.requests;

import java.util.HashMap;
import java.util.Map;

/**
 * PdfRequest Clase estructura para request PDF.
 * @author Manuel Castillo
 * @version 0.0.0.1
 * @since 2020-12-14
 */
public class PdfRequest {
    private String xmlContent;
    private String logo;
    private String templateId;
    private Map<String, String> extras = new HashMap<String, String>();

    /**
     * Constructor default.
     * @param xmlContent XML correspondiente cfdi
     * @param templateId id del template a implementar
     */
    public PdfRequest(String xmlContent, String templateId) {
        this.xmlContent = xmlContent;
        this.templateId = templateId;
    }

    /**
     * Constructor default.
     * @param xmlContent XML correspondiente cfdi
     * @param logo String en b64 con el logo deseado
     * @param templateId id del template a implementar
     */
    public PdfRequest(String xmlContent, String logo, String templateId) {
        this.xmlContent = xmlContent;
        this.logo = logo;
        this.templateId = templateId;
    }

    /**
     * Constructor default.
     * @param xmlContent XML correspondiente cfdi
     * @param templateId id del template a implementar
     * @param extras Objeto Map con los atributos y valores extra deseados en el PDF
     **/
    public PdfRequest(String xmlContent, String templateId, Map<String, String> extras) {
        this.xmlContent = xmlContent;
        this.templateId = templateId;
        this.extras = extras;
    }

    /**
     * Constructor default.
     * @param xmlContent XML correspondiente cfdi
     * @param logo String en b64 con el logo deseado
     * @param templateId id del template a implementar
     * @param extras Objeto Map con los atributos y valores extra deseados en el PDF
     **/
    public PdfRequest(String xmlContent, String logo, String templateId, Map<String, String> extras) {
        this.xmlContent = xmlContent;
        this.logo = logo;
        this.templateId = templateId;
        this.extras = extras;
    }

    /**
     * Obtiene el xml a procesar.
     * @return String
     */
    public String getXmlContent() {
        return xmlContent;
    }

    public void setXmlContent(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    /**
     * Obtiene el logo en b64.
     * @return String
     */
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * Obtiene el template del cual se generara PDF.
     * @return String
     */
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * Obtiene extras parametros anexos al PDF.
     * @return String
     */
    public Map<String, String> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, String> extras) {
        this.extras = extras;
    }
}
