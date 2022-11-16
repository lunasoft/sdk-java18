package mx.com.sw.services.acceptreject;

import java.util.ArrayList;
import java.util.List;
import mx.com.sw.exceptions.ServicesException;
import mx.com.sw.helpers.BuildSettings;
import mx.com.sw.services.acceptreject.requests.AcceptRejectItem;
import mx.com.sw.services.acceptreject.requests.EnumAcceptReject;
import mx.com.sw.services.acceptreject.responses.AcceptRejectResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * AcceptRejectTest Clase para UT del servicio de AcceptReject.
 * @author Dan Iñiguez
 * @version 0.0.1.0
 * @since 2021-08-17
 */
public class AcceptRejectTest {
    private final BuildSettings settings;

    /**
    * Constructor de la clase.
    */
    public AcceptRejectTest() {
        this.settings = new BuildSettings();
    }

    /**
    * Método de UT UUID con usuario y password.
    */
    @Disabled("uuids AcceptReject constant change")
    @Test
    public void testAcceptRejectUUID_User_success() {
        try {
            AcceptReject acceptReject = new AcceptReject(settings.getUrlSW(), settings.getUserSW(),
                    settings.getPasswordSW(), null, 0);
            AcceptRejectResponse res = acceptReject.setAction("XIA190128J61",
                "a98d4c19-8b05-4ab0-b231-8e4684a6e6c6", EnumAcceptReject.Aceptacion);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData().getFolios());
            Assertions.assertNotNull(res.getData().getFolios().get(0).getEstatusUUID());
            Assertions.assertNotNull(res.getData().getFolios().get(0).getUUID());
            Assertions.assertNotNull(res.getData().getFolios().get(0).getRespuesta());
            Assertions.assertNotNull(res.getData().getAcuse());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT UUID con token.
    */
    @Test
    public void testAcceptRejectUUID_Token_error() {
        try {
            AcceptReject acceptReject = new AcceptReject(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            AcceptRejectResponse res = acceptReject.setAction("XIA190128J01",
                "a98d4c19-8b05-4ab0-b231-8e4684a6e6c6", EnumAcceptReject.Aceptacion);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
            Assertions.assertTrue("CACFDI33 - Error no controlado".equals(res.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT PFX con token.
    */
    @Disabled("uuids AcceptReject constant change")
    @Test
    public void testAcceptRejectPFX_Token_success() {
        try {
            List<AcceptRejectItem> list = new ArrayList<AcceptRejectItem>() {{
                    add(new AcceptRejectItem("d056c249-a85d-45f3-a0f0-961afd29df8f", EnumAcceptReject.Aceptacion));
                }};
            String pfxBase64 = settings.getPFX();
            String password = settings.getPasswordCSD();
            String rfc = settings.getRFC();
            AcceptReject acceptReject = new AcceptReject(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            AcceptRejectResponse res = acceptReject.setAction(pfxBase64, rfc, password, list);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData().getFolios());
            Assertions.assertNotNull(res.getData().getFolios().get(0).getEstatusUUID());
            Assertions.assertNotNull(res.getData().getFolios().get(0).getUUID());
            Assertions.assertNotNull(res.getData().getFolios().get(0).getRespuesta());
            Assertions.assertNotNull(res.getData().getAcuse());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT CSD con token.
    */
    @Disabled("uuids AcceptReject constant change")
    @Test
    public void testAcceptRejectCSD_Token_success() {
        try {
            List<AcceptRejectItem> list = new ArrayList<AcceptRejectItem>() {{
                    add(new AcceptRejectItem("7FA1C269-25AA-4898-BA2C-7CBCF6DB694B", EnumAcceptReject.Aceptacion));
                    add(new AcceptRejectItem("6930A5C7-7225-4322-A013-4F2278763AC2", EnumAcceptReject.Aceptacion));
                }};
            String cer = settings.getCSD();
            String key = settings.getKey();
            String password = settings.getPasswordCSD();
            String rfc = settings.getRFC();
            AcceptReject acceptReject = new AcceptReject(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            AcceptRejectResponse res = acceptReject.setAction(cer, key, rfc, password, list);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("success".equals(res.getStatus()));
            Assertions.assertNotNull(res.getData().getFolios());
            Assertions.assertNotNull(res.getData().getFolios().get(0).getEstatusUUID());
            Assertions.assertNotNull(res.getData().getFolios().get(0).getUUID());
            Assertions.assertNotNull(res.getData().getFolios().get(0).getRespuesta());
            Assertions.assertNotNull(res.getData().getAcuse());
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }

    /**
    * Método de UT XML con token.
    */
    @Disabled("Disabled por intermitencia del SAT")
    @Test
    public void testAcceptRejectXML_Token_success() {
        try {
            String xml  = settings.getXMLAcceptReject();
            AcceptReject acceptReject = new AcceptReject(settings.getUrlSW(), settings.getTokenSW(), null, 0);
            AcceptRejectResponse res = acceptReject.setAction(xml);
            Assertions.assertNotNull(res);
            Assertions.assertTrue("error".equals(res.getStatus()));
            Assertions.assertTrue("305".equals(res.getCodStatus()));
            Assertions.assertTrue("CA305 - La fecha de emisión no esta dentro de la vigencia del CSD del Emisor.".
                    equals(res.getMessage()));
        } catch (ServicesException ex) {
            Assertions.assertNotNull(ex);
        }
    }
}
