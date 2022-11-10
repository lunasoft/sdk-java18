package mx.com.sw.services.storage;

import java.util.Date;
import java.util.List;

public class StorageData {
    public Data data;

    public Data getData() {
        return this.data;
    }

    public class Data {

        public MetaData metaData;
        public List<Records> records;
        public String status;

        public MetaData getMetaData() {
            return this.metaData;
        }

        public List getRecords() {
            return this.records;
        }

        public String getStatus() {
            return this.status;
        }
    }

    public class Records {
        public String codigoCancelacion;
        public String statusSAT;
        public String urlPDF;
        public String urlAckCfdi;
        public String urlAckCancellation;
        public boolean hasAddenda;
        public String addenda;
        public String urlAddenda;
        public Date fechaGeneracionPdf;
        public String idDealer;
        public String idUser;
        public String version;
        public String serie;
        public String folio;
        public Date fecha;
        public String numeroCertificado;
        public Double subTotal;
        public Double descuento;
        public Double total;
        public String moneda;
        public Double tipoCambio;
        public String tipoDeComprobante;
        public String metodoPago;
        public String formaPago;
        public String condicionesPago;
        public String luegarExpedicion;
        public String emisorRfc;
        public String emisorNombre;
        public String regimenFiscal;
        public String receptorRfc;
        public String receptorNombre;
        public String residenciaFiscal;
        public String numRegIdTrib;
        public String usoCFDI;
        public Double totalImpuestosTraslados;
        public Double totalImpuestosRetencion;
        public Double trasladosIVA;
        public Double trasladosIEPS;
        public Double retencionesISR;
        public Double retencionesIVA;
        public Double retencionesIEPS;
        public Double totalImpuestosLocalesTraslados;
        public Double totalImpuestosLocalesRetencion;
        public String complementos;
        public String uuid;
        public Date fechaTimbrado;
        public String rfcProvCertif;
        public String selloCFD;
        public String urlXml;
        public String yearMonth;
        public boolean status;

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

        public Date getFechaGeneracionPdf() {
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

        public Date getFecha() {
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

        public Date getFechaTimbrado() {
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

    public class MetaData {

        public String page;
        public String perPage;
        public String pageCount;
        public String totalCount;
        public Links links;

        public String getPage() {
            return this.page;
        }

        public String getPerPage() {
            return this.perPage;
        }

        public String getPageCount() {
            return this.pageCount;
        }

        public String getTotalCount() {
            return this.totalCount;
        }

        public Links getLinks() {
            return this.links;
        }
    }

    public class Links {

        public String current;

        public String getCurrent() {
            return this.current;
        }
    }

}
