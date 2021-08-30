package mx.com.sw.services.relations;

import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.relations.response.RelationsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-24
 */
public class RelationsTest {
    private final BuildSettings settings;

    /**
     * Constructor de la clase.
     */
    public RelationsTest() {
        this.settings = new BuildSettings();
    }

    /**
     * Método de UT UUID con usuario y password.
     */
    @Test
    public void testRelations_UUID_Data_Token_success() {
        try {
            String resultado = "WS Consulta CFDI relacionados RfcEmisor: EKU9003173C9 - folio físcal: "
                    + "106d7664-6a1d-4ec6-9c09-2aa27532ec59 - Clave: 2000 - Se encontraron CFDI relacionados";
            Relations relations = new Relations(settings.getUrlSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            RelationsResponse res = relations.getRelations(settings.getRFC(),
                    "106d7664-6a1d-4ec6-9c09-2aa27532ec59");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertTrue("106d7664-6a1d-4ec6-9c09-2aa27532ec59".equals(res.getData().getUUIDConsultado()));
            Assertions.assertTrue(resultado.equals(res.getData().getResultado()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT UUID con usuario y password.
     */
    @Test
    public void testRelations_UUID_uuidsRelacionadosPadres_Token_success() {
        try {
            Relations relations = new Relations(settings.getUrlSW(), settings.getUserSW(),
                   settings.getPasswordSW(), null, 0);
            RelationsResponse res = relations.getRelations(settings.getRFC(),
                    "106d7664-6a1d-4ec6-9c09-2aa27532ec59");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertTrue("B0CE4127-1DCB-4CB8-8204-8808E8163BED"
                    .equals(res.getData().getUUIDsRelacionadosPadres().get(0).getUUID()));
            Assertions.assertTrue("XIA190128J61"
                    .equals(res.getData().getUUIDsRelacionadosPadres().get(0).getRfcReceptor()));
            Assertions.assertTrue("EKU9003173C9"
                    .equals(res.getData().getUUIDsRelacionadosPadres().get(0).getRfcEmisor()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT UUID con usuario y password.
     */
    @Test
    public void testRelations_UUID_uuidsRelacionadosHijos_Token_success() {
        try {
            Relations relations = new Relations(settings.getUrlSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            RelationsResponse res = relations.getRelations(settings.getRFC(),
                    "106d7664-6a1d-4ec6-9c09-2aa27532ec59");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertTrue("106D7664-6A1D-4EC6-9C09-2AA27532EC59"
                    .equals(res.getData().getUUIDsRelacionadosHijos().get(0).getUUID()));
            Assertions.assertTrue("XIA190128J61"
                    .equals(res.getData().getUUIDsRelacionadosHijos().get(0).getRfcReceptor()));
            Assertions.assertTrue("EKU9003173C9"
                    .equals(res.getData().getUUIDsRelacionadosHijos().get(0).getRfcEmisor()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT UUID con usuario y password.
     */
    @Test
    public void testRelations_UUID_Response_Token_success() {
        try {
            Relations relations = new Relations(settings.getUrlSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            RelationsResponse res = relations.getRelations(settings.getRFC(),
                    "106d7664-6a1d-4ec6-9c09-2aa27532ec59");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertTrue("Se encontraron CFDI relacionados. ".equals(res.getMessage()));
            Assertions.assertTrue("2000".equals(res.getCodStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT UUID con usuario y password.
     */
    @Test
    public void testRelations_CSD_Response_Token_success() {
        try {
            String cer = settings.getCSD();
            String key = settings.getKey();
            String password = settings.getPasswordCSD();
            String rfc = settings.getRFC();
            Relations relations = new Relations(settings.getUrlSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            RelationsResponse res = relations.getRelations(cer, key, rfc, password,
                    "106d7664-6a1d-4ec6-9c09-2aa27532ec59");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertTrue("Se encontraron CFDI relacionados. ".equals(res.getMessage()));
            Assertions.assertTrue("2000".equals(res.getCodStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT UUID con usuario y password.
     */
    @Test
    public void testRelations_PFX_Response_Token_success() {
        try {
            String pfx = settings.getPFX();
            String password = settings.getPasswordCSD();
            String rfc = settings.getRFC();
            Relations relations = new Relations(settings.getUrlSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            RelationsResponse res = relations.getRelations(pfx, rfc, password,
                    "106d7664-6a1d-4ec6-9c09-2aa27532ec59");
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertTrue("Se encontraron CFDI relacionados. ".equals(res.getMessage()));
            Assertions.assertTrue("2000".equals(res.getCodStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
     * Método de UT UUID con usuario y password.
     */
    @Test
    public void testRelations_XML_Response_Token_success() {
        try {
            Relations relations = new Relations(settings.getUrlSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            String xml = settings.getXmlRelations();
            RelationsResponse res = relations.getRelations(xml);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
            Assertions.assertTrue("301  - Error no controlado".equals(res.getMessage()));
            Assertions.assertTrue("301 ".equals(res.getCodStatus()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
