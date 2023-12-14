package mx.com.sw.services.storage;

import java.util.List;

/**
 * StorageData.
 */
public class StorageData {
    private List<Records> records;

    public List<Records> getRecords() {
        return this.records;
    }

    /**
     * Records.
     */
    public class Records {
        private String codigoCancelacion;
        private String statusSAT;
        private String urlPDF;
        private String urlAckCfdi;
        private String urlAckCancellation;
        private boolean hasAddenda;
        private String addenda;
        private String urlAddenda;
        private String fechaGeneracionPdf;
        private String idDealer;
        private String idUser;
        private String version;
        private String serie;
        private String folio;
        private String fecha;
        private String numeroCertificado;
        private Double subTotal;
        private Double descuento;
        private Double total;
        private String moneda;
        private Double tipoCambio;
        private String tipoDeComprobante;
        private String metodoPago;
        private String formaPago;
        private String condicionesPago;
        private String luegarExpedicion;
        private String emisorRfc;
        private String emisorNombre;
        private String regimenFiscal;
        private String receptorRfc;
        private String receptorNombre;
        private String residenciaFiscal;
        private String numRegIdTrib;
        private String usoCFDI;
        private Double totalImpuestosTraslados;
        private Double totalImpuestosRetencion;
        private Double trasladosIVA;
        private Double trasladosIEPS;
        private Double retencionesISR;
        private Double retencionesIVA;
        private Double retencionesIEPS;
        private Double totalImpuestosLocalesTraslados;
        private Double totalImpuestosLocalesRetencion;
        private String complementos;
        private String uuid;
        private String fechaTimbrado;
        private String rfcProvCertif;
        private String selloCFD;
        private String urlXml;
        private String yearMonth;
        private boolean status;

        public String getCodigoCancelacion() {
            return this.codigoCancelacion;
        }

        public String getStatusSAT() {
            return this.statusSAT;
        }

        public String getUrlPDF() {
            return this.urlPDF;
        }

        public String getUrlAckCfdi() {
            return this.urlAckCfdi;
        }

        public String getUrlAckCancellation() {
            return this.urlAckCancellation;
        }

        public boolean isHasAddenda() {
            return this.hasAddenda;
        }

        public String getAddenda() {
            return this.addenda;
        }

        public String getUrlAddenda() {
            return this.urlAddenda;
        }

        public String getFechaGeneracionPdf() {
            return this.fechaGeneracionPdf;
        }

        public String getIdDealer() {
            return this.idDealer;
        }

        public String getIdUser() {
            return this.idUser;
        }

        public String getVersion() {
            return this.version;
        }

        public String getSerie() {
            return this.serie;
        }

        public String getFolio() {
            return this.folio;
        }

        public String getFecha() {
            return this.fecha;
        }

        public String getNumeroCertificado() {
            return this.numeroCertificado;
        }

        public Double getSubTotal() {
            return this.subTotal;
        }

        public Double getDescuento() {
            return this.descuento;
        }

        public Double getTotal() {
            return this.total;
        }

        public String getMoneda() {
            return this.moneda;
        }

        public Double getTipoCambio() {
            return this.tipoCambio;
        }

        public String getTipoDeComprobante() {
            return this.tipoDeComprobante;
        }

        public String getMetodoPago() {
            return this.metodoPago;
        }

        public String getFormaPago() {
            return this.formaPago;
        }

        public String getCondicionesPago() {
            return this.condicionesPago;
        }

        public String getLuegarExpedicion() {
            return this.luegarExpedicion;
        }

        public String getEmisorRfc() {
            return this.emisorRfc;
        }

        public String getEmisorNombre() {
            return this.emisorNombre;
        }

        public String getRegimenFiscal() {
            return this.regimenFiscal;
        }

        public String getReceptorRfc() {
            return this.receptorRfc;
        }

        public String getReceptorNombre() {
            return this.receptorNombre;
        }

        public String getResidenciaFiscal() {
            return this.residenciaFiscal;
        }

        public String getNumRegIdTrib() {
            return this.numRegIdTrib;
        }

        public String getUsoCFDI() {
            return this.usoCFDI;
        }

        public Double getTotalImpuestosTraslados() {
            return this.totalImpuestosTraslados;
        }

        public Double getTotalImpuestosRetencion() {
            return this.totalImpuestosRetencion;
        }

        public Double getTrasladosIVA() {
            return this.trasladosIVA;
        }

        public Double getTrasladosIEPS() {
            return this.trasladosIEPS;
        }

        public Double getRetencionesISR() {
            return this.retencionesISR;
        }

        public Double getRetencionesIVA() {
            return this.retencionesIVA;
        }

        public Double getRetencionesIEPS() {
            return this.retencionesIEPS;
        }

        public Double getTotalImpuestosLocalesTraslados() {
            return this.totalImpuestosLocalesTraslados;
        }

        public Double getTotalImpuestosLocalesRetencion() {
            return this.totalImpuestosLocalesRetencion;
        }

        public String getComplementos() {
            return this.complementos;
        }

        public String getUuid() {
            return this.uuid;
        }

        public String getFechaTimbrado() {
            return this.fechaTimbrado;
        }

        public String getRfcProvCertif() {
            return this.rfcProvCertif;
        }

        public String getSelloCFD() {
            return this.selloCFD;
        }

        public String getUrlXml() {
            return this.urlXml;
        }

        public String getYearMonth() {
            return this.yearMonth;
        }

        public boolean isStatus() {
            return this.status;
        }
    }

}
