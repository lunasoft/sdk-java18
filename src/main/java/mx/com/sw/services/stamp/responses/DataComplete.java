package mx.com.sw.services.stamp.responses;

/**
* <h1>DataComplete</h1>
* Clase que contiene información acerca del timbrado.
* <p>
* <b>Nota:</b> Este campo puede ser null cuando ha surgido un error.
* @author  Juan Gamez
* @version 0.0.0.1
* @since   2020-08-01
*/
public class DataComplete {
    private String cfdi;
    private String cadenaOriginalSAT;
    private String noCertificadoSAT;
    private String noCertificadoCFDI;
    private String uuid;
    private String selloSAT;
    private String selloCFDI;
    private String fechaTimbrado;
    private String qrCode;

    /**
     * Obtiene el XML del CFDI ya timbrado.
     */
    public String getCFDI() {
        return this.cfdi;
    }

    /**
     * Obtiene la cadena original SAT del CFDI timbrado.
     */
    public String getCadenaOriginalSAT() {
        return this.cadenaOriginalSAT;
    }

    /**
     * Obtiene el número de certificado del PAC que timbró.
     */
    public String getNoCertificadoSAT() {
        return this.noCertificadoSAT;
    }

    /**
     * Obtiene el número del certificado del emisor del CFDI.
     */
    public String getNoCertificadoCFDI() {
        return this.noCertificadoCFDI;
    }

    /**
     * Obtiene el UUID del CFDI timbrado.
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Obtiene el UUID del CFDI timbrado.
     */
    public String getSelloSAT() {
        return this.selloSAT;
    }

    /**
     * Obtiene el Sello del CFDI timbrado.
     */
    public String getSelloCFDI() {
        return this.selloCFDI;
    }

    /**
     * Obtiene la fecha de timbrado del CFDI.
     */
    public String getFechaTimbrado() {
        return this.fechaTimbrado;
    }

    /**
     * Obtiene la imagen PNG del QR en formato base64.
     */
    public String getQrCode() {
        return this.qrCode;
    }

    /**
     * Configura el valor CFDI.
     */
    protected void setCFDI(String cfdiValue) {
        this.cfdi = cfdiValue;
    }

    /**
     * Configura el valor cadena original SAT del CFDI timbrado.
     */
    protected void setCadenaOriginalSAT(String cadenaOriginalSATValue) {
        this.cadenaOriginalSAT = cadenaOriginalSATValue;
    }

    /**
     * Configura el número de certificado del PAC que timbró.
     */
    protected void setNoCertificadoSAT(String noCertificadoSATValue) {
        this.noCertificadoSAT = noCertificadoSATValue;
    }

    /**
     * Configura el número del certificado del emisor del CFDI.
     */
    protected void setNoCertificadoCFDI(String noCertificadoCFDIValue) {
        this.noCertificadoCFDI = noCertificadoCFDIValue;
    }

    /**
     * Configura el UUID del CFDI timbrado.
     */
    protected void setUUID(String uuidValue) {
        this.uuid = uuidValue;
    }

    /**
     * Configura el UUID del CFDI timbrado.
     */
    protected void setSelloSAT(String selloSATValue) {
        this.selloSAT = selloSATValue;
    }

    /**
     * Configura el Sello del CFDI timbrado.
     */
    protected void setSelloCFDI(String selloCFDIValue) {
        this.selloCFDI = selloCFDIValue;
    }

    /**
     * Configura la fecha de timbrado del CFDI.
     */
    protected void setFechaTimbrado(String fechaTimbradoValue) {
        this.fechaTimbrado = fechaTimbradoValue;
    }

    /**
     * Configura la imagen PNG del QR en formato base64.
     */
    protected void setQrCode(String qrCodeValue) {
        this.qrCode = qrCodeValue;
    }
}
