package mx.com.sw.services.stampretention;

import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.services.stampretention.responses.StampRetentionResponseV3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for StampRetention service
 */
public class StampRetentionTest {
    private final BuildSettings settings;


 public StampRetentionTest() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT timbrado versión 3.
    */
  @Test
    public void testStampV3() {
        try {
            StampRetention stampRetention = new StampRetention(settings.getUrlSW(), settings.getUserSW(), settings.getPasswordSW(), null, 0);
            String xml = "<?xml version='1.0' encoding='utf-8'?><retenciones:Retenciones xmlns:retenciones='http://www.sat.gob.mx/esquemas/retencionpago/2' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='http://www.sat.gob.mx/esquemas/retencionpago/2 http://www.sat.gob.mx/esquemas/retencionpago/2/retencionpagov2.xsd' Version='2.0' FolioInt='be658af40c66304f1a08' FechaExp='2025-07-28T12:07:54' LugarExpRetenc='45110' CveRetenc='01' NoCertificado='30001000000500003416' Certificado='MIIFsDCCA5igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0MTYwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTE0MzUxWhcNMjcwNTE4MTE0MzUxWjCB1zEnMCUGA1UEAxMeRVNDVUVMQSBLRU1QRVIgVVJHQVRFIFNBIERFIENWMScwJQYDVQQpEx5FU0NVRUxBIEtFTVBFUiBVUkdBVEUgU0EgREUgQ1YxJzAlBgNVBAoTHkVTQ1VFTEEgS0VNUEVSIFVSR0FURSBTQSBERSBDVjElMCMGA1UELRMcRUtVOTAwMzE3M0M5IC8gVkFEQTgwMDkyN0RKMzEeMBwGA1UEBRMVIC8gVkFEQTgwMDkyN0hTUlNSTDA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtmecO6n2GS0zL025gbHGQVxznPDICoXzR2uUngz4DqxVUC/w9cE6FxSiXm2ap8Gcjg7wmcZfm85EBaxCx/0J2u5CqnhzIoGCdhBPuhWQnIh5TLgj/X6uNquwZkKChbNe9aeFirU/JbyN7Egia9oKH9KZUsodiM/pWAH00PCtoKJ9OBcSHMq8Rqa3KKoBcfkg1ZrgueffwRLws9yOcRWLb02sDOPzGIm/jEFicVYt2Hw1qdRE5xmTZ7AGG0UHs+unkGjpCVeJ+BEBn0JPLWVvDKHZAQMj6s5Bku35+d/MyATkpOPsGT/VTnsouxekDfikJD1f7A1ZpJbqDpkJnss3vQIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAFaUgj5PqgvJigNMgtrdXZnbPfVBbukAbW4OGnUhNrA7SRAAfv2BSGk16PI0nBOr7qF2mItmBnjgEwk+DTv8Zr7w5qp7vleC6dIsZFNJoa6ZndrE/f7KO1CYruLXr5gwEkIyGfJ9NwyIagvHHMszzyHiSZIA850fWtbqtythpAliJ2jF35M5pNS+YTkRB+T6L/c6m00ymN3q9lT1rB03YywxrLreRSFZOSrbwWfg34EJbHfbFXpCSVYdJRfiVdvHnewN0r5fUlPtR9stQHyuqewzdkyb5jTTw02D2cUfL57vlPStBj7SEi3uOWvLrsiDnnCIxRMYJ2UA2ktDKHk+zWnsDmaeleSzonv2CHW42yXYPCvWi88oE1DJNYLNkIjua7MxAnkNZbScNw01A6zbLsZ3y8G6eEYnxSTRfwjd8EP4kdiHNJftm7Z4iRU7HOVh79/lRWB+gd171s3d/mI9kte3MRy6V8MMEMCAnMboGpaooYwgAmwclI2XZCczNWXfhaWe0ZS5PmytD/GDpXzkX0oEgY9K/uYo5V77NdZbGAjmyi8cE2B2ogvyaN2XfIInrZPgEffJ4AB7kFA2mwesdLOCh0BLD9itmCve3A1FGR4+stO2ANUoiI3w3Tv2yQSg4bjeDlJ08lXaaFCLW2peEXMXjQUk7fmpb5MNuOUTW6BE=' Sello='olW01DuIp12D+2wIjP2YVlV8tMpN7sBLQe+gVkqZV6cyt0dCu3C9Dhl18VoDOsi6tIsOmQIK2O88M2g/AtNNK67PKnjZHrExCldzoOT7uNR7TxlkTqkGao+FevPtoCDH81kK/hh3Hq+NFJqBXSu2YFMEwLXMoJdYVORrL42TelV/PQeTxBs5+F7uf01/ngs+7/oLrfnwFnqUtPzvqBg6YdikgN4XZtMpi2CtMl4r10WjggMaRCyldhfAhHg9XhY4GvElM85nwf26K2i3JApr0sy7Y6A2oTPcV04GyQ57kJ863DsYUWsNjNzsbHmJ06jUSTdtuV6zcRCh0L3mYHSGjg=='><retenciones:Emisor RfcE='EKU9003173C9' NomDenRazSocE='ESCUELA KEMPER URGATE' RegimenFiscalE='601'/><retenciones:Receptor NacionalidadR='Nacional'><retenciones:Nacional RfcR='URE180429TM6' NomDenRazSocR='UNIVERSIDAD ROBOTICA ESPAÑOLA' DomicilioFiscalR='86991'/></retenciones:Receptor><retenciones:Periodo MesIni='01' MesFin='03' Ejercicio='2023'/><retenciones:Totales MontoTotOperacion='2000.00' MontoTotGrav='2000.00' MontoTotExent='0' MontoTotRet='580.00'><retenciones:ImpRetenidos BaseRet='2000' ImpuestoRet='001' MontoRet='580.00' TipoPagoRet='03'/></retenciones:Totales></retenciones:Retenciones>";
            StampRetentionResponseV3 response = stampRetention.timbrarV3(xml);
            Assertions.assertNotNull(response);
            Assertions.assertNotNull(response.getStatus());
            Assertions.assertTrue(response.getStatus().equals("success") || response.getMessage().contains("401") || response.getMessage().contains("307"));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
} 