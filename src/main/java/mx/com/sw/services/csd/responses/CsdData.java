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
     * Retorna el RFC del certificado
     * @return String
    */
    public String getIssuer_rfc() {
        return issuer_rfc;
    }

    public void setIssuer_rfc(String issuer_rfc) {
        this.issuer_rfc = issuer_rfc;
    }

    /**
     * Retorna el número del certificado
     * @return String
    */
    public String getCertificate_number() {
        return certificate_number;
    }

    public void setCertificate_number(String certificate_number) {
        this.certificate_number = certificate_number;
    }

    /**
     * Retorna el certificado en B64
     * @return String
    */
    public String getCsd_certificate() {
        return csd_certificate;
    }

    public void setCsd_certificate(String csd_certificate) {
        this.csd_certificate = csd_certificate;
    }

    /**
     * Retorna el estado del certificado
     * true 
     * false 
     * @return String
    */
    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    /**
     * Retorna el nombre a quien esta el certificado
     * @return String
    */
    public String getIssuer_business_name() {
        return issuer_business_name;
    }

    public void setIssuer_business_name(String issuer_business_name) {
        this.issuer_business_name = issuer_business_name;
    }

    /**
     * Retorna la fecha desde la cual es valido el certificado
     * @return String
    */
    public String getValid_from() {
        return valid_from;
    }

    public void setValid_from(String valid_from) {
        this.valid_from = valid_from;
    }

    /**
     * Retorna la fecha hasta la cual es valido el certificado
     * @return String
    */
    public String getValid_to() {
        return valid_to;
    }

    public void setValid_to(String valid_to) {
        this.valid_to = valid_to;
    }

    /**
     * Retorna el tipo de certificado
     * Default = Stamp
     * @return String
    */
    public String getCertificate_type() {
        return certificate_type;
    }

    public void setCertificate_type(String certificate_type) {
        this.certificate_type = certificate_type;
    }
}
