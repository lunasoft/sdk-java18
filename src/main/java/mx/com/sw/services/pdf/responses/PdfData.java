package mx.com.sw.services.pdf.responses;

/**
 * PdfData Clase con la informacion PDF retornado.
 * @author Manuel Castillo
 * @version 0.0.0.1
 * @since 2020-12-14
 */
public class PdfData {
    private String contentB64;
    private String contentSizeBytes;
    private String uuid;
    private String serie;
    private String folio;
    private String stampDate;
    private String issuedDate;
    private String rfcIssuer;
    private String rfcReceptor;
    private String total;

    /**
     * Retorna el PDF en b64.
     * @return String
    */
    public String getContentB64() {
        return contentB64;
    }

    public void setContentB64(String contentB64) {
        this.contentB64 = contentB64;
    }

    /**
     * Retorna el tamaño del documento impreso.
     * @return String
    */
    public String getContentSizeBytes() {
        return contentSizeBytes;
    }

    public void setContentSizeBytes(String contentSizeBytes) {
        this.contentSizeBytes = contentSizeBytes;
    }

    /**
     * Retorna el UUID del CFDI.
     * @return String
    */
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Retorna la serie del CFDI.
     * @return String
    */
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Retorna el folio del CFDI.
     * @return String
    */
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Retorna la fecha de timbre del CFDI.
     * @return String
    */
    public String getStampDate() {
        return stampDate;
    }

    public void setStampDate(String stampDate) {
        this.stampDate = stampDate;
    }

    /**
     * Retorna la fecha de generacion del CFDI.
     * @return String
    */
    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    /**
     * Retorna el RFC de emisor del CFDI.
     * @return String
    */
    public String getRfcIssuer() {
        return rfcIssuer;
    }

    public void setRfcIssuer(String rfcIssuer) {
        this.rfcIssuer = rfcIssuer;
    }

    /**
     * Retorna el RFC de receptor del CFDI.
     * @return String
    */
    public String getRfcReceptor() {
        return rfcReceptor;
    }

    public void setRfcReceptor(String rfcReceptor) {
        this.rfcReceptor = rfcReceptor;
    }

    /**
     * Retorna el total del CFDI.
     * @return String
    */
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
