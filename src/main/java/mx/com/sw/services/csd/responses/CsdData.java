package mx.com.sw.services.csd.responses;

/**
 * CsdData Clase con la informacion retornada.
 */
public class CsdData {
    private String issuer_rfc;
    private String certificate_number;
    private String csd_certificate;
    private String is_active;
    private String issuer_business_name;
    private String valid_from;
    private String valid_to;
    private String certificate_type;

    /**
     * Retorna el RFC del certificado.
     * @return String
    */
    public String getIssuerRfc() {
        return issuer_rfc;
    }

    public void setIssuerRfc(String issuer_rfc) {
        this.issuer_rfc = issuer_rfc;
    }

    /**
     * Retorna el número del certificado.
     * @return String
    */
    public String getCertificateNumber() {
        return certificate_number;
    }

    public void setCertificateNumber(String certificate_number) {
        this.certificate_number = certificate_number;
    }

    /**
     * Retorna el certificado en B64.
     * @return String
    */
    public String getCsdCertificate() {
        return csd_certificate;
    }

    public void setCsdCertificate(String csd_certificate) {
        this.csd_certificate = csd_certificate;
    }

    /**
     * Retorna el estado del certificado.
     * true
     * false
     * @return String
    */
    public String getIsActive() {
        return is_active;
    }

    public void setIsActive(String is_active) {
        this.is_active = is_active;
    }

    /**
     * Retorna el nombre a quien esta el certificado.
     * @return String
    */
    public String getIssuerBusinessName() {
        return issuer_business_name;
    }

    public void setIssuerBusinessName(String issuer_business_name) {
        this.issuer_business_name = issuer_business_name;
    }

    /**
     * Retorna la fecha desde la cual es valido el certificado.
     * @return String
    */
    public String getValidFrom() {
        return valid_from;
    }

    public void setValidFrom(String valid_from) {
        this.valid_from = valid_from;
    }

    /**
     * Retorna la fecha hasta la cual es valido el certificado.
     * @return String
    */
    public String getValidTo() {
        return valid_to;
    }

    public void setValidTo(String valid_to) {
        this.valid_to = valid_to;
    }

    /**
     * Retorna el tipo de certificado.
     * Default = Stamp
     * @return String
    */
    public String getCertificateType() {
        return certificate_type;
    }

    public void setCertificateType(String certificate_type) {
        this.certificate_type = certificate_type;
    }
}
